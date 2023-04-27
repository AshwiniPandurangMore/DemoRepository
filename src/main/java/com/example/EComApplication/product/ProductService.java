package com.example.EComApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProduct()
    {
        List<Product> p=new ArrayList<>();
         productRepo.findAll().forEach(p::add);
         return p;
    }

    public void addProduct(Product product)
    {
         productRepo.save(product);
    }

	public List<Product> getProductByBrandId(long b2)
	{
		return productRepo.findAllByBrandid(b2);
		
	}

	public List<Product> getProductByCategoryId(long p2)
	{
		
		return productRepo.findAllByCategoryid(p2);
	}
	

	public List<Product> getAllProductByCategoryId(long categoryid) {
		// TODO Auto-generated method stub
		return productRepo.findAllByCategoryid(categoryid);
	}

    
}
