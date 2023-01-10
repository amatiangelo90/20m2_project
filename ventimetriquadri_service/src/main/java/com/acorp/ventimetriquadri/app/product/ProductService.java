package com.acorp.ventimetriquadri.app.product;

import com.acorp.ventimetriquadri.app.event.EventService;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProduct;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.acorp.ventimetriquadri.utils.Utils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierProductRepository supplierProductRepository;

    public void save(SupplierProduct supplierProduct) {
        supplierProductRepository.save(supplierProduct);
    }

    @Transactional
    public Product saveProduct(Product product) {

        logger.info("Save product " + Utils.jsonFormat(product));
        if(product.getSupplierId() == 0){
            throw new IllegalArgumentException("Error - Cannot saveBranchSupplier product if supplier id is not provided. Impossible to create relation");
        }
        Product prodSaved = productRepository.save(product);
        supplierProductRepository.save(
                SupplierProduct.builder()
                        .product(prodSaved)
                        .supplier(Supplier.builder().supplierId(product.getSupplierId()).build())
                        .build());
        return prodSaved;
    }

    @Transactional
    public void delete(Product product){
        logger.info("Delete product with id : " + product.getProductId());
        supplierProductRepository.deleteByProductId(Product.builder().productId(product.getProductId()).build());
        //productRepository.deleteById(product.getProductId());
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public Product update(Product product) {
        logger.info("Aggiornamento del prodotto in corso..\n Prodotto da aggiornare: " + product.toString());
        Optional<Product> updatingProd = productRepository.findById(product.getProductId());

        if(!updatingProd.isPresent()){
            throw new IllegalStateException("Errore. Non ho trovato prodotti da aggiornare");

        }else{

            if(updatingProd.get().getName() != product.getName())
                updatingProd.get().setName(product.getName());

            if(updatingProd.get().getCategory() != product.getCategory())
                updatingProd.get().setCategory(product.getCategory());

            if(updatingProd.get().getDescription() != product.getDescription())
                updatingProd.get().setDescription(product.getDescription());

            if(updatingProd.get().getPrice() != product.getPrice())
                updatingProd.get().setPrice(product.getPrice());

            if(updatingProd.get().getVatApplied() != product.getVatApplied())
                updatingProd.get().setVatApplied(product.getVatApplied());

            if(updatingProd.get().getUnitMeasure() != product.getUnitMeasure())
                updatingProd.get().setUnitMeasure(product.getUnitMeasure());

            return product;
        }
    }

    public List<Product> findAllBySupplierId(long supplierId) {
        return supplierProductRepository.findAllBySupplierId(Supplier.builder().supplierId(supplierId).build());
    }
}
