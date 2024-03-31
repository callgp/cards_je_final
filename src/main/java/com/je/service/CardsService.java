package com.je.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.je.entities.Cards;
//import com.je.entities.Product;
import com.je.repository.CardsRepository;

@Service
public class CardsService {

	@Autowired
	private CardsRepository cardsRepository;
	public Cards createCards(Cards cards) {
		Cards dbProduct=cardsRepository.save(cards);
		return dbProduct;
		
	}
	public Cards fetchCards(Integer id) {
		// TODO Auto-generated method stub
		return cardsRepository.findById(id)
		.orElseThrow(()-> new RuntimeException("cards not there in db"));
	}
	public Cards updateCards(Integer id, Cards inputProduct) {
		// TODO Auto-generated method stub
		Cards fetchDatabaseProduct = fetchCards(id);
	//	fetchDatabaseProduct.setName(inputProduct.getBranchAddress());
		Cards result=cardsRepository.save(fetchDatabaseProduct);
		return result;
	}
	public void deleteCards(Integer productId) {
		boolean isExists = cardsRepository.existsById(productId);
		if(isExists) {
			cardsRepository.deleteById(productId);
		} else {
			throw new RuntimeException("cards not in the databases");
		}
	}
}
