package app.controllers;

import app.configurations.DBConnection;
import app.models.feed;
import app.models.page;
import app.models.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Butcher
 */
public class DBController {

    Statement s;


    public void users_insert(user user) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("insert into user (id,username,password,) values (" + user.getId() + ",'" + user.getUsername() + "','" + user.getPassword() + "')");
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }


    public void feeds_insert(feed feed) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("insert into feed (id,link,addition_date,user_id) values (" + feed.getId() + ",'" + feed.getLink() + "'," + feed.getAddtion_date() + "," + feed.getUserid() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }


    public void pages_insert(page page) {
        try {
            s = DBConnection.getConnection().createStatement();


            s.executeUpdate("insert into page (id,title,description,link,publish_date,is_read,is_favourite,content,feed_id) values (" + page.getId() + ",'" + page.getTitle() + "','" + page.getDescription() + "','" + page.getLink() + "'," + page.getPublish_date() + ",'" + page.getIs_read() + "','" + page.getIs_favourite() + "','" + page.getContent() + "'," + page.getFeed_id() + "   )");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void users_update(user user) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("update user set id=" + user.getId() + ",username='" + user.getUsername() + "', password='" + user.getPassword() + "' where id=" + user.getId() + " ");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }

    public void feeds_update(feed feed) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("update feed set id=" + feed.getId() + ",link='" + feed.getLink() + "', addtion_date=" + feed.getAddtion_date() + ",  user_id=" + feed.getUserid() + " where id=" + feed.getId() + " ");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }

    public void pages_update(page page) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("update page set id=" + page.getId() + ",title='" + page.getTitle() + "', description='" + page.getDescription() + "',link='" + page.getLink() + "',publish_date=" + page.getPublish_date() + ",is_read='" + page.getIs_read() + "',is_favourite='" + page.getIs_favourite() + "',content='" + page.getContent() + "',feed_id=" + page.getFeed_id() + " where id=" + page.getId() + " ");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void users_delete(int id) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("delete from user where id=" + id + "");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }


    public void feeds_delete(int id) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("delete from feed where id=" + id + "");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }


    public void pages_delete(int id) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("delete from page where id=" + id + "");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ObservableList<user> users_getAllDB() {
        ObservableList<user> users = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from user");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                user m = new user();
                m.setId(resaultset.getInt(1));
                m.setUsername(resaultset.getString(2));
                m.setPassword(resaultset.getString(3));

                users.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
        return users;
    }


    public ObservableList<feed> feeds_getAllDB() {
        ObservableList<feed> users = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from feed");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                feed m = new feed();
                m.setId(resaultset.getInt(1));
                m.setLink(resaultset.getString(2));
                m.setAddtion_date(resaultset.getInt(3));
                m.setUserid(resaultset.getInt(4));

                users.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
        return users;
    }


    public ObservableList<page> pages_getAllDB() {
        ObservableList<page> users = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from page");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                page m = new page();
                m.setId(resaultset.getInt(1));
                m.setTitle(resaultset.getString(2));
                m.setDescription(resaultset.getString(3));
                m.setLink(resaultset.getString(4));
                m.setPublish_date(resaultset.getInt(5));
                m.setIs_read(resaultset.getBoolean(6));
                m.setIs_favourite(resaultset.getBoolean(7));
                m.setContent(resaultset.getString(8));
                m.setFeed_id(resaultset.getInt(9));

                users.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
        return users;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ObservableList<user> users_search(int id) {
        ObservableList<user> user = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from user where id like %" + id + "%");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                user m = new user();
                m.setId(resaultset.getInt(1));
                m.setUsername(resaultset.getString(2));
                m.setPassword(resaultset.getString(3));

                user.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
        return user;
    }


    public ObservableList<feed> feeds_search(int id) {
        ObservableList<feed> users = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from feed where id like %" + id + "%");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                feed m = new feed();
                m.setId(resaultset.getInt(1));
                m.setLink(resaultset.getString(2));
                m.setAddtion_date(resaultset.getInt(3));
                m.setUserid(resaultset.getInt(4));

                users.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
        return users;
    }


    public ObservableList<page> pages_search(int id) {
        ObservableList<page> users = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from page where id like %" + id + "%");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                page m = new page();
                m.setId(resaultset.getInt(1));
                m.setTitle(resaultset.getString(2));
                m.setDescription(resaultset.getString(3));
                m.setLink(resaultset.getString(4));
                m.setPublish_date(resaultset.getInt(5));
                m.setIs_read(resaultset.getBoolean(6));
                m.setIs_favourite(resaultset.getBoolean(7));
                m.setContent(resaultset.getString(8));
                m.setFeed_id(resaultset.getInt(9));

                users.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
        return users;
    }


}
