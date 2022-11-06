package com.acorp.ventimetriquadri.app.event.event_expences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class EventExpenceService {

    @Autowired
    private EventExpenceRepository eventExpenceRepository;

    @Transactional
    public void addNewEventExpence(EventExpence eventExpence) {
        eventExpenceRepository.save(eventExpence);
    }

    public void delete(EventExpence eventExpence){
        eventExpenceRepository.deleteById(eventExpence.getEventExpenceId());
    }

    public List<EventExpence> findAll() {
        return eventExpenceRepository.findAll();
    }

    @Transactional
    public void update(EventExpence eventExpence) {
        Optional<EventExpence> updatingEventExpence = eventExpenceRepository.findById(eventExpence.getEventExpenceId());

        if(!updatingEventExpence.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato spese eventi da aggiornare");

        }else{

            if(updatingEventExpence.get().getAmount() != eventExpence.getAmount())
                updatingEventExpence.get().setAmount(eventExpence.getAmount());

            if(updatingEventExpence.get().getDescription() != eventExpence.getDescription())
                updatingEventExpence.get().setDescription(eventExpence.getDescription());

        }
    }

}
