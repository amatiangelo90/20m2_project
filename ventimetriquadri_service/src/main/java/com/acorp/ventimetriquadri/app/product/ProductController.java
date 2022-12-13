package com.acorp.ventimetriquadri.app.product;

import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductService;
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
    private SupplierProductService supplierProductService;

    @GetMapping(path = "/findall")
    public List<Product> retrieveAll(){
        return productService.findAll();
    }

    @PostMapping(path = "/save")
    public void save(Product product) { productService.saveProduct(product); }

    @DeleteMapping(path = "/delete")
    public void delete(Product product){
        productService.delete(product);
    }

    @PutMapping(path = "/update")
    public void update(Product product){
        productService.update(product);
    }

    @GetMapping(path = "/retrievebysupplier")
    public List<Product> retrieveProductsBySupplierId(@RequestParam long supplierId){
        return supplierProductService.findAllBySupplierId(supplierId);
    }
}
