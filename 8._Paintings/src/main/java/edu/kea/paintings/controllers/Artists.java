package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Artist;
import edu.kea.paintings.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class Artists {

    @Autowired
    ArtistRepository artists;

    @GetMapping("/artists")
    public Iterable<Artist> getArtists(){
        return artists.findAll();
    }

    @GetMapping("/artists/{id}")
    public Artist getArtistByID(@PathVariable long id){
        return artists.findById(id).get();
    }

    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist newArtist){
        newArtist.setId(null);
        return artists.save(newArtist);
    }

    @PostMapping("/artists/galleries/{artistId}/{galleryId}")
    public Artist addGalleryToArtist(@PathVariable Long artistId, @PathVariable Long galleryId){

        Artist foundArtist = artists.findById(artistId).get();
        System.out.println(foundArtist);
        return null;
    }

    @PutMapping("/artists/{id}")
    public Artist replaceArtistByID(@PathVariable long id, @RequestBody Artist artist){
        if(artists.existsById(id)){
            artist.setId(id);
        }
        return artists.save(artist);
    }

    @PatchMapping("/artist/{id}")
    public String updateArtistByID(@PathVariable Long id, @RequestBody Artist newArtist){
        return artists.findById(id).map(foundArtist -> {
            if (newArtist.getName() != null){
                foundArtist.setName(newArtist.getName());
            }
            if (newArtist.getAge() != 0){
                foundArtist.setAge(newArtist.getAge());
            }
            if (newArtist.getNationality() != null){
                foundArtist.setNationality(newArtist.getNationality());
            }
            if (newArtist.getPrimaryStyle() != null){
                foundArtist.setPrimaryStyle(newArtist.getPrimaryStyle());
            }
            if (newArtist.getBirthDate() != null){
                foundArtist.setBirthDate(newArtist.getBirthDate());
            }
            if (newArtist.getGender() != null){
                foundArtist.setGender(newArtist.getGender());
            }
            artists.save(foundArtist);
            return "Artist updated";
        }).orElse("Artist not found");
    }

    @DeleteMapping("/artist/{id}")
    public void deleteArtistByID(@PathVariable long id){
        artists.deleteById(id);
    }
}
