package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.Order;
import com.example.demo.data.Taco;

import lombok.extern.slf4j.Slf4j;

@Controller // Define a la clase como un controlador
@RequestMapping("/orders") // cuando un RequestMapping no se le define el metodo GET solo puede ser accedido mediante un redirect
@Slf4j // carga un objeto log con el cual se puede escribir en consola
public class OrderController {
	
	@GetMapping("/current") // current es un endpoint que se concatena a /orders/
	public String orderForm(Model model, @ModelAttribute("taco") Taco taco) {
		log.info("Taco designed: " + taco);
		
		model.addAttribute("order",new Order());
		return "orders";
	}
	
	@PostMapping //orders solo puede ser accedido desde una peticion POST
	public String processOrder(@Valid Order order, Errors errors) {
		if(errors.hasErrors()) return "orders";
		
		log.info("Order submited: " + order);
		return "redirect:/";
	}
}