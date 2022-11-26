package com.acorp.ventimetriquadri.app.relations.branch_event;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.event.event_expences.EventExpenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BranchEventStorageService {

    @Autowired
    private BranchEventStorageRepository branchEventStorageRepository;

    @Autowired
    private EventExpenceRepository eventExpenceRepository;

    @Transactional
    public void saveBranchEventStorageEntity(BranchEventStorage product) {
        branchEventStorageRepository.save(product);
    }

    public List<BranchEventStorage> findAll() {

        List<BranchEventStorage> allBranchEventStorage = branchEventStorageRepository.findAll();
        for(BranchEventStorage branchEventStorage : allBranchEventStorage){
            branchEventStorage.getEvent().setEventExpences(eventExpenceRepository.findAllByEventId(branchEventStorage.getEvent().getEventId()));
        }
        return allBranchEventStorage;
    }

    public List<BranchEventStorage> findAllByBranchId(Branch branch) {
        List<BranchEventStorage> allBranchEventStorage = branchEventStorageRepository.findByBranchId(branch);
        for(BranchEventStorage branchEventStorage : allBranchEventStorage){
            branchEventStorage.getEvent().setEventExpences(eventExpenceRepository.findAllByEventId(branchEventStorage.getEvent().getEventId()));
        }
        return allBranchEventStorage;
    }
}