package app.controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;
import app.models.User;
import static org.junit.Assert.*;

public class DBControllerTest {
    @Test
    public void user_insert() {
    }

    @Test
    public void user_is_exist() {
        boolean t=true;
        boolean f=false;
        DBController s=new DBController();
        User user=new User();
        user.setUsername("");
        user.setPassword("");
        boolean r= s.user_is_exist(user);
        assertEquals(t|f,r);
    }

    @Test
    public void find_user_id() {
        int id =6;
        DBController s=new DBController();
        User user=new User();
        user.setUsername("0");
        user.setPassword("0");
        int r= s.find_user_id(user);
        assertEquals(id,r);
    }

    @Test
    public void feed_insert() {
    }

    @Test
    public void feed_delete() {
    }

    @Test
    public void feed_update() {
    }

    @Test
    public void page_insert() {
    }

    @Test
    public void find_feed_id() {
        DBController s=new DBController();
        String url ="https://youtube.com";
        int r= s.find_feed_id(url);
        assertEquals(0,r);
    }

    @Test
    public void users_update() {
    }

    @Test
    public void pages_update() {
    }

    @Test
    public void users_delete() {
    }

    @Test
    public void feeds_delete() {
    }

    @Test
    public void pages_delete() {
    }

    @Test
    public void pages_clear_all() {
    }

    @Test
    public void users_getAllDB() {

    }

    @Test
    public void feeds_getAll() {
    }

    @Test
    public void feeds_getAllDB() {
    }

    @Test
    public void users_search() {
    }
}