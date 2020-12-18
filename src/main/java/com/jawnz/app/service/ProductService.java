package com.jawnz.app.service;

import com.jawnz.app.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Product}.
 */
public interface ProductService {

    /**
     * Save a product.
     *
     * @param product the entity to save.
     * @return the persisted entity.
     */
    Product save(Product product);

    /**
     * Get all the products.
     *
     * @return the list of entities.
     */
    List<Product> findAll();


    /**
     * Get the "id" product.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Product> findOne(String id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

    /**
     * Search for the product corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @return the list of entities.
     */
    List<Product> search(String query);
}
