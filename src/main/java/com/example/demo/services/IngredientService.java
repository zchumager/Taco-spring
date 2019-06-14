package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Ingredient;
import com.example.demo.repositories.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository repository;
	
	public List<Ingredient> findAll() {
		return this.repository.findAll();
	}
	
	public Ingredient findById(String id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public String save(Ingredient ingredient) {
		return this.repository.save(ingredient).getId();
	}
	
	public void delete(String id) {
		this.repository.deleteById(id);
	}
}
