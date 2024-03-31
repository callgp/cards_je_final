package com.je.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.je.entities.Cards;

@Repository //optional
public interface CardsRepository extends JpaRepository<Cards, Integer>{

}