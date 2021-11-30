package kea.server.controllers;


import kea.server.DTO.response.PriceCreateDTO;
import kea.server.models.Price;
import kea.server.repositories.PriceRepository;
import kea.server.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PricesController {

    @Autowired
    PriceRepository prices;

    @Autowired
    StoreRepository stores;

    @GetMapping("/prices")
    public List<Price> getAllPrices(){
        return prices.findAll();
    }

    @PostMapping("/prices/{storeId}")
    public PriceCreateDTO createPrice(@RequestBody Price priceToCreate, @PathVariable Long storeId){
        return stores.findById(storeId).map(store -> {
            priceToCreate.setId(null);
            priceToCreate.setStore(store);
            Price createdPrice = prices.save(priceToCreate);
            return new PriceCreateDTO(createdPrice);
        }
        ).orElse(new PriceCreateDTO("Did not find the store by storeID"));
    }

    @DeleteMapping("/prices/{priceId}")
    public void deletePrice(@PathVariable Long priceId){
        prices.deleteById(priceId);
    }

}
