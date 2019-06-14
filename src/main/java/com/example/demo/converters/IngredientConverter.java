package com.example.demo.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.data.Ingredient;
import com.example.demo.services.IngredientService;

@Component
public class IngredientConverter implements Converter<String, Ingredient>{
	
	/* Un converter se utiliza para regresar un objeto en funcion de un grupo de ids que se mande desde el metodo POST
	 * */
	
	@Autowired
	private IngredientService service;
	
	@Override // Se recibe un id y se regresa un objeto
	public Ingredient convert(String id) {
		
		// Se vuelven a cargar los datos, esto puede cambiarse por un findAll() que obtenga los registros de la Base de Datos
		/*
		 * List<Ingredient> ingredients = Arrays.asList( new Ingredient("FLTO",
		 * "Flour Tortilla", Type.WRAP) , new Ingredient("COTO", "Corn Tortilla",
		 * Type.WRAP) , new Ingredient("GRBF", "Ground Beef", Type.PROTEIN) , new
		 * Ingredient("CARN", "Carnitas", Type.PROTEIN) , new Ingredient("TMTO",
		 * "Diced Tomatoes", Type.VEGGIES) , new Ingredient("LETC", "Lettuce",
		 * Type.VEGGIES) , new Ingredient("CHED", "Cheddar", Type.CHEESE) , new
		 * Ingredient("JACK", "Monterrey Jack", Type.CHEESE) , new Ingredient("SLSA",
		 * "Salsa", Type.SAUCE) , new Ingredient("SRCR", "Sour Cream", Type.SAUCE) );
		 */
		
		List<Ingredient> ingredients = this.service.findAll();
		
		// Se regresa un objeto en particular a la vista
		return ingredients.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList()).get(0);
	}

}
