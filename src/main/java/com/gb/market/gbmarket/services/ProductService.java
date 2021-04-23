package com.gb.market.gbmarket.services;



import com.gb.market.gbmarket.entities.Product;
import com.gb.market.gbmarket.repositories.ProductRepository;
import com.gb.market.gbmarket.repositories.specifications.ProductSpecifications;
import com.gb.market.gbmarket.utils.ProductFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> findAll(Specification<Product> spec, int page, int size) {
        return productRepository.findAll(spec, PageRequest.of(page, size));
    }

    /*public Page<Product> findAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> filterByMaxId(Long id) {
        return productRepository.findAllByIdLessThan(id);
    }
    public List<Product> filterByMinId(Long id) { return productRepository.findAllByIdGreaterThan(id);}
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> findAll(Specification<Product> spec, int page, int size) {
        return productRepository.findAll(spec, PageRequest.of(page, size));
    }*/
}

