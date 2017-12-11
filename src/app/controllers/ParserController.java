package app.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class ParserController {

    public String feedURL;

    public ParserController(String feedUrl) {
        this.feedURL=feedUrl;
    }

    public void parse(String feedUrl){
        try {
            URL url=new URL(feedUrl);
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(connection));
            List entities = feed.getEntries();
            Iterator iterator = entities.iterator();
            while (iterator.hasNext()) {
                SyndEntry entity = (SyndEntry) iterator.next();
                System.out.println("");
                System.out.println("Title : " + entity.getTitle());
                System.out.println("Description : " + entity.getDescription());
                System.out.println("Publish Date : " + entity.getPublishedDate());
                System.out.println("Link : " + entity.getLink());
                System.out.println("");
            }

        } catch (MalformedURLException ex) {

        } catch (IOException ex) {

        } catch (IllegalArgumentException ex) {

        } catch (FeedException ex) {

        }
    }

    public static boolean validate_feed(String feedUrl){
        return true;
//        try {
//            URL url = new URL(feedUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            SyndFeed feed = new SyndFeedInput().build(new XmlReader(connection));
//
//            return true;
//        }
//        catch (FeedException ex){
//            ex.printStackTrace();
//        }
//        catch (MalformedURLException ex){
//            ex.printStackTrace();
//        }
//        catch (IOException ex){
//            ex.printStackTrace();
//        }
//        return false;
    }
}
