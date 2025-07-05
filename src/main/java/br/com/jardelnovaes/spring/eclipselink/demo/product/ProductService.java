package br.com.jardelnovaes.spring.eclipselink.demo.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
