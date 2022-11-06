package com.acorp.ventimetriquadri.app.product;

import com.acorp.ventimetriquadri.app.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
