package com.acorp.ventimetriquadri.app.event.expences;

import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.relations.event_expence.EventExpence;
import com.acorp.ventimetriquadri.app.relations.event_expence.EventExpenceService;
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
    private EventExpenceService eventExpenceService;



    public void delete(Expence expence){
        expenceRepository.deleteById(expence.getExpenceId());
    }

    public List<Expence> findAll() {
        return expenceRepository.findAll();
    }

    @Transactional
    public Expence update(Expence expence) {
        Optional<Expence> updatingEventExpence = expenceRepository.findById(expence.getExpenceId());
        if(!updatingEventExpence.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato spese eventi da aggiornare");
        }else{
            if(updatingEventExpence.get().getAmount() != expence.getAmount())
                updatingEventExpence.get().setAmount(expence.getAmount());

            if(updatingEventExpence.get().getDescription() != expence.getDescription())
                updatingEventExpence.get().setDescription(expence.getDescription());

            return updatingEventExpence.get();

        }
    }

    public List<Expence> findByEventId(long eventId) {
        return expenceRepository.findAllByEventId(eventId);
    }

    @Transactional
    public Expence saveExpence(Expence expence) {

        Expence savedExpence = expenceRepository.save(expence);

        eventExpenceService.saveExpence(EventExpence
                .builder()
                .expence(savedExpence)
                .event(Event.builder().eventId(expence.getEventId()).build()).build());

        return savedExpence;
    }
}
