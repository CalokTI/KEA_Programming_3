package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Gallery;
import edu.kea.paintings.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Galleries {

    @Autowired
    GalleryRepository galleries;

    @GetMapping("/galleries")
    public Iterable<Gallery> getGalleries(){
        return galleries.findAll();
    }

    @GetMapping("/galleries/{id}")
    public Gallery getGalleryByID(@PathVariable long id){
        return galleries.findById(id).get();
    }

    @PostMapping("/galleries")
    public Gallery addGallery(@RequestBody Gallery newGallery){
        return galleries.save(newGallery);
    }

    @PutMapping("/galleries/{id}")
    public Gallery replaceGalleryByID(@PathVariable long id, @RequestBody Gallery gallery){
        if(galleries.existsById(id)){
            gallery.setId(id);
        }
        return galleries.save(gallery);
    }

    @PatchMapping("/galleries/{id}")
    public String updateGalleryByID(@PathVariable long id, @RequestBody Gallery newGallery){
        return galleries.findById(id).map(foundGallery -> {
            if (newGallery.getName() != null){
                foundGallery.setName(newGallery.getName());
            }
            if (newGallery.getOwner() != null){
                foundGallery.setOwner(newGallery.getOwner());
            }
            if (newGallery.getLocation() != null){
                foundGallery.setLocation(newGallery.getLocation());
            }
            if (newGallery.getSquareFeet() != 0){
                foundGallery.setSquareFeet(newGallery.getSquareFeet());
            }
            galleries.save(foundGallery);
            return "Painting updated";
        }).orElse("Painting not found");
    }

    @DeleteMapping("/galleries/{id}")
    public void deleteGalleryByID(@PathVariable long id){
        galleries.deleteById(id);
    }
}
