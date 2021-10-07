package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Painting;
import edu.kea.paintings.repositories.PaintingRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "Paintings REST Controller", description = "REST endpoints for paintings")
@RestController
public class Paintings {

    @Autowired
    PaintingRepository paintings;

    @GetMapping("/paintings")
    public Iterable<Painting> getPaintings() {
        return paintings.findAll();
    }

    @GetMapping("/paintings/{id}")
    public Painting getPaitingsByID(@PathVariable Long id) {
        return paintings.findById(id).get();
    }

    @GetMapping("/paintings/timeline")
    public List<Painting> getPaintingsByArtistAndYear(@RequestParam String artistName, @RequestParam int year) {
        return paintings.findPaintingsByArtistAndYear(artistName, year);
    }

    @GetMapping("/paintings/priceabove/{price}")
    public List<Painting> getPaintingsAboveACertainPrice(@PathVariable double price){
        System.out.println(price);
        return paintings.findPaintingsByPriceGreaterThan(price);
    }

    @PostMapping("/paintings")
    public Painting addPaiting(@RequestBody Painting painting) {
        return paintings.save(painting);
    }

    @PutMapping("/paintings/{id}")
    public Painting replacePaintingByID(@PathVariable Long id, @RequestBody Painting newPainting) {
        if (paintings.existsById(id)) {
            newPainting.setId(id);
        }
        return paintings.save(newPainting);
    }

    @PatchMapping("/paintings/{id}")
    public String updatePaintingByID(@PathVariable Long id, @RequestBody Painting newPainting) {
        return paintings.findById(id).map(foundPainting -> {
            if (newPainting.getArtist() != null) {
                foundPainting.setArtist(newPainting.getArtist());
            }
            if (newPainting.getTitle() != null) {
                foundPainting.setTitle(newPainting.getTitle());
            }
            if (newPainting.getPrice() != 0) {
                foundPainting.setPrice(newPainting.getPrice());
            }
            if (newPainting.getGenre() != null) {
                foundPainting.setGenre(newPainting.getGenre());
            }
            if (newPainting.getYear() != 0) {
                foundPainting.setYear(newPainting.getYear());
            }
            paintings.save(foundPainting);
            return "Painting updated";
        }).orElse("Painting not found");
    }

    @DeleteMapping("/paintings/{id}")
    public void deletePaintingByID(@PathVariable Long id) {
        paintings.deleteById(id);
    }
}
