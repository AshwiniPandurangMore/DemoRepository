package com.example.EComApplication.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService
{
    @Autowired
    private CategoryRepository categoryRepo;
    
   
    
    public List<Category> getAllCategory()
    {
        List<Category> c=new ArrayList<Category>();
        categoryRepo.findAll().forEach(c::add);
        return c;
    }

    public void addCategory(Category category)
    {
        categoryRepo.save(category);
    }


	public void deleteCategory(long category_id)
	{
		categoryRepo.deleteById(category_id);
		
	}

	public void updateCategory(long id, Category category) 
	{
		
		categoryRepo.save(category);
		
		
	}
	
	
}
