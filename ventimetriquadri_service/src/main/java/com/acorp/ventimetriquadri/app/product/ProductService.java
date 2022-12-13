package com.acorp.ventimetriquadri.app.product;

import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.product.ProductRepository;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProduct;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranch;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranchRepository;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierProductRepository supplierProductRepository;


    @Transactional
    public void saveProduct(Product product) {

        Product prodSaved = productRepository.save(product);
        supplierProductRepository.save(
                SupplierProduct.builder()
                        .product(prodSaved)
                        .supplier(Supplier.builder().supplierId(product.getSupplierId()).build())
                        .build());
    }

    public void delete(Product product){
        productRepository.deleteById(product.getProductId());
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public void update(Product product) {
        Optional<Product> updatingBranch = productRepository.findById(product.getProductId());

        if(!updatingBranch.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato attività da aggiornare");

        }else{

            if(updatingBranch.get().getName() != product.getName())
                updatingBranch.get().setName(product.getName());

            if(updatingBranch.get().getCategory() != product.getCategory())
                updatingBranch.get().setCategory(product.getCategory());

            if(updatingBranch.get().getDescription() != product.getDescription())
                updatingBranch.get().setDescription(product.getDescription());

            if(updatingBranch.get().getPrice() != product.getPrice())
                updatingBranch.get().setPrice(product.getPrice());

            if(updatingBranch.get().getVatApplied() != product.getVatApplied())
                updatingBranch.get().setVatApplied(product.getVatApplied());

            if(updatingBranch.get().getUnitMeasure() != product.getUnitMeasure())
                updatingBranch.get().setUnitMeasure(product.getUnitMeasure());

        }
    }
}
