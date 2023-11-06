package sof03.music.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
// import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = true)
    private long songId;
    @NotBlank
    @Column(name = "name", nullable = false)
    private String songName;
    @Min(value = 1900, message = "valid values are between 1900 and 2023")
    @Max(value = 2023, message = "valid values are between 1900 and 2023")
    @Column(name = "published")
    private int publicationYear;
    @NotBlank
    @Column(name = "album")
    private String album;
    // @Transient
    @Column(columnDefinition = "CLOB")
    private String spotifyLink;
    // @Transient
    @Column(columnDefinition = "CLOB")
    private String youtubeLink;

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

    public Song(String songName, int publicationYear, String album, Band band, String spotifyLink, String youtubeLink) {
        super();
        this.songName = songName;
        this.publicationYear = publicationYear;
        this.album = album;
        this.band = band;
        this.spotifyLink = spotifyLink;
        this.youtubeLink = youtubeLink;
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

    public String getSpotifyLink() {
        return spotifyLink;
    }

    public void setSpotifyLink(String spotifyLink) {
        this.spotifyLink = spotifyLink;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

}