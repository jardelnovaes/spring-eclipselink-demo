package br.com.jardelnovaes.spring.eclipselink.demo.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProdutoController {

    private final ProductService productService;

    public ProdutoController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> listAll() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    Product getById(@PathVariable int id) {
        return productService.getById(id);

    }
}
