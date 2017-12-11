package app.models;

/**
 *
 * @author Butcher
 */
public class Feed {
    
    int id;
    String link;
    java.sql.Date addtion_date;
    int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public java.sql.Date getAddtion_date() {
        return addtion_date;
    }

    public void setAddtion_date(java.sql.Date addtion_date) {
        this.addtion_date = addtion_date;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
    
    
}
