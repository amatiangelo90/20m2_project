package com.acorp.ventimetriquadri.app.storage;


import com.acorp.ventimetriquadri.app.relations.storage_product.R_StorageProduct;
import com.acorp.ventimetriquadri.app.storage.utils_model.LoadUnloadModel;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(path = "api/v1/app/storage")
@CrossOrigin(origins = "*")
public class StorageController {


    @Autowired
    private StorageService storageService;

    @GetMapping(path = "/findstoragebybranchid")
    public List<Storage> findStorageByBranchId(@RequestParam("branchid") long branchid){
        return storageService.findStoragesByBranchId(branchid);
    }

    @PostMapping(path = "/save")
    public Storage save(@RequestBody Storage storage) { return storageService.saveStorage(storage); }

    @GetMapping(path = "/insertproduct")
    public R_StorageProduct save(@RequestParam long storageId, @RequestParam long productId) { return storageService.insertProductIntoStorage(storageId, productId); }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestBody Storage storage){
        storageService.delete(storage);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody Storage storage){
        storageService.update(storage);
    }

    @PutMapping(path = "/emptystorage")
    public void emptystorage(@RequestParam long storageId){
        storageService.emptystorage(storageId);
    }

    @PutMapping(path = "/setstockzerotonegativeproducts")
    public void setstockzerotonegativeproducts(@RequestParam long storageId){
        storageService.setstockzerotonegativeproducts(storageId);
    }
    @DeleteMapping(path = "/deleteproductfromstorage")
    public void deleteProductFromStorage(@RequestParam long storageId, @RequestParam long productId){
        storageService.removeProductFromStorage(storageId, productId);
    }
    @PutMapping(path = "/load")
    public void loadAmountOnStorage(@RequestBody List<LoadUnloadModel> loadUnloadModel){
        storageService.loadAmountOnStorage(loadUnloadModel);
    }
    @PutMapping(path = "/unload")
    public void unloadAmountOnStorage(@RequestBody List<LoadUnloadModel> loadUnloadModel){
        storageService.unloadAmountOnStorage(loadUnloadModel);
    }

    @PutMapping(path = "/amounthundred/saveconfiguration")
    public void updateAmountHundredValue(@RequestParam long storageProductId, @RequestParam double qHundredAmount){
        storageService.updateAmountHundredValue(storageProductId, qHundredAmount);
    }
}
