package com.example.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data // Genera automaticamente setter, getters para cada atributo, asi como el constructor por defecto
@Entity(name="ORDERS")
public class Order {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(message="Name is Required")
	@Column
	private String name;
	
	@NotBlank(message="Street is Required")
	@Column
	private String street;
	
	@NotBlank(message="City is Required")
	@Column
	private String city;
	
	@NotBlank(message="State is Required")
	@Column
	private String state;
	
	@NotBlank(message="Zip code is Required")
	@Column
	private String zip;
    
	@CreditCardNumber(message="Credit Card Number not valid")
	@Column
	private String ccNumber;
    
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
	@Column
	private String ccExpiration;
    
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	@Column
    private String ccCVV;
}
