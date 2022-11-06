package com.acorp.ventimetriquadri.app.event;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/events")
@CrossOrigin(origins = "*")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = "/findall")
    public List<Event> retrieveAll(){
        return eventService.findAll();
    }

    @PostMapping(path = "/save")
    public void save(Event event) { eventService.addNewEvent(event); }

    @DeleteMapping(path = "/delete")
    public void delete(Event event){
        eventService.delete(event);
    }

    @PutMapping(path = "/update")
    public void update(Event event){
        eventService.update(event);
    }
}
