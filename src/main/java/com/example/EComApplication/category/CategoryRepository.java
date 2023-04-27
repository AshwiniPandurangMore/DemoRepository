package com.example.EComApplication.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
	public Category findBycategoryname(String categoryname);
}
