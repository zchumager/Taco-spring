package com.example.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
//@RequiredArgsConstructor
@Entity(name="INGREDIENTS")
public class Ingredient {
	
	// Una enumeracion es usada para generar un conjunto de parametros validos
	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	
	}
	
	//@NonNull
	@Id
	private String id;
	
	//@NonNull
	@Column
	private String name;
	
	//@NonNull
	@Column
	private Type type;
}
