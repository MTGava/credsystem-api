package com.api.credsystem.manager.repositories;

import com.api.credsystem.manager.models.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Integer> {

}
