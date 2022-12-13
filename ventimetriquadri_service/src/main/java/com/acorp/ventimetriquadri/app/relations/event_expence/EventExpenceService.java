package com.acorp.ventimetriquadri.app.relations.event_expence;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.event.expences.Expence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventExpenceService {

    @Autowired
    private EventExpenceRepository eventExpenceRepository;


    public List<Expence> retrieveAllExpenceByEventId(long eventId){
        return eventExpenceRepository.findAllByEvent(Event.builder().eventId(eventId).build());
    }

    public EventExpence saveExpence(EventExpence eventExpence){
        return eventExpenceRepository.save(eventExpence);
    }
}
