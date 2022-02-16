package com.boot.restaurantapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.restaurantapi.entities.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	/*Optional<Restaurant> findById(Long id);	
	Optional<Restaurant> findByName(String name);	
	@Query("SELECT * FROM booking_restaurant.restaurant")
	List<Restaurant> findRestaurants();*/
	
}
 