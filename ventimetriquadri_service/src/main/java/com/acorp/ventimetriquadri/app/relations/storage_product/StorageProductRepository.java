package com.acorp.ventimetriquadri.app.relations.storage_product;

import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StorageProductRepository extends JpaRepository<StorageProduct, Long> {

    @Query("SELECT sp FROM StorageProduct sp WHERE sp.storage = ?1 ORDER BY sp.productName ASC")
    List<StorageProduct> retrieveProductsByStorage(Storage storage);

    @Query("SELECT sp FROM StorageProduct sp WHERE sp.storage = ?1 AND sp.productId = ?2")
    Optional<StorageProduct> retrieveProductsByStorageAndProductId(Storage storage, long productId);

    @Query(value = "DELETE FROM StorageProduct sp WHERE sp.storage = ?1 AND sp.productId = ?2")
    @Modifying
    void deleteProdFromStorageByIds(Storage storage, long productId);

    @Modifying
    @Query(value = "UPDATE StorageProduct sp SET sp.stock = 0 WHERE sp.storage = ?1")
    void emptyStorage(Storage storage);

    @Modifying
    @Query(value = "UPDATE StorageProduct sp SET sp.stock = 0 WHERE sp.storage = ?1 AND sp.stock < 0")
    void setstockzerotonegativeproducts(Storage storage);
}
