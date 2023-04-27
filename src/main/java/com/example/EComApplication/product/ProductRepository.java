package com.example.EComApplication.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>
{
	public List<Product> findAllByBrandid(long id);
	
	public List<Product> findAllByCategoryid(long id);
}
