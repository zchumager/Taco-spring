package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {}
