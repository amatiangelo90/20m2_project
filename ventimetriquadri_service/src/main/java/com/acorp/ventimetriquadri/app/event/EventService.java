package com.acorp.ventimetriquadri.app.event;


import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.relations.branch_event.BranchEventStorage;
import com.acorp.ventimetriquadri.app.relations.branch_event.BranchEventStorageService;
import com.acorp.ventimetriquadri.app.relations.event_expence.EventExpenceService;
import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventExpenceService eventExpenceService;

    @Autowired
    private BranchEventStorageService branchEventStorageService;


    @Transactional
    public Event saveEvent(Event event) {
        Event eventSaved = eventRepository.save(event);

        branchEventStorageService.saveBranchEventStorageEntity(
                BranchEventStorage.builder()
                    .event(eventSaved)
                    .storage(Storage.builder().storageId(event.getStorageId()).build())
                    .branch(Branch.builder().branchId(event.getStorageId()).build())
                        .build());

        return eventSaved;
    }

    public void delete(Event event){
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

    public List<Event> findByBranchId(long branchId) {

        List<Event> events = new ArrayList<>();

        List<BranchEventStorage> allByBranchId = branchEventStorageService.findAllByBranchId(Branch.builder().branchId(branchId).build());
        for(BranchEventStorage branchEventStorageService : allByBranchId){
            events.add(branchEventStorageService.getEvent());
        }
        for(Event event : events){
            event.setExpences(eventExpenceService.retrieveAllExpenceByEventId(event.getEventId()));
        }

        return events;
    }
}
