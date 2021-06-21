package com.charlesteng.prodcat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlesteng.prodcat.models.Category;
import com.charlesteng.prodcat.models.CategoryProduct;
import com.charlesteng.prodcat.models.Product;
import com.charlesteng.prodcat.repositories.CatProdRepo;
import com.charlesteng.prodcat.repositories.CategoryRepo;

@Service
public class CategoryService {
	private final CatProdRepo catProdRepo;
	private final CategoryRepo catRepo;
	
	public CategoryService(CatProdRepo catProdRepo, CategoryRepo catRepo) {
		this.catProdRepo = catProdRepo;
		this.catRepo = catRepo;
	}
	
	public List<Category> allCategories(){
		return catRepo.findAll();
	}
	
	public List<CategoryProduct> categoriesInProduct(Long prodId){
		return catProdRepo.findByProduct_id(prodId);
	}
	
	public List<Category> categoriesNotInProduct(Long prodId){
		List<CategoryProduct> inProd = catProdRepo.findByCategory_id(prodId);
		List<Category> allCategories = catRepo.findAll();
		List<Category> notInProd = new ArrayList<Category>();
		
		for(int i = 0; i < allCategories.size(); i++) {
			if(inProd.contains(allCategories.get(i)) == false) {
				notInProd.add(allCategories.get(i));
			}
		}
		
		return notInProd;
	}
	
	public Category createCategory(Category cat) {
		return catRepo.save(cat);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> opCat = catRepo.findById(id);
		if(opCat.isPresent()) {
			return opCat.get();
		} else {
			return null;
		}
	}
	
	public Category addProduct(Category cat, Product prod) {
		List<Product> prodList = cat.getProducts();
		prodList.add(prod);
		cat.setProducts(prodList);

		return catRepo.save(cat);
	}
	
	public Category updateCategory(Category cat) {
		return catRepo.save(cat);
	}
	
	public void deleteCategory(Long id) {
		catRepo.deleteById(id);
	}

}
