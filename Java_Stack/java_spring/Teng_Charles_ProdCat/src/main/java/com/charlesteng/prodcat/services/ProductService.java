package com.charlesteng.prodcat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlesteng.prodcat.models.CategoryProduct;
import com.charlesteng.prodcat.models.Product;
import com.charlesteng.prodcat.repositories.CatProdRepo;
import com.charlesteng.prodcat.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo prodRepo;
	private final CatProdRepo catProdRepo;
	
	public ProductService(ProductRepo prodRepo, CatProdRepo catProdRepo) {
		this.prodRepo = prodRepo;
		this.catProdRepo = catProdRepo;
	}
	
	public List<Product> allProducts(){
		return prodRepo.findAll();
	}
	
	// find products in category
	public List<CategoryProduct> productsInCategory(Long catId){
		return catProdRepo.findByCategory_id(catId);
	}
	
	// find products not in category
	public List<Product> productsNotInCategory(Long catId){
		List<CategoryProduct> inCat = catProdRepo.findByCategory_id(catId);
		List<Product> allProd = prodRepo.findAll();
		List<Product> notInCat = new ArrayList<Product>();
		
		for(int i = 0; i < allProd.size(); i++) {
			if(inCat.contains(allProd.get(i)) == false) {
				notInCat.add(allProd.get(i));
			}
		}
		
		return notInCat;
	}
	
	public Product findProduct(Long id) {
		Optional<Product> opProd = prodRepo.findById(id);
		if(opProd.isPresent()) {
			return opProd.get();
		} else {
			return null;
		}
	}
	
	public Product createProduct(Product prod) {
		return prodRepo.save(prod);
	}
	
	public Product updateProduct(Product prod) {
		return prodRepo.save(prod);
	}
	
	public void deleteProduct(Long id) {
		prodRepo.deleteById(id);
	}

}
