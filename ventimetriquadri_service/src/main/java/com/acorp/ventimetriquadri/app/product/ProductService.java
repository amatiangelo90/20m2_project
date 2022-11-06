package com.acorp.ventimetriquadri.app.product;

import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void addNewProduct(Product product) {
        productRepository.save(product);
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
