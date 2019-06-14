package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Taco;
import com.example.demo.repositories.TacoRepository;

@Service
public class TacoService {
	
	@Autowired
	private TacoRepository repository;
	
	public List<Taco> findAll() {
		return this.repository.findAll();
	}
	
	public Taco findById(int id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public int save(Taco taco) {
		return this.repository.save(taco).getId();
	}
}
