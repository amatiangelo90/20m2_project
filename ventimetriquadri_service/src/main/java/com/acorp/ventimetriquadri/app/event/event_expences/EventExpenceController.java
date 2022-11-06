package com.acorp.ventimetriquadri.app.event.event_expences;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/events/expences")
@CrossOrigin(origins = "*")
public class EventExpenceController {

    private EventExpenceService eventExpenceService;

    @Autowired
    public EventExpenceController(EventExpenceService eventExpenceService) {
        this.eventExpenceService = eventExpenceService;
    }

    @GetMapping(path = "/findall")
    public List<EventExpence> retrieveAll(){
        return eventExpenceService.findAll();
    }

    @PostMapping(path = "/save")
    public void save(EventExpence eventExpence) { eventExpenceService.addNewEventExpence(eventExpence); }

    @DeleteMapping(path = "/delete")
    public void delete(EventExpence eventExpence){
        eventExpenceService.delete(eventExpence);
    }

    @PutMapping(path = "/update")
    public void update(EventExpence eventExpence){
        eventExpenceService.update(eventExpence);
    }



}
