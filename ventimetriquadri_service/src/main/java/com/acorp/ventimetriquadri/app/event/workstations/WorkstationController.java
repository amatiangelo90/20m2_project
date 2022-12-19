package com.acorp.ventimetriquadri.app.event.workstations;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(path = "api/v1/app/workstation")
@CrossOrigin(origins = "*")
public class WorkstationController {

    @Autowired
    private WorkstationService workstationService;

    @GetMapping(path = "/insertproduct")
    public void insertProductIntoStorage(@RequestParam long workstationId, @RequestParam long productId, @RequestParam long storageId) { workstationService.insertProductIntoWorkstation(workstationId, productId, storageId); }

    @DeleteMapping(path = "/removeproduct")
    public void removeProductIntoStorage(@RequestParam long workstationProductId) { workstationService.removeProductFromWorkstation(workstationProductId); }
}
