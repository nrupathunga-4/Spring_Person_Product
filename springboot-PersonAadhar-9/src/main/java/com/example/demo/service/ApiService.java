package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.model.Products;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ApiService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	
	public Products saveProduct(Products products)
	{
		return productRepository.save(products);
	}
	
	public Products getProductById(long productid) throws UserNotFoundException
	{
		return productRepository.findById(productid).orElseThrow(()->new UserNotFoundException("Product Doesn't Exsit in Database"));
	}
	
	public Products updateProduct(Products products,long productid) throws UserNotFoundException
	{
		Products products2=productRepository.findById(productid).orElseThrow(()->new UserNotFoundException("Product Doesn't Exsit in Database"));
		products2.setManufacturingdate(products.getManufacturingdate());
		products2.setExpirydate(products.getExpirydate());
		
		productRepository.save(products2);
		return products2;
		
	}
	
	public void deleteProduct(long productid) throws UserNotFoundException
	{
		productRepository.findById(productid).orElseThrow(()->new UserNotFoundException("Product Doesn't Exsit in Database"));
		productRepository.deleteById(productid);
	}
	
	public Person savePerson(Person person)
	{
		return personRepository.save(person);
	}
	public Person getProductByIds(long id)
	{
		return personRepository.findById(id).orElse(null);
	}
}


