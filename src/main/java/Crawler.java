import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Crawler {
    HashSet<String> sitesVisited;

    public Crawler() {
        this.sitesVisited = new HashSet<>();
    }

    public void addSite(String site) {
        this.sitesVisited.add(site);
    }

    public boolean hasVisited (String url) {
        return sitesVisited.contains(url);
    }


}

