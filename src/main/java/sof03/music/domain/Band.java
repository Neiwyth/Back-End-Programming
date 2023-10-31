package sof03.music.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = true)
    private long bandId;
    @Column(name = "name", nullable = false)
    private String bandName;
    @Column(name = "formed", nullable = false)
    private int yearFormed;
    @Column(name = "country", nullable = false)
    private String countryOfOrigin;
    @Column(name = "genre", nullable = false)
    private String genre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    @JsonIgnoreProperties("band")
    private List<BandComment> bandComments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    @JsonIgnoreProperties("band")
    private List<Song> songs;

    public Band() {
        super();
    }

    public Band(String bandName, int yearFormed, String countryOfOrigin, String genre) {
        super();
        this.bandName = bandName;
        this.yearFormed = yearFormed;
        this.countryOfOrigin = countryOfOrigin;
        this.genre = genre;
    }

    public long getBandId() {
        return bandId;
    }

    public void setBandId(long bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getYearFormed() {
        return yearFormed;
    }

    public void setYearFormed(int yearFormed) {
        this.yearFormed = yearFormed;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<BandComment> getBandComments() {
        return bandComments;
    }

    public void setBandComments(List<BandComment> bandComments) {
        this.bandComments = bandComments;
    }

}