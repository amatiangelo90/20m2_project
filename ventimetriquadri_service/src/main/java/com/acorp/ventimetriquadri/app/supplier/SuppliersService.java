package com.acorp.ventimetriquadri.app.supplier;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.event.EventService;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplier;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierRepository;
import com.acorp.ventimetriquadri.utils.Utils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class SuppliersService {

    private static final Logger logger = LoggerFactory.getLogger(SuppliersService.class);

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private BranchSupplierRepository branchSupplierRepository;

    @Transactional
    public Supplier saveSupplier(Supplier supplier) {
        logger.info("Inserimento fornitore : " + Utils.jsonFormat(supplier));
        try{
            supplier.setCode(UUID.randomUUID().toString());
            Supplier supplierdSaved = supplierRepository.save(supplier);
            branchSupplierRepository.save(
                    BranchSupplier.builder()
                            .branch(Branch.builder().branchId(supplier.getBranchId()).build())
                            .supplier(supplierdSaved)
                            .build());
            return supplierdSaved;
        }catch(Exception e){
            throw new IllegalStateException(e);
        }

    }

    @Transactional
    public void delete(Supplier supplier){
        logger.info("Rimozione fornitore : " + Utils.jsonFormat(supplier));
        branchSupplierRepository.delete(BranchSupplier.builder()
                .supplier(Supplier.builder().supplierId(supplier.getSupplierId()).build())
                .branch(Branch.builder().branchId(supplier.getBranchId()).build())
                .build());
        supplierRepository.deleteById(supplier.getSupplierId());
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Transactional
    public void update(Supplier user) {
        Optional<Supplier> updatingUser = supplierRepository.findById(user.getSupplierId());

        if(!updatingUser.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato utenti da aggiornare");

        }else{

            if(updatingUser.get().getName() != user.getName())
                updatingUser.get().setName(user.getName());

            if(updatingUser.get().getEmail() != user.getEmail())
                updatingUser.get().setEmail(user.getEmail());

            if(updatingUser.get().getPhoneNumber() != user.getPhoneNumber())
                updatingUser.get().setPhoneNumber(user.getPhoneNumber());

            if(updatingUser.get().getAddress() != user.getAddress())
                updatingUser.get().setAddress(user.getAddress());

            if(updatingUser.get().getVatNumber() != user.getVatNumber())
                updatingUser.get().setVatNumber(user.getVatNumber());

            if(updatingUser.get().getCap() != user.getCap())
                updatingUser.get().setCap(user.getCap());

            if(updatingUser.get().getCity() != user.getCity())
                updatingUser.get().setCity(user.getCity());

        }
    }

    public Supplier findByPhone(String phone) {
        return supplierRepository.findByPhone(phone);
    }


    public Optional<Supplier> findSupplierById(long supplierId) {
        return supplierRepository.findById(supplierId);


    }
}
