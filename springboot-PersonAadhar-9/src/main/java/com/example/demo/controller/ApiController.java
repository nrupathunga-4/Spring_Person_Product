package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.model.Products;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {

	@Autowired
	private ApiService apiService;
	
	@PostMapping("/save")
	public ResponseEntity<Products> saveProduct(@RequestBody Products products)
	{
		return new ResponseEntity<Products>(apiService.saveProduct(products),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{productid}")
	public ResponseEntity<Products> getProductById(@PathVariable  long productid) throws UserNotFoundException
	{
		return new ResponseEntity<Products>(apiService.getProductById(productid),HttpStatus.OK);
	}
	
	@PutMapping("/update/{productid}")
	public ResponseEntity<Products> upadteProduct(@RequestBody Products products,@PathVariable  long productid) throws UserNotFoundException
	{
		return new ResponseEntity<Products>(apiService.updateProduct(products, productid),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productid}")
	public ResponseEntity<String> deleteProduct(@PathVariable  long productid) throws UserNotFoundException
	{
		apiService.deleteProduct(productid);
		return new ResponseEntity<String>("Product is Deleted from Database",HttpStatus.OK);
	}
	
	@PostMapping("/saves")
	public ResponseEntity<Person> savePerson(@RequestBody   Person person)
	{
		return new ResponseEntity<Person>(apiService.savePerson(person),HttpStatus.CREATED);
	}
	@GetMapping("getting/{id}")
	public ResponseEntity<Person> getProductByIds(@PathVariable  long id)
	{
		return new ResponseEntity<Person>(apiService.getProductByIds(id),HttpStatus.OK);
	}
}
