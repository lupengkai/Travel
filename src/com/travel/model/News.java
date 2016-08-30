package com.travel.model;

import javax.persistence.*;
import java.security.Timestamp;

/**
 * Created by tage on 8/30/16.
 */

@Entity
public class News {
    private int id;
    private String mainTitle;
    private String author;
    private NewsType type;
    private String content;
    private Timestamp timestamp;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @OneToOne
    @JoinColumn(name = "typeId")
    public NewsType getType() {
        return type;
    }

    public void setType(NewsType type) {
        this.type = type;
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
}
