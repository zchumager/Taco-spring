package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.Taco;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Integer> {}
