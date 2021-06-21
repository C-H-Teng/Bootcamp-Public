package com.charlesteng.prodcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charlesteng.prodcat.models.CategoryProduct;

@Repository
public interface CatProdRepo extends CrudRepository<CategoryProduct, Long> {
	List<CategoryProduct> findAll();
	
	List<CategoryProduct> findByCategory_id(Long search);
	
	List<CategoryProduct> findByProduct_id(Long search);

}
