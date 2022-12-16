package com.acorp.ventimetriquadri.app.event;

import com.acorp.ventimetriquadri.app.event.expences.ExpenceEvent;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceService;
import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/event")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;


    @Autowired
    private ExpenceService expenceService;


    @GetMapping(path = "/findbybranchid")
    public List<Event> retrieveEventsByBranchId(@RequestParam("branchid") long branchId){
        return eventService.findOpenEventsByBranchId(branchId);
    }

    @PostMapping(path = "/save")
    public Event save(Event event) {
        return eventService.createEvent(event);
    }

    @DeleteMapping(path = "/delete")
    public void delete(Event event){
        eventService.delete(event);
    }

    @PutMapping(path = "/update")
    public void update(Event event){
        eventService.update(event);
    }


    // WORKSTATION REOURCES

    @PostMapping(path = "/workstation/create")
    public Workstation createWorkstation(Workstation workstation){
        return eventService.createWorkstation(workstation);
    }


    // EXPENCE RESOURCES

    @GetMapping(path = "/expence/retrievebyeventid")
    public List<ExpenceEvent> retrieveAllExpenpencesByEventId(@RequestParam("eventid") long eventId){
        return expenceService.findByEventId(eventId);
    }

    @PostMapping(path = "/expence/create")
    public ExpenceEvent saveExpence(ExpenceEvent expenceEvent){
        return expenceService.saveExpence(expenceEvent);
    }

    @DeleteMapping(path = "expence/delete")
    public void delete(ExpenceEvent expenceEvent){
        expenceService.delete(expenceEvent);
    }

    @PutMapping(path = "expence/update")
    public void update(ExpenceEvent expenceEvent){
        expenceService.update(expenceEvent);
    }
}
