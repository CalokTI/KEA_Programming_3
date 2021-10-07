package edu.kea.paintings.repositories;

import edu.kea.paintings.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
