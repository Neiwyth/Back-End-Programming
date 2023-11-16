package sof03.music.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BandRepository extends CrudRepository<Band, Long> {

    @Query("SELECT new Band(b.bandId, b.bandName, b.yearFormed, b.countryOfOrigin, b.genre) FROM Band b")
    List<Band> findAllBands();

    @Query("SELECT b FROM Band b JOIN FETCH b.songs WHERE b.id = :bandId")
    Optional<Band> getAllSongsForBand(@Param("bandId") Long bandId);

}
