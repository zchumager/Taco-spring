package com.example.demo.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.data.Ingredient;
import com.example.demo.data.Taco;
import com.example.demo.services.IngredientService;

import lombok.extern.slf4j.Slf4j;

@Controller // Define a la clase como un controlador
@RequestMapping("/design")
@Slf4j // carga un objeto log con el cual se puede escribir en consola
public class DesignTacoController { 
	
	@Autowired
	private IngredientService service;
	
	@GetMapping // Se indica que este metodo se ejecuta cuando el endpoint: /design recibe una peticion GET
	public String showDesignForm(Model model) {
		
		/* El metodo tiene un parametro model debido a que con este se cargan datos a la vista (el archivo html)
		 * 
		 * Alternativamente se puede no definir este parametro y en su lugar generar la instancia de ModelMap o de ModelAndView
		 * para pasarle datos a la vista
		 * 
		 * */
		
		Ingredient.Type[] types = Ingredient.Type.values();
		
		//Esto puede ser reemplazado por un findAll() y traer los registros desde una Base de Datos
//		List<Ingredient> ingredients = Arrays.asList(
//				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP)
//			    , new Ingredient("COTO", "Corn Tortilla", Type.WRAP)
//			    , new Ingredient("GRBF", "Ground Beef", Type.PROTEIN)
//			    , new Ingredient("CARN", "Carnitas", Type.PROTEIN)
//			    , new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES)
//			    , new Ingredient("LETC", "Lettuce", Type.VEGGIES)
//			    , new Ingredient("CHED", "Cheddar", Type.CHEESE)
//			    , new Ingredient("JACK", "Monterrey Jack", Type.CHEESE)
//			    , new Ingredient("SLSA", "Salsa", Type.SAUCE)
//			    , new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
//		);
		
		List<Ingredient> ingredients = service.findAll();
		
		List<Ingredient> group;
		String typeName;
		
		//Por cada uno de los tipos de ingredientes
		for(Ingredient.Type type: types) {
			//se genera una lista que representa un grupo en particular con una funcion de filtrado
			group = ingredients.stream().filter(e -> e.getType().equals(type)).collect(Collectors.toList());
			typeName = type.toString().toLowerCase();
			
			//se carga al mapa modelo cada una de las listas las cuales se identifican por una llave
			model.addAttribute(
					typeName //llave de identificacion
					, group // grupo obtenido del fitrado
			);
		}
		
		//Se agrega al mapa model un objeto de la clase Taco con la llave de identificacion taco
		model.addAttribute("taco", new Taco());
		
		//se indica el nombre del archivo html donde se cargara el mapa modelo
		return "design";
	}
	
	@PostMapping // Se indica que este metodo se ejecuta cuando el endpoint; /design recibe una peticion get
	public String processDesign(RedirectAttributes redirectAttr, @Valid Taco taco, Errors errors) {
		//Se recibe por parametro un objeto de tipo Taco el cual es enviado desde el Formulario
		
		log.info("Procesing design: "+ taco);
		
		//Se imprime el nombre y el objeto en si
		log.info("Taco name: " + taco.getName());
		taco.getIngredients().stream().forEach(e -> log.info("Ingredient: "+e));
		
		redirectAttr.addFlashAttribute("taco", taco);
		
		return "redirect:/orders/current";
	}
}