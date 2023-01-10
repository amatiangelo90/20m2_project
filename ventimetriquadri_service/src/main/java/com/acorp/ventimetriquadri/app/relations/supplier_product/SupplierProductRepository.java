package com.acorp.ventimetriquadri.app.relations.supplier_product;

import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierProductRepository extends JpaRepository<SupplierProduct, Long> {

    @Query("SELECT sp.product FROM SupplierProduct sp WHERE sp.supplier = ?1")
    List<Product> findAllBySupplierId(Supplier supplier);

    @Query(value = "DELETE FROM SupplierProduct sp WHERE sp.product = ?1")
    @Modifying
    void deleteByProductId(Product product);
}
