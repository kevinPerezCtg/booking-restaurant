package com.boot.restaurantapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.restaurantapi.entities.Turn;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {
	
	Optional<Turn> findById(Long id);
	
}
