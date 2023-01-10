package com.acorp.ventimetriquadri.app.event;

import com.acorp.ventimetriquadri.app.event.expences.ExpenceEvent;
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


    @GetMapping(path = "/findeventbybranchid/open")
    public List<Event> retrieveEventsByBranchId(@RequestParam("branchid") long branchId){
        return eventService.findOpenEventsByBranchId(branchId);
    }

    @GetMapping(path = "/findeventbyeventid")
    public Event retrieveEventsByEventId(@RequestParam("eventid") long eventId){
        return eventService.findOpenEventsByEventId(eventId);
    }

    @GetMapping(path = "/findeventbybranchid/closed")
    public List<Event> retrieveEventsClosedByBranchId(@RequestParam("branchid") long branchId){
        return eventService.findClosedEventByBranchId(branchId);
    }

    @PostMapping(path = "/save")
    public Event save(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam("eventId") long eventId){
        eventService.deleteEvent(eventId);
    }

    @PutMapping(path = "/close")
    public void close(@RequestParam("eventId") long eventId){
        eventService.closeEvent(eventId);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody Event event){
        eventService.update(event);
    }


    // WORKSTATION REOURCES
    @PostMapping(path = "/workstation/create")
    public Workstation createWorkstation(@RequestBody Workstation workstation){
        return eventService.createWorkstation(workstation);
    }

    @PostMapping(path = "/workstation/addproduct")
    public Workstation addProductToWorkstation(@RequestBody Workstation workstation){
        return eventService.createWorkstation(workstation);
    }


    // EXPENCE RESOURCES
    @GetMapping(path = "/expence/retrievebyeventid")
    public List<ExpenceEvent> retrieveAllExpenpencesByEventId(@RequestParam("eventid") long eventId){
        return eventService.findExpencesByEventId(eventId);
    }

    @PostMapping(path = "/expence/create")
    public ExpenceEvent saveExpence(@RequestBody ExpenceEvent expenceEvent){
        return eventService.saveExpence(expenceEvent);
    }
    @DeleteMapping(path = "expence/delete")
    public void deleteExpence(@RequestBody ExpenceEvent expenceEvent){
        eventService.deleteEvent(expenceEvent);
    }

    @PutMapping(path = "expence/update")
    public void updateExpence(@RequestBody ExpenceEvent expenceEvent){
        eventService.updateExpence(expenceEvent);
    }
}
