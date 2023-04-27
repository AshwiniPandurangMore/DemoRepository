package com.example.EComApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EComApplication.brand.Brand;
import com.example.EComApplication.brand.BrandRepository;
import com.example.EComApplication.category.Category;
import com.example.EComApplication.category.CategoryRepository;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;
    
    @Autowired
    BrandRepository brandRepo;
    
    @Autowired 
    CategoryRepository catRepo;

    @GetMapping("/getproduct")
    public ResponseEntity<List<Product>> getAllProduct()
    {
    	try
    	{
    		this. productService.getAllProduct();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();	
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/addproduct")
    public ResponseEntity<Void> addProduct(@RequestBody Product product)
    {
    	try
    	{
        	this.productService.addProduct(product);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    /// get Product by brand name
    
    @GetMapping("/getproductbybrandname/{brandname}")
    public ResponseEntity<List<Product>> getProductByBrandname(@PathVariable String brandname )
    {
    	try
    	{
    		Brand b1= brandRepo.findByBrandname(brandname);
    		long b2=b1.getBrandid();
    		this. productService.getProductByBrandId(b2);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    /// get product by category name
    
    @GetMapping("/getproductbycategoryname/{categoryname}")
    public ResponseEntity<List<Product>> getProductByCatName(@PathVariable String categoryname)
    {
    	try
    	{
    	Category p1=catRepo.findBycategoryname(categoryname);
    	long p2=p1.getCategoryid();
    	this. productService.getProductByCategoryId(p2);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}







/*
@PostMapping("/addproduct")
public void addProduct(@RequestBody Product product)
{
    productService.addProduct(product);
}

/// get Product by brand name

@GetMapping("/getproductbybrandname/{brandname}")
public List<Product> getProductByBrandname(@PathVariable String brandname )
{
	Brand b1= brandRepo.findByBrandname(brandname);
	long b2=b1.getBrandid();
	return productService.getProductByBrandId(b2);
}

/// get product by category name

@GetMapping("/getproductbycategoryname/{categoryname}")
public List<Product> getProductByCatName(@PathVariable String categoryname)
{
	Category p1=catRepo.findBycategoryname(categoryname);
	long p2=p1.getCategoryid();
	return productService.getProductByCategoryId(p2);
}
*/
