package com.acorp.ventimetriquadri.app.event.workstations;

import com.acorp.ventimetriquadri.app.relations.workstation_product.R_WorkstationProduct;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/workstation")
@CrossOrigin(origins = "*")
public class WorkstationController {

    @Autowired
    private WorkstationService workstationService;

    @GetMapping(path = "/insertproduct")
    public R_WorkstationProduct insertProductIntoWorkstation(@RequestParam long workstationId,
                                                         @RequestParam long productId,
                                                         @RequestParam long storageId) {
        return workstationService.insertProductIntoWorkstation(workstationId, productId, storageId);
    }
    @DeleteMapping(path = "/removeproduct")
    public void removeProductFromWorkstation(@RequestParam long workstationProductId) {
        workstationService.removeProductFromWorkstation(workstationProductId);
    }

    @PutMapping(path = "/resetproductstockvalue")
    public void set0ToProductWorkstationLoadValue(@RequestParam long workstationProductId) {
        workstationService.set0ToProductWorkstationStockFromStorageValue(workstationProductId);
    }

    @PutMapping(path = "/resetproductconsumedvalue")
    public void set0ToProductWorkstationUnloadValue(@RequestParam long workstationProductId) {
        workstationService.set0ToConsumedProductWorkstation(workstationProductId);
    }

    @DeleteMapping(path = "/removeworkstation")
    public void deleteWorkstation(@RequestParam long workstationId) { workstationService.removeWorkstation(workstationId); }


    @PutMapping(path = "/update")
    public Workstation updateWorkstation(@RequestBody Workstation workstation) {
        return workstationService.updateWorkstation(workstation);
    }

    @PostMapping(path = "/load")
    public void load(@RequestBody List<WorkstationLoadUnloadProduct> workstationLoadUnloadProductList){
        workstationService.performLoadWorkstation(workstationLoadUnloadProductList);
    }

    @PostMapping(path = "/unload")
    public void unload(@RequestBody List<WorkstationLoadUnloadProduct> workstationLoadUnloadProductList){
        workstationService.performUnloadWorkstation(workstationLoadUnloadProductList);
    }

    @DeleteMapping(path = "/deleteproduct")
    public void deleteProduct(@RequestParam long workstationProductId){
        workstationService.deleteProductFromWorkstation(workstationProductId);
    }

    @GetMapping(path = "/retrieveAllProductByWorkstationId")
    public List<R_WorkstationProduct> retrieveAllProductByWorkstationId(@RequestParam long workstationId){
        return workstationService.retrieveAllProductByWorkstationId(workstationId);
    }

}
