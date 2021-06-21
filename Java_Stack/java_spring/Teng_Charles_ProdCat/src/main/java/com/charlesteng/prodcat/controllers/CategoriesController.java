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
import org.springframework.web.bind.annotation.RequestParam;

import com.charlesteng.prodcat.models.Category;
import com.charlesteng.prodcat.models.CategoryProduct;
import com.charlesteng.prodcat.models.Product;
import com.charlesteng.prodcat.services.CategoryService;
import com.charlesteng.prodcat.services.ProductService;

@Controller
public class CategoriesController {
	private final CategoryService catService;
	private final ProductService prodService;
	
	public CategoriesController(CategoryService catService, ProductService prodService) {
		this.catService = catService;
		this.prodService = prodService;
	}
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/categories";
	}
	
	@GetMapping("/categories")
	public String index(Model model) {
		List<Category> cat = catService.allCategories();
		model.addAttribute("categories", cat);
		return "/categories/index.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCat(@ModelAttribute("category") Category cat) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("/categories")
	public String create(@Valid @ModelAttribute("category") Category cat, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			catService.createCategory(cat);
			return "redirect:/categories";
		}
	}
	
	@GetMapping("/categories/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Category cat = catService.findCategory(id);
		List<Product> inCategory = cat.getProducts(); // all products
		List<Product> notInCat = prodService.allProducts();
		notInCat.removeAll(inCategory);
		
		model.addAttribute("category", cat);
		// list products in category
		model.addAttribute("prodInCat", inCategory);
		System.out.println(inCategory);
		// list products NOT in category *to add*
		model.addAttribute("notInCat", notInCat);
//		System.out.println(cat.getProducts());
		
		return "/categories/show.jsp";
	}
	
	// add product to category
	@PostMapping("/categories/{id}/cat")
	public String update(@RequestParam("product_id") Long prodId, @PathVariable("id") Long catId) {
		Category cat = catService.findCategory(catId);
		Product prod = prodService.findProduct(prodId);
		List<Category> catProducts = prod.getCategories();
		catProducts.add(cat);
		prodService.updateProduct(prod); // need to update product side after adding to category
		
		return "redirect:/categories/{id}";
	}

}
