package com.example.EComApplication.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getcategory")
    public ResponseEntity<List<Category>> getAllCategory()
    {
      List<Category> cat=categoryService.getAllCategory();
    	if(cat.size()<=0)
    	{
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
        return  ResponseEntity.of(Optional.of(cat));
    }

    
    @PostMapping("/addcategory")
    public ResponseEntity<Void> addCategory(@RequestBody Category category)
    {
    try 
    {
       this. categoryService.addCategory(category);
       return ResponseEntity.ok().build();
    }
    catch(Exception e)
    {
    	e.printStackTrace();
   
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    }
    
    
    
    /*...............................*/
    
   /* @PostMapping("/addcategory")
    public void addCategory(@RequestBody Category category)
    {
    	
        categoryService.addCategory(category);
    }
    
    /*...............................*/
    
    
    @PutMapping("/category/update/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable long id,@RequestBody Category category)
    {
    	try 
    	{ 
    		this.categoryService.updateCategory(id,category);
    		return ResponseEntity.ok().build();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }
    
    
    /*...............................*/
    
    @RequestMapping("/category/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long category_id)
    {
    	try 
    	{
    		categoryService.deleteCategory(category_id);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	
    }
    
    
}
