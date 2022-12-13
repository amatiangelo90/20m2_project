package com.acorp.ventimetriquadri.app.relations.storage_product;

import com.acorp.ventimetriquadri.app.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageProductRepository extends JpaRepository<StorageProduct, Long> {

    @Query("SELECT sp FROM StorageProduct sp WHERE sp.storage = ?1")
    List<StorageProduct> retrieveProductsByStorage(Storage storage);
}
