package com.acorp.ventimetriquadri.app.storage;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorage;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private BranchStorageRepository branchStorageRepository;

    @Transactional
    public Storage saveStorage(Storage storage) {

        Storage storageSaved = storageRepository.save(storage);
        branchStorageRepository.save(BranchStorage.builder()
                .storage(storageSaved)
                .branch(Branch.builder().branchId(storage.getBranchId()).build()).build());
        return storageSaved;
    }

    public void delete(Storage userEntity){
        storageRepository.deleteById(userEntity.getStorageId());
    }

    public List<Storage> findAll() {
        return storageRepository.findAll();
    }

    @Transactional
    public void update(Storage storage) {
        Optional<Storage> updatingUser = storageRepository.findById(storage.getStorageId());

        if(!updatingUser.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato utenti da aggiornare");

        }else{

            if(updatingUser.get().getName() != storage.getName())
                updatingUser.get().setName(storage.getName());

            if(updatingUser.get().getAddress() != storage.getAddress())
                updatingUser.get().setAddress(storage.getAddress());

            if(updatingUser.get().getCap() != storage.getCap())
                updatingUser.get().setCap(storage.getCap());

            if(updatingUser.get().getCity() != storage.getCity())
                updatingUser.get().setCity(storage.getCity());

        }
    }


}
