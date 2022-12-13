package com.acorp.ventimetriquadri.app.event;

import com.acorp.ventimetriquadri.app.event.expences.ExpenceService;
import com.acorp.ventimetriquadri.app.event.expences.Expence;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ExpenceService expenceService;


    @GetMapping(path = "/findbybranchid")
    public List<Event> retrieveAll(@RequestParam("branchid") long branchId){
        return eventService.findByBranchId(branchId);
    }

    @PostMapping(path = "/save")
    public Event save(Event event) {
        return eventService.saveEvent(event);
    }

    @DeleteMapping(path = "/delete")
    public void delete(Event event){
        eventService.delete(event);
    }

    @PutMapping(path = "/update")
    public void update(Event event){
        eventService.update(event);
    }

    @PostMapping(path = "/expence/create")
    public Expence saveExpence(Expence expence){
        return expenceService.saveExpence(expence);
    }

    @DeleteMapping(path = "/expence/delete")
    public void deleteExpence(Expence expence){
        expenceService.delete(expence);
    }

    @PutMapping(path = "/expence/update")
    public Expence updateExpence(Expence expence){
        return expenceService.update(expence);
    }

    @GetMapping(path = "/expence/retrievebyeventid")
    public List<Expence> retrieveAllExpenpencesByEventId(@RequestParam("eventid") long eventId){
        return expenceService.findByEventId(eventId);
    }
}
