package sof03.music.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BandComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = true)
    private long bandCommentId;
    @Column(name = "comment", nullable = false)
    private String content;
    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @ManyToOne
    @JsonIgnoreProperties("bandComments")
    @JoinColumn(name = "bandId")
    private Band band;

    public BandComment() {
        super();
    }

    public BandComment(String content, Timestamp timestamp) {
        super();
        this.content = content;
        this.timestamp = timestamp;
    }

    public long getBandCommentId() {
        return bandCommentId;
    }

    public void setBandCommentId(long bandCommentId) {
        this.bandCommentId = bandCommentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

}