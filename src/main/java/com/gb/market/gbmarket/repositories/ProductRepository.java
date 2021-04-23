package com.gb.market.gbmarket.repositories;


import com.gb.market.gbmarket.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  /*  Product findByTitle(String title);
    List<Product> findAllByIdGreaterThan(Long Id);
    List<Product> findAllByIdLessThan(Long Id);

    */
  
}
