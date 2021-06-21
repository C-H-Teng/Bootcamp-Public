package com.charlesteng.prodcat.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charlesteng.prodcat.models.Category;
import com.charlesteng.prodcat.models.CategoryProduct;
import com.charlesteng.prodcat.models.Product;
import com.charlesteng.prodcat.services.CategoryService;
import com.charlesteng.prodcat.services.ProductService;

@Controller
public class ProductsController {
	private final CategoryService catService;
	private final ProductService prodService;
	
	public ProductsController(CategoryService catService, ProductService prodService) {
		this.catService = catService;
		this.prodService = prodService;
	}
	
	@GetMapping("/products")
	public String index(Model model) {
		List<Product> prod = prodService.allProducts();
		model.addAttribute("products", prod);
		return "/products/index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newCat(@ModelAttribute("product") Product prod) {
		return "/products/new.jsp";
	}
	
	@PostMapping("/products")
	public String create(@Valid @ModelAttribute("product") Product prod, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		} else {
			prodService.createProduct(prod);
			return "redirect:/products";
		}
	}
	
	@GetMapping("/products/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Product prod = prodService.findProduct(id);
		List<Category> inProduct = prod.getCategories(); // all categories in product
		List<Category> notInProd = catService.allCategories(); // all categories
		notInProd.removeAll(inProduct);
		
		model.addAttribute("product", prod);
		// list categories product belongs to
		model.addAttribute("catInProd", inProduct);
		// list categories that products do NOT belong to *to add*
		model.addAttribute("notInProd", notInProd);
		
		return "/products/show.jsp";
	}
	
	// add category to product
	@PostMapping("/products/{id}/prod")
	public String update(@RequestParam("category_id") Long catId, @PathVariable("id") Long prodId) {
		Category cat = catService.findCategory(catId);
		Product prod = prodService.findProduct(prodId);
		List<Product> prodCats = cat.getProducts();
		prodCats.add(prod);
		catService.updateCategory(cat); // need to also update category side after adding to product
		
		return "redirect:/products/{id}";
	}

}
