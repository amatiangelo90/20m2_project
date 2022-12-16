package com.acorp.ventimetriquadri.app.event;


import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.branch.BranchRepository;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceEvent;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceRepository;
import com.acorp.ventimetriquadri.app.event.utils.EventStatus;
import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import com.acorp.ventimetriquadri.app.event.workstations.WorkstationRepository;
import com.acorp.ventimetriquadri.app.relations.branch_event.BranchEventStorage;
import com.acorp.ventimetriquadri.app.relations.branch_event.BranchEventStorageRepository;
import com.acorp.ventimetriquadri.app.relations.event_expence.EventExpenceRelation;
import com.acorp.ventimetriquadri.app.relations.event_expence.EventExpenceRepository;
import com.acorp.ventimetriquadri.app.relations.event_workstation.EventWorkstationRelation;
import com.acorp.ventimetriquadri.app.relations.event_workstation.EventWorkstationRepository;
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

@Service
@AllArgsConstructor
public class EventService {

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventExpenceRepository eventExpenceRepository;

    @Autowired
    private BranchEventStorageRepository branchEventStorageRepository;

    @Autowired
    private ExpenceRepository expenceRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private WorkstationRepository workstationRepository;

    @Autowired
    private EventWorkstationRepository eventWorkstationRepository;




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
            branchEventStorageRepository.save(
                    BranchEventStorage.builder()
                            .event(eventSaved)
                            .storage(Storage.builder().storageId(event.getStorageId()).build())
                            .branch(Branch.builder().branchId(event.getStorageId()).build())
                            .build());
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

        Workstation savedWorkstation = workstationRepository.save(workstation);

        eventWorkstationRepository.save(
                EventWorkstationRelation
                        .builder()
                        .event(Event.builder().eventId(workstation.getEventId()).build())
                        .workstation(savedWorkstation).build()
        );

        return savedWorkstation;
    }


    public void deleteExpence(Event event){
        eventRepository.deleteById(event.getEventId());
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
        List<BranchEventStorage> allBranchEventStorage = branchEventStorageRepository.findByBranchId(branch);
        for(BranchEventStorage branchEventStorage : allBranchEventStorage){
            branchEventStorage.getEvent().setExpenceEvents(expenceRepository.findAllByEventId(branchEventStorage.getEvent().getEventId()));
        }
        return allBranchEventStorage;
    }

    public List<Event> findOpenEventsByBranchId(long branchId) {
        return findEventsByBranchIdWithEventState(branchId, EventStatus.APERTO);
    }

    public List<Event> findEventsClosedByBranchId(long branchId) {
        return findEventsByBranchIdWithEventState(branchId, EventStatus.CHIUSO);
    }

    private List<Event> findEventsByBranchIdWithEventState(long branchId, EventStatus status) {
        logger.info("Ricerca eventi per branch con id [" + branchId + "] e stato evento" + status.name());
        List<Event> events = new ArrayList<>();

        List<BranchEventStorage> allByBranchId = branchEventStorageRepository.findByBranchId(Branch.builder().branchId(branchId).build());
        for(BranchEventStorage branchEventStorageService : allByBranchId){
            if(branchEventStorageService.getEvent().getEventStatus() == status){
                events.add(branchEventStorageService.getEvent());
            }
        }
        for(Event event : events){
            event.setExpenceEvents(eventExpenceRepository.findAllByEvent(event));
            event.setWorkstations(eventWorkstationRepository.findAllWorkstationsByEvent(event));
        }
        return events;
    }

    @Transactional
    public void deleteEventExpence(ExpenceEvent expenceEvent){
        logger.info("Delete Event Expence : " + expenceEvent.toString());
        eventExpenceRepository.deleteByExpenceId(expenceEvent.getExpenceId());
        expenceRepository.delete(expenceEvent);
    }


    @Transactional
    public void closeEvent(Event event) {
        if(event == null){
            throw new IllegalArgumentException("Errore - Impossibile chiudere l'evento. L'oggetto ricevuto dal metodo è NULL");
        }
        logger.info("Chiusura dell 'evento [" + event.toString() + "] in corso..");
        Optional<Event> eventOpt = eventRepository.findById(event.getEventId());
        if(eventOpt.isPresent()){
            eventOpt.get().setEventStatus(EventStatus.CHIUSO);

        }else{
            throw new IllegalArgumentException("Errore - Impossibile chiudere l'evento " + event.toString() +". Non è stato possibile recuperare le informazioni tramite l'id evento " + event.getEventId());
        }
    }


    // EXPENCE SERVICES

    public void deleteExpence(ExpenceEvent expenceEvent){
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

        ExpenceEvent savedExpenceEvent = expenceRepository.save(expenceEvent);

        eventExpenceRepository.save(EventExpenceRelation
                .builder()
                .expenceEvent(savedExpenceEvent)
                .event(Event.builder().eventId(expenceEvent.getEventId()).build()).build());

        return savedExpenceEvent;
    }

}
