package kea.server.controllers;

import kea.server.models.Store;
import kea.server.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoresController {

    @Autowired
    StoreRepository stores;

    @GetMapping("/stores")
    public Iterable<Store> getAllStores(){
        return stores.findAll();
    }

    @GetMapping("/stores/{id}")
    public Store getStoreById(@PathVariable Long id){
        return stores.findById(id).get();
    }
}
