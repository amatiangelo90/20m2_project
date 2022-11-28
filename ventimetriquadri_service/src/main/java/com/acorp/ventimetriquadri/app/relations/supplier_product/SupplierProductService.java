package com.acorp.ventimetriquadri.app.relations.supplier_product;


import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierProductService {

    @Autowired
    private SupplierProductRepository supplierProductRepository;

    public List<Product> findAllBySupplierId(long supplierId) {
        return supplierProductRepository.findAllBySupplierId(Supplier.builder().supplierId(supplierId).build());
    }
}
