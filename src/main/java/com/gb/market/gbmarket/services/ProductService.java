package com.gb.market.gbmarket.services;


import com.gb.market.gbmarket.entities.Product;
import com.gb.market.gbmarket.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Page<Product> findAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findWhereMinMax(Long id, boolean byMin) {

        List<Product> lp= productRepository.findAll();
        List<Product> lrez = new ArrayList<>();

        for(int i=0; i<lp.size(); i++) {
            if (byMin) {
                if (lp.get(i).getId() >= id) {
                    lrez.add(lp.get(i));
                }
            }
            else {
                if (lp.get(i).getId()==1) continue;
                if (lp.get(i).getId() <= id) {
                    lrez.add(lp.get(i));
                }
            }
        }
        return lrez;
    }
}
