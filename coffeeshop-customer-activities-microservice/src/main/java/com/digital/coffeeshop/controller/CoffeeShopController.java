package com.digital.coffeeshop.controller;


import com.digital.coffeeshop.model._CoffeeShop;
import com.digital.coffeeshop.model._Menu;
import com.digital.coffeeshop.service.CoffeeShopService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CoffeeShopController is the mail component handles the activities related to coffee shop.
 *
 * @author Sashika Bandara
 */
@RestController
@RequestMapping("/coffeeshop")
@CrossOrigin
public class CoffeeShopController {
    private static final Logger logger = LogManager.getLogger(CoffeeShopController.class);
    @Autowired
    private CoffeeShopService coffeeShopService;

    /**
     * This provide the nearest coffee shop details
     *
     * @param longitude
     * @param latitude
     * @return coffee shop details
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getCoffeeShopDetails(@RequestParam Double longitude, @RequestParam Double latitude) {
        logger.debug(" CoffeeShopController,getCoffeeShopDetails with request param(s) longitude : " + longitude + "& latitude : " + latitude);
        List<_CoffeeShop> coffeeShops = coffeeShopService.getNearestCoffeeShop(longitude, latitude);
        if (!CollectionUtils.isEmpty(coffeeShops)) {
            return ResponseEntity.ok(coffeeShops);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * This provide the menu details specific to coffee shop.
     *
     * @param coffeeShopId
     * @return menu details
     */
    @RequestMapping(value = "/{coffeeshop-id}/menu", method = RequestMethod.GET)
    public ResponseEntity getCoffeeShopMenuDetails(@PathVariable(name = "coffeeshop-id") int coffeeShopId) {
        logger.debug(" CoffeeShopController,getCoffeeShopMenuDetails with request param(s) coffeeShopId : " + coffeeShopId);
        List<_Menu> menues = coffeeShopService.getMenuDetails(coffeeShopId);
        if (!CollectionUtils.isEmpty(menues)) {
            return ResponseEntity.ok(menues);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
