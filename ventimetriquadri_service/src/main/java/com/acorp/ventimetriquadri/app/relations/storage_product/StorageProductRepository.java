package com.acorp.ventimetriquadri.app.relations.storage_product;

import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StorageProductRepository extends JpaRepository<StorageProduct, Long> {

    @Query("SELECT sp FROM StorageProduct sp WHERE sp.storage = ?1")
    List<StorageProduct> retrieveProductsByStorage(Storage storage);

    @Query("SELECT sp FROM StorageProduct sp WHERE sp.storage = ?1 AND sp.productId = ?2")
    Optional<StorageProduct> retrieveProductsByStorageAndProductId(Storage storage, long productId);

}
