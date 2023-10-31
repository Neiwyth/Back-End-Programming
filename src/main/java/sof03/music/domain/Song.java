package sof03.music.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = true)
    private long songId;
    @Column(name = "name", nullable = false)
    private String songName;
    @Column(name = "published", nullable = false)
    private int publicationYear;
    @Column(name = "album", nullable = false)
    private String album;

    @ManyToOne()
    @JsonIgnoreProperties("songs")
    @JoinColumn(name = "bandId")
    private Band band;

    public Song() {
        super();
    }

    public Song(String songName, int publicationYear, String album, Band band) {
        super();
        this.songName = songName;
        this.publicationYear = publicationYear;
        this.album = album;
        this.band = band;
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

}
