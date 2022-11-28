package com.acorp.ventimetriquadri.app.relations.order_product;

import com.acorp.ventimetriquadri.app.order.OrderEntity;
import com.acorp.ventimetriquadri.app.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    @Query("SELECT op.product, op.productAmount FROM OrderProduct op WHERE op.orderEntity = ?1")
    List<Product> findAllProdutsByOrderId(OrderEntity orderEntity);
}
