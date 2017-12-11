/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author Butcher
 */
public class Page {
    
    int id;
    String title;
    String description;
    String link;
    int publish_date;
    boolean is_read;
    boolean is_favourite;
    String content;
    int feed_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(int publish_date) {
        this.publish_date = publish_date;
    }

    public boolean getIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }

    public boolean getIs_favourite() {
        return is_favourite;
    }

    public void setIs_favourite(boolean is_favourite) {
        this.is_favourite = is_favourite;
    }

 
    

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(int feed_id) {
        this.feed_id = feed_id;
    }
    
    
    
    
}
