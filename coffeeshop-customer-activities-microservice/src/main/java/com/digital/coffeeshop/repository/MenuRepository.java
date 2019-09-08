package com.digital.coffeeshop.repository;


import com.digital.coffeeshop.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @Query("SELECT _menu from Menu _menu where _menu.shopId = ?1")
    List<Menu> findByShopId(int coffeeShopId);
}
