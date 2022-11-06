package com.acorp.ventimetriquadri.app.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public void addNewEvent(Event event) {
        eventRepository.save(event);
    }

    public void delete(Event event){
        eventRepository.deleteById(event.getEventId());
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
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
