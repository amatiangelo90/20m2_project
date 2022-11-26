package com.acorp.ventimetriquadri.app.event;


import com.acorp.ventimetriquadri.app.event.event_expences.EventExpenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventExpenceRepository eventExpenceRepository;


    @Transactional
    public void addNewEvent(Event event) {
        eventRepository.save(event);
    }

    public void delete(Event event){
        eventRepository.deleteById(event.getEventId());
    }

    public List<Event> findAll() {


        List<Event> allEvents = eventRepository.findAll();

        for(Event event : allEvents){
            event.setEventExpences(eventExpenceRepository.findAllByEventId(event.getEventId()));
        }

        return allEvents;
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

}
