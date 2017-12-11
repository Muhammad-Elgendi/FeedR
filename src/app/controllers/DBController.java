package app.controllers;

import app.configurations.DBConnection;
import app.models.Feed;
import app.models.Page;
import app.models.User;
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


    public void user_insert(User User) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("insert into users (user_name,password) values ('" + User.getUsername() + "','" + User.getPassword() + "')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Boolean user_is_exist(User User) {
        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from users where user_name like '%" + User.getUsername() + "%' and password like '%" + User.getPassword() + "%'");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public int find_user_id(User User) {
        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from users where user_name like '%" + User.getUsername() + "%' and password like '%" + User.getPassword() + "%'");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                return resaultset.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return 0;
    }


    public void feed_insert(Feed Feed) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("insert into feeds (link,addition_date,user_id) values ('" + Feed.getLink() + "', UTC_DATE() ," + Feed.getUserid() + ")");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public void pages_insert(Page Page) {
        try {
            s = DBConnection.getConnection().createStatement();


            s.executeUpdate("insert into Page (id,title,description,link,publish_date,is_read,is_favourite,content,feed_id) values (" + Page.getId() + ",'" + Page.getTitle() + "','" + Page.getDescription() + "','" + Page.getLink() + "'," + Page.getPublish_date() + ",'" + Page.getIs_read() + "','" + Page.getIs_favourite() + "','" + Page.getContent() + "'," + Page.getFeed_id() + "   )");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void users_update(User User) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("update User set id=" + User.getId() + ",username='" + User.getUsername() + "', password='" + User.getPassword() + "' where id=" + User.getId() + " ");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }

    public void feeds_update(Feed Feed) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("update Feed set id=" + Feed.getId() + ",link='" + Feed.getLink() + "', addtion_date=" + Feed.getAddtion_date() + ",  user_id=" + Feed.getUserid() + " where id=" + Feed.getId() + " ");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }

    public void pages_update(Page Page) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("update Page set id=" + Page.getId() + ",title='" + Page.getTitle() + "', description='" + Page.getDescription() + "',link='" + Page.getLink() + "',publish_date=" + Page.getPublish_date() + ",is_read='" + Page.getIs_read() + "',is_favourite='" + Page.getIs_favourite() + "',content='" + Page.getContent() + "',feed_id=" + Page.getFeed_id() + " where id=" + Page.getId() + " ");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void users_delete(int id) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("delete from User where id=" + id + "");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }


    public void feeds_delete(int id) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("delete from Feed where id=" + id + "");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }


    public void pages_delete(int id) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("delete from Page where id=" + id + "");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ObservableList<User> users_getAllDB() {
        ObservableList<User> Users = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from User");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                User m = new User();
                m.setId(resaultset.getInt(1));
                m.setUsername(resaultset.getString(2));
                m.setPassword(resaultset.getString(3));

                Users.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
        return Users;
    }


    public ObservableList<Feed> feeds_getAllDB(int id) {
        ObservableList<Feed> feeds = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from feeds where user_id ="+ id);
            resaultset.beforeFirst();
            while (resaultset.next()) {
                Feed m = new Feed();
                m.setId(resaultset.getInt(1));
                m.setLink(resaultset.getString(2));
                m.setAddtion_date(resaultset.getDate(3));
                m.setUserid(resaultset.getInt(4));

                feeds.add(m);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return feeds;
    }


    public ObservableList<Page> pages_getAllDB() {
        ObservableList<Page> users = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from Page");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                Page m = new Page();
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
    public ObservableList<User> users_search(int id) {
        ObservableList<User> User = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from users where id like %" + id + "%");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                User m = new User();
                m.setId(resaultset.getInt(1));
                m.setUsername(resaultset.getString(2));
                m.setPassword(resaultset.getString(3));

                User.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

        }
        return User;
    }


//    public ObservableList<Feed> feeds_search(int id) {
//        ObservableList<Feed> users = FXCollections.observableArrayList();
//
//        try {
//            s = DBConnection.getConnection().createStatement();
//
//            ResultSet resaultset = s.executeQuery("select * from Feed where id like %" + id + "%");
//            resaultset.beforeFirst();
//            while (resaultset.next()) {
//                Feed m = new Feed();
//                m.setId(resaultset.getInt(1));
//                m.setLink(resaultset.getString(2));
//                m.setAddtion_date(resaultset.getInt(3));
//                m.setUserid(resaultset.getInt(4));
//
//                users.add(m);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//
//        }
//        return users;
//    }


    public ObservableList<Page> pages_search(int id) {
        ObservableList<Page> users = FXCollections.observableArrayList();

        try {
            s = DBConnection.getConnection().createStatement();

            ResultSet resaultset = s.executeQuery("select * from Page where id like %" + id + "%");
            resaultset.beforeFirst();
            while (resaultset.next()) {
                Page m = new Page();
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
