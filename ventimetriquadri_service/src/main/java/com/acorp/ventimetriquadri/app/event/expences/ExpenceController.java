package com.acorp.ventimetriquadri.app.event.expences;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(path = "api/v1/app/event/expences")
@CrossOrigin(origins = "*")
public class ExpenceController {

    @Autowired
    private ExpenceService expenceService;

    @DeleteMapping(path = "/delete")
    public void delete(Expence expence){
        expenceService.delete(expence);
    }

    @PutMapping(path = "/update")
    public void update(Expence expence){
        expenceService.update(expence);
    }

}
