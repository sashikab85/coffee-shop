package com.digital.coffeeshop.repository;


import com.digital.coffeeshop.entity.CoffeeShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeShopRepository extends JpaRepository<CoffeeShop, Integer> {

}
