package com.acorp.ventimetriquadri.app.event;


import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.branch.BranchRepository;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceEvent;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceRepository;
import com.acorp.ventimetriquadri.app.event.utils.EventStatus;
import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import com.acorp.ventimetriquadri.app.event.workstations.WorkstationService;
import com.acorp.ventimetriquadri.app.relations.branch_event.BranchEventStorage;
import com.acorp.ventimetriquadri.app.relations.branch_event.BranchEventStorageRepository;
import com.acorp.ventimetriquadri.app.relations.event_workstation.EventWorkstationRelation;
import com.acorp.ventimetriquadri.app.relations.event_workstation.EventWorkstationRepository;
import com.acorp.ventimetriquadri.app.relations.workstation_product.R_WorkstationProduct;
import com.acorp.ventimetriquadri.app.storage.Storage;
import com.acorp.ventimetriquadri.app.storage.StorageRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Thread.sleep;

@Service
@AllArgsConstructor
public class EventService {

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BranchEventStorageRepository eventBranchStorageRepository;

    @Autowired
    private ExpenceRepository expenceRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private EventWorkstationRepository eventWorkstationRepository;

    @Autowired
    private WorkstationService workstationService;

    @Transactional
    public Event createEvent(Event event) {

        if(event == null){
            throw new IllegalArgumentException("Errore - Impossibile creare un evento con request NULL");
        }else if(event.getBranchId() == 0){
            throw new IllegalArgumentException("Errore - Impossibile creare un evento senza specificare il branch a cui associarlo");
        }else if(event.getStorageId() == 0){
            throw new IllegalArgumentException("Errore - Impossibile creare un evento senza specificare il magazzino a cui associarlo");
        }else if(!storageRepository.findById(event.getStorageId()).isPresent()){
            throw new IllegalArgumentException("Errore - Impossibile creare l'evento. Nessun magazzino con id [" + event.getStorageId() + "] trovato.");
        }else if(!branchRepository.findById(event.getBranchId()).isPresent()){
            throw new IllegalArgumentException("Errore - Impossibile creare l'evento. Nessun branch con id [" + event.getBranchId() + "] trovato. Body [" + event.toString() + "]");
        }else{
            logger.info("Creazione dell'evento " + event.toString());
            Event eventSaved = eventRepository.save(event);

            eventBranchStorageRepository.save(
                    BranchEventStorage.builder()
                            .event(eventSaved)
                            .storage(Storage.builder().storageId(event.getStorageId()).build())
                            .branch(Branch.builder().branchId(event.getBranchId()).build())
                            .build());

            for(Workstation workstation : event.getWorkstations()){
                workstation.setEventId(eventSaved.getEventId());
                Workstation workstationSaved = workstationService.createWorkstation(workstation);
                eventWorkstationRepository.save(EventWorkstationRelation
                        .builder()
                        .workstation(workstationSaved)
                        .event(eventSaved)
                        .build());
            }
            return eventSaved;
        }
    }

    @Transactional
    public Workstation createWorkstation(Workstation workstation){
        if(workstation == null){
            throw new IllegalArgumentException("Errore - Impossibile creare una workstation con request NULL");
        }else if(workstation.getEventId() == 0){
            throw new IllegalArgumentException("Errore - Impossibile creare una workstation senza specificare l'evento a cui associarla");
        }else if(!eventRepository.findById(workstation.getEventId()).isPresent()){
            throw new IllegalArgumentException("Errore - Impossibile creare la workstaion. Nessun evento con id [" + workstation.getEventId() + "] trovato. Body [" + workstation.toString() + "]");
        }
        logger.info("Creazione della workstation " + workstation.toString() + " . Associata all'evento con id " + workstation.getEventId());

        Workstation savedWorkstation = workstationService.createWorkstation(workstation);

        eventWorkstationRepository.save(
                EventWorkstationRelation
                        .builder()
                        .event(Event.builder().eventId(workstation.getEventId()).build())
                        .workstation(savedWorkstation).build()
        );

        return savedWorkstation;
    }


    @Transactional
    public void deleteEvent(long eventId){

        logger.info("Eliminazione dell'evento con id " + eventId + " in corso..");
        Optional<Event> eventToDelete = eventRepository.findById(eventId);

        if(eventToDelete.isPresent()){

            List<Workstation> workstationsToDeleteList = eventWorkstationRepository.findAllWorkstationsByEvent(eventToDelete.get());
            for(Workstation workstation : workstationsToDeleteList){
                workstationService.removeWorkstation(workstation.getWorkstationId());
            }

            expenceRepository.removeByEventId(eventId);

            eventBranchStorageRepository.deleteByEvent(Event.builder().eventId(eventId).build());
            eventRepository.deleteById(eventId);
        }else{
            logger.info("L'evento con id " + eventId + " risulta già rimosso");
        }
    }

    @Transactional
    public void update(Event event) {
        Optional<Event> updatingBranch = eventRepository.findById(event.getEventId());

        if(!updatingBranch.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato eventi da aggiornare");

        }else{

            if(updatingBranch.get().getName() != event.getName())
                updatingBranch.get().setName(event.getName());

            if(updatingBranch.get().getEventStatus() != event.getEventStatus())
                updatingBranch.get().setEventStatus(event.getEventStatus());

            if(updatingBranch.get().getLocation() != event.getLocation())
                updatingBranch.get().setLocation(event.getLocation());

        }
    }

