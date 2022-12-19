package com.acorp.ventimetriquadri.app.supplier;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplier;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class SuppliersService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private BranchSupplierRepository branchSupplierRepository;

    @Transactional
    public Supplier saveSupplier(Supplier supplier) {

        try{
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

    public void delete(Supplier supplier){
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

            if(updatingUser.get().getPhoneNumber() != user.getPhoneNumber())
                updatingUser.get().setPhoneNumber(user.getPhoneNumber());

            if(updatingUser.get().getPhoneNumber() != user.getPhoneNumber())
                updatingUser.get().setPhoneNumber(user.getPhoneNumber());

            if(updatingUser.get().getPhoneNumber() != user.getPhoneNumber())
                updatingUser.get().setPhoneNumber(user.getPhoneNumber());


        }
    }

    public Supplier findByPhone(String phone) {
        return supplierRepository.findByPhone(phone);
    }


    public Optional<Supplier> findSupplierById(long supplierId) {
        return supplierRepository.findById(supplierId);


    }
}
