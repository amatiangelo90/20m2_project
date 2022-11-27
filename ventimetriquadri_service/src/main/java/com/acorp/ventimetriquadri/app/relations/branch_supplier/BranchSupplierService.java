package com.acorp.ventimetriquadri.app.relations.branch_supplier;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductService;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchSupplierService {

    @Autowired
    private BranchSupplierRepository branchSupplierRepository;

    @Autowired
    private SupplierProductService supplierProductService;


    public List<Supplier> findAllSupplierByBranch(Branch branch){
        List<Supplier> allSupplierByBranch = branchSupplierRepository.findAllSupplierByBranch(branch);

        for(Supplier supplier : allSupplierByBranch){
            supplier.setProductList(supplierProductService.findAllBySupplierId(supplier.getSupplierId()));
        }

        return allSupplierByBranch;
    }

}
