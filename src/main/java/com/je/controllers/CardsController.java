package com.je.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.je.entities.Cards;

import com.je.service.CardsService;

@RestController
@RequestMapping("/api/v1/cards")
public class CardsController {

	@Autowired
	private CardsService cardsService;
	
	@PostMapping
	public Cards CreateCards(@RequestBody Cards product) {
		return cardsService.createCards(product);
	}
	
	@GetMapping("/fetch/{id}")
	public Cards fetchCards(@PathVariable Integer id) {
		return cardsService.fetchCards(id);
	}
	
	@PutMapping("/update/{id}")
	public Cards updateCards(@PathVariable Integer id,@RequestBody Cards product) {
		return cardsService.updateCards(id,product);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable(value="id") Integer productId) {
		cardsService.deleteCards(productId);
	}
}
