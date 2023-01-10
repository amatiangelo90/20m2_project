package com.acorp.ventimetriquadri.app.product;

import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/app/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplierProductRepository supplierProductRepository;

    @GetMapping(path = "/findall")
    public List<Product> retrieveAll(){
        return productService.findAll();
    }

    @PostMapping(path = "/save")
    public Product save(@RequestBody Product product) { return productService.saveProduct(product); }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestBody Product product){
        productService.delete(product);
    }

    @PutMapping(path = "/update")
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @GetMapping(path = "/retrievebysupplier")
    public List<Product> retrieveProductsBySupplierId(@RequestParam long supplierId){
        return supplierProductRepository.findAllBySupplierId(Supplier.builder().supplierId(supplierId).build());
    }
}
