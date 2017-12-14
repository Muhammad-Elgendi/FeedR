package app.controllers;

import app.models.Page;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParserController {

    public static void parseAndUpdate(ArrayList<String> feeds) {
        try {
            DBController controller = new DBController();
            for (int i = 0; i < feeds.size(); i++) {
                String feedUrl = feeds.get(i);
                URL url = new URL(feedUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                SyndFeed feed = new SyndFeedInput().build(new XmlReader(connection));
                List entities = feed.getEntries();
                Iterator iterator = entities.iterator();
                while (iterator.hasNext()) {
                    SyndEntry entity = (SyndEntry) iterator.next();
                    Page page = new Page();
                    page.setTitle((entity.getTitle().toString()));
                    page.setDescription(entity.getDescription().toString());
//                System.out.println(page.getDescription());
                    page.setLink(entity.getLink().toString());
                    page.setPublish_date(new java.sql.Date(entity.getPublishedDate().getTime()));
//                System.out.println(page.getPublish_date());
                    page.setIs_read(0);
                    page.setIs_favourite(0);
//                page.setContent(entity.getContents().toString());
                    page.setFeed_id(controller.find_feed_id(feedUrl));
                    controller.page_insert(page);
                }

            }

        } catch (MalformedURLException ex) {
//            ex.printStackTrace();
        } catch (IOException ex) {
//            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
//            ex.printStackTrace();
        } catch (FeedException ex) {
//            ex.printStackTrace();
        }
    }

    public static boolean validate_feed(String feedUrl) {
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
