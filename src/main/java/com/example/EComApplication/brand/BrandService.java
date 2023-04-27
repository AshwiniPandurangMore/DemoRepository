package com.example.EComApplication.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EComApplication.product.Product;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService
{
    @Autowired
    private BrandRepository brandRepository;
    
   /*@Autowired
    ProductRepository productRepo;
    
    @Autowired
    Product product;*/
    
    //Brand brand = new Brand();
    ///    get all Brands
    public List<Brand> getAllBrand()
    {
        List<Brand> b=new ArrayList<Brand>();
        brandRepository.findAll().forEach(b::add);
        return b;
    }

    ///////   add all brands
    
    public void  addBrand(Brand brand)
    {
        brandRepository.save(brand);
    }
    

   ////    get all brand which category id is present in brand
    
	public List<Brand> getBrandsByCategoryId(long id)
	{
		return brandRepository.findAllByCategoryid(id);
		
	}

	public Brand deleteBrandById(long brandid)
	{
		
		return brandRepository.deleteBybrandid(brandid);
	}

	/*public List<Brand> getBrandByid(String id)
	{
		
		return brandRepository.findByBrandname(id);
	}*/

	/*public Product getProduct(long id)
	{
		Product pr=brandRepository.findByBrandid(id).get(0);
		return pr;
	}*/

	/*public List<Product> getBrandByName(String brandname)
	{
		return brandRepository.findByproductname(brandname);
	}*/

	

	/*public Employee idEmp(String id) 
	{
		Employee emp=empRepo.findById(id).get();
		return emp;
	
	}*/
   
    
}
