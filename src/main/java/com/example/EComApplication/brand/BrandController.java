package com.example.EComApplication.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EComApplication.category.CategoryRepository;
import com.example.EComApplication.product.Product;
import com.example.EComApplication.product.ProductRepository;
import java.util.List;
import java.util.Optional;

@RestController
public class BrandController
{
    @Autowired
    private BrandService brandService;
    
    @Autowired
    BrandRepository brandRepo;
    
    @Autowired 
    CategoryRepository categoryRepo;
    
    @Autowired
    ProductRepository productRepo;
    
    
    /////////   get all brand
    @GetMapping("/brand")
    public ResponseEntity <List<Brand>> getAllBrand()
    {
    		List<Brand> brand= brandService.getAllBrand();
    		if(brand.size()<=0)
    		{
    			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    		}
    		
    		return  ResponseEntity.of(Optional.of(brand));
    }

    
    /////  add brands
    
    @PostMapping("/addbrand")
    public ResponseEntity<Void> addBrand(@RequestBody Brand brand)
    {
    	try
    	{
    		this.brandService.addBrand(brand);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	
    }
    
    
    
  ///// get all brands which category present in brand
	
    @GetMapping("/getcategory_id/{id}")
    public ResponseEntity<List<Brand>> getBrandByCategoryId(@PathVariable long id,String salary)
    {
    	try
    	{
    		brandService.getBrandsByCategoryId(id);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}	
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
      
    
    ///// delete brand by brandId
    
    @GetMapping("/deletebrandbybrandid/{id}")
    public ResponseEntity<Brand> deleteBrandByBrandId(@PathVariable long brandid)
    {
    	try
    	{
    		brandService.deleteBrandById(brandid);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
}
