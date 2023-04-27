package com.example.EComApplication.brand;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EComApplication.product.Product;

public interface BrandRepository extends JpaRepository<Brand ,Long>
{
	public List <Brand> findAllByCategoryid(long id);
	
	//public List<Product>findByBrandid(long id);
	
	public Brand findByBrandname(String brandname);
	
	public Brand deleteBybrandid(long brandid);

	

	
}