    public List<BranchEventStorage> findAllByBranchId(Branch branch) {
        List<BranchEventStorage> allBranchEventStorage = eventBranchStorageRepository.findByBranchId(branch);
        for(BranchEventStorage branchEventStorage : allBranchEventStorage){
            branchEventStorage.getEvent().setExpenceEvents(expenceRepository.findAllByEventId(branchEventStorage.getEvent().getEventId()));
        }
        return allBranchEventStorage;
    }

    public List<Event> findOpenEventsByBranchId(long branchId) {
        return findEventsByBranchIdWithEventState(branchId, EventStatus.APERTO);
    }

    public List<Event> findClosedEventByBranchId(long branchId) {
        return findEventsByBranchIdWithEventState(branchId, EventStatus.CHIUSO);
    }

    private List<Event> findEventsByBranchIdWithEventState(long branchId, EventStatus status) {
        logger.info("Ricerca eventi per branch con id [" + branchId + "] e stato evento " + status.name());

        List<Event> events = new ArrayList<>();

        List<BranchEventStorage> allByBranchId = eventBranchStorageRepository.findByBranchId(Branch.builder().branchId(branchId).build());


        for(BranchEventStorage branchEventStorageService : allByBranchId){
            if(branchEventStorageService.getEvent().getEventStatus() == status){
                branchEventStorageService.getEvent().setStorageId(branchEventStorageService.getStorage().getStorageId());
                branchEventStorageService.getEvent().setBranchId(branchEventStorageService.getBranch().getBranchId());
                events.add(branchEventStorageService.getEvent());
            }
        }

        for(Event event : events){
            List<Workstation> allWorkstationsByEvent = eventWorkstationRepository.findAllWorkstationsByEvent(event);
            for(Workstation workstation : allWorkstationsByEvent){
                workstation.setProducts(workstationService.retrieveAllProductByWorkstationId(workstation.getWorkstationId()));
            }
            event.setWorkstations(allWorkstationsByEvent);
            event.setExpenceEvents(expenceRepository.findAllByEventId(event.getEventId()));

        }
        return events;
    }

    public Event findOpenEventsByEventId(long eventId) {
        logger.info("Ricerca eventi per event id [" + eventId + "]");

        Optional<Event> eventById = eventRepository.findById(eventId);
        if(eventById.isPresent()){
            eventById.get().setWorkstations(eventWorkstationRepository.findAllWorkstationsByEvent(eventById.get()));
            eventById.get().setExpenceEvents(expenceRepository.findAllByEventId(eventById.get().getEventId()));
            return eventById.get();
        }else{
            throw new IllegalArgumentException("Errore - Nessun evento trovato per l'id [" + eventId + "]");
        }
    }

    @Transactional
    public void deleteEventExpence(ExpenceEvent expenceEvent){
        logger.info("Delete Event Expence : " + expenceEvent.toString());
        expenceRepository.delete(expenceEvent);
    }


    @Transactional
    public void closeEvent(long eventId) {
        if(eventId == 0){
            throw new IllegalArgumentException("Errore - Impossibile chiudere l'evento. L'id dell'evento è 0.");
        }

        logger.info("Chiusura dell 'evento con id[" + eventId + "] in corso..");

        Optional<Event> eventOpt = eventRepository.findById(eventId);
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(eventOpt.isPresent()){

            eventOpt.get().setEventStatus(EventStatus.CHIUSO);
            List<Workstation> allWorkstationsByEvent = eventWorkstationRepository
                    .findAllWorkstationsByEvent(Event.builder().eventId(eventId).build());

            logger.info("Riporto la giacenza dei prodotti in magazzino ..");

            for(Workstation workstation : allWorkstationsByEvent){
                List<R_WorkstationProduct> r_workstationProducts = workstationService.retrieveAllProductByWorkstationId(workstation.getWorkstationId());

                for(R_WorkstationProduct r_workstationProduct : r_workstationProducts){
                    workstationService.reloadNotConsumedAmountOfworkstationIntoReferredStorage(r_workstationProduct.getWorkstationProductId());
                }
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            throw new IllegalArgumentException("Errore - Impossibile chiudere l'evento " + eventId +". Non è stato possibile recuperare le informazioni tramite l'id evento " + eventId);
        }
    }


    // EXPENCE SERVICES

    public void deleteEvent(ExpenceEvent expenceEvent){
        expenceRepository.deleteById(expenceEvent.getExpenceId());
    }

    public List<ExpenceEvent> findAll() {
        return expenceRepository.findAll();
    }

    @Transactional
    public ExpenceEvent updateExpence(ExpenceEvent expenceEvent) {
        Optional<ExpenceEvent> updatingEventExpence = expenceRepository.findById(expenceEvent.getExpenceId());
        if(!updatingEventExpence.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato spese eventi da aggiornare");
        }else{
            if(updatingEventExpence.get().getAmount() != expenceEvent.getAmount())
                updatingEventExpence.get().setAmount(expenceEvent.getAmount());

            if(updatingEventExpence.get().getDescription() != expenceEvent.getDescription())
                updatingEventExpence.get().setDescription(expenceEvent.getDescription());

            return updatingEventExpence.get();
        }
    }

    public List<ExpenceEvent> findExpencesByEventId(long eventId) {
        return expenceRepository.findAllByEventId(eventId);
    }

    @Transactional
    public ExpenceEvent saveExpence(ExpenceEvent expenceEvent) {

        if(expenceEvent.getEventId() == 0){
            throw new IllegalStateException("Errore. L'oggetto expence non è valido. Il campo eventId non può essere nullo o vuoto. Expence Body: " + expenceEvent.toString());
        }else{
            return expenceRepository.save(expenceEvent);
        }
    }


}
