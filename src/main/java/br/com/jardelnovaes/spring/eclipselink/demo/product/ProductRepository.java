package br.com.jardelnovaes.spring.eclipselink.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> { }
