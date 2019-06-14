package com.example.demo.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity(name="TACOS")
public class Taco {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min=5, message="Name must be at least five characters long")
	@Column
	private String name;
	
	@Size(min=1, message="You must choose at least one ingredient")
	@Column
	@ManyToMany
	private List<Ingredient> ingredients;
}
