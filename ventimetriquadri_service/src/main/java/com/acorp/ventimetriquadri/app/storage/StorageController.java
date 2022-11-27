package com.acorp.ventimetriquadri.app.storage;


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

    @GetMapping(path = "/findall")
    public List<Storage> retrieveAll(){
        return storageService.findAll();
    }

    @PostMapping(path = "/save")
    public Storage save(Storage storage) { return storageService.saveStorage(storage); }

    @DeleteMapping(path = "/delete")
    public void delete(Storage storage){
        storageService.delete(storage);
    }

    @PutMapping(path = "/update")
    public void update(Storage storage){
        storageService.update(storage);
    }

}
