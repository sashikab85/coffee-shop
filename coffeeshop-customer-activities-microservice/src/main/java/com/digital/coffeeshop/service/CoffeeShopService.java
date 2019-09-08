package com.digital.coffeeshop.service;

import com.digital.coffeeshop.constants.Constants;
import com.digital.coffeeshop.entity.CoffeeShop;
import com.digital.coffeeshop.entity.Menu;
import com.digital.coffeeshop.exception.CustomException;
import com.digital.coffeeshop.model._CoffeeShop;
import com.digital.coffeeshop.model._Item;
import com.digital.coffeeshop.model._Location;
import com.digital.coffeeshop.model._Menu;
import com.digital.coffeeshop.repository.CoffeeShopRepository;
import com.digital.coffeeshop.repository.MenuRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * CoffeeShopService provides the services to CoffeeShop Controller related to coffee shop activities.
 *
 * @author Sashika Bandara
 */
@Service
public class CoffeeShopService {

    private static final Logger logger = LogManager.getLogger(CoffeeShopService.class);

    @Autowired
    private CoffeeShopRepository coffeeShopRepository;

    @Autowired
    private MenuRepository menuRepository;


    /**
     * Retrieve Coffee Shop details from the repository near to the customer.
     *
     * @param longitude
     * @param latitude
     * @return list of coffee shop details
     */
    public List<_CoffeeShop> getNearestCoffeeShop(Double longitude, Double latitude) {
        logger.debug(" CoffeeShopService,getNearestCoffeeShop with param longitude : " + longitude + "& latitude : " + latitude);

        List<_CoffeeShop> _coffeeShops = new ArrayList<>();
        List<_Location> _locations = new ArrayList<>();

        //TODO: nearest location(s) filtering according to the given longitude/latitude values.
        try {
            List<CoffeeShop> coffeeShopEntities = coffeeShopRepository.findAll();
            coffeeShopEntities.forEach(coffeeShop -> {
                _CoffeeShop _coffeeShop = new _CoffeeShop();
                coffeeShop.getLocations().forEach(location -> {
                    _Location _location = new _Location();
                    _location.setLatitude(location.getLatitude());
                    _location.setLongitude(location.getLongitude());
                    _location.setAddress(location.getAddress());
                    _locations.add(_location);
                });
                _coffeeShop.set_locations(_locations);
                _coffeeShop.setCoffeeShopId(coffeeShop.getCoffeeShopId());
                _coffeeShop.setCoffeeShopName(coffeeShop.getCoffeeShopName());
                _coffeeShop.setCoffeeShopDescription(coffeeShop.getCoffeeShopDescription());
                _coffeeShops.add(_coffeeShop);
            });
        } catch (Exception e) {
            throw new CustomException("Internal Server error !", HttpStatus.INTERNAL_SERVER_ERROR, Constants.TRUE);
        }

        return _coffeeShops;
    }

    /**
     * Retrieve Coffee Menu details from the repository specific to Coffee Shop.
     *
     * @param coffeeShopId
     * @return list of menu details
     */
    public List<_Menu> getMenuDetails(int coffeeShopId) {
        logger.debug(" CoffeeShopService,getMenuDetails with param coffeeShopId : " + coffeeShopId);
        List<_Menu> _menus = new ArrayList<>();
        List<_Item> _items = new ArrayList<>();

        try {
            List<Menu> menuEntities = menuRepository.findByShopId(coffeeShopId);
            menuEntities.forEach(menu -> {
                _Menu _menu = new _Menu();
                menu.getItems().forEach(item -> {
                    _Item _item = new _Item();
                    _item.setName(item.getItemName());
                    _item.setPrice(item.getItemPrice().toString());
                    _items.add(_item);
                });
                _menu.setItems(_items);
                _menu.setName(menu.getMenuName());
                _menus.add(_menu);
            });
        } catch (Exception e) {
            throw new CustomException("Internal Server error !", HttpStatus.INTERNAL_SERVER_ERROR, Constants.TRUE);
        }

        return _menus;
    }
}
