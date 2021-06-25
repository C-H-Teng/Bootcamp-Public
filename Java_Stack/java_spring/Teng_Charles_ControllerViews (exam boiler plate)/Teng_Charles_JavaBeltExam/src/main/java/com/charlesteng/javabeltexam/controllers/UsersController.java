package com.charlesteng.javabeltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charlesteng.javabeltexam.models.User;
import com.charlesteng.javabeltexam.services.UserService;

@Controller
public class UsersController {
	private final UserService userService;
	
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/register";
	}
	
	@GetMapping("/register")
	public String registerPage(@ModelAttribute("user") User user) {
		return "/login/registration.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login/login.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "/register";
		} else {
			User newUser = userService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/home";
		}
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes error) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/home";
		} else {
			error.addFlashAttribute("error", "Incorrect email or password.");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/register";
		} else {
			Long userId = (long) session.getAttribute("userId");
			model.addAttribute("user", userService.findById(userId));
			return "/login/home.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
