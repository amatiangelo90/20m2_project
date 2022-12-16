package com.acorp.ventimetriquadri.app.relations.branch_supplier;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProduct;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchSupplierService {

    @Autowired
    private BranchSupplierRepository branchSupplierRepository;

    @Autowired
    private SupplierProductRepository supplierProductRepository;




    public Supplier save(BranchSupplier branchSupplier) {
        BranchSupplier supplierBranchSaved = branchSupplierRepository.save(branchSupplier);
        return supplierBranchSaved.getSupplier();
    }

    public List<Supplier> findAllSupplierByBranch(Branch branch) {
        return branchSupplierRepository.findAllSupplierByBranch(branch);
    }
}
