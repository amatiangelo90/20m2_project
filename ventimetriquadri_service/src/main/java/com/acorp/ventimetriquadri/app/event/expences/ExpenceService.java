package com.acorp.ventimetriquadri.app.event.expences;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.relations.event_expence.EventExpenceRelation;
import com.acorp.ventimetriquadri.app.relations.event_expence.EventExpenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ExpenceService {

    @Autowired
    private ExpenceRepository expenceRepository;

    @Autowired
    private EventExpenceRepository eventExpenceRepository;


    public void delete(ExpenceEvent expenceEvent){
        expenceRepository.deleteById(expenceEvent.getExpenceId());
    }

    public List<ExpenceEvent> findAll() {
        return expenceRepository.findAll();
    }

    @Transactional
    public ExpenceEvent update(ExpenceEvent expenceEvent) {
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

    public List<ExpenceEvent> findByEventId(long eventId) {
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
