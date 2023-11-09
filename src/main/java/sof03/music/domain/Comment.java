package sof03.music.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", nullable = false, updatable = true)
    private long commentId;
    @NotBlank
    @Size(min = 3, max = 150)
    @Column(name = "comment")
    private String content;
    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @ManyToOne
    @JsonIgnoreProperties("comments")
    @JoinColumn(name = "bandId")
    private Band band;

    @ManyToOne
    @JsonIgnoreProperties({ "comments", "password", "role" })
    @JoinColumn(name = "userId")
    private User user;

    public Comment() {
        super();
    }

    public Comment(String content, Timestamp timestamp, Band band, User user) {
        super();
        this.content = content;
        this.timestamp = timestamp;
        this.band = band;
        this.user = user;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
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

    public String getFormattedTimestamp() {
        Locale locale = new Locale("en, UK");
        return new SimpleDateFormat("MMM d. yyyy 'at' h:mm a", locale).format(timestamp);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}