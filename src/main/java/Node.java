import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class Node {
    public ArrayList<Node> children;
    public String siteUrl;


    public Node (String siteUrl, Crawler crawler) {
        this.siteUrl = siteUrl;
        this.children = new ArrayList<>();

        try {
            // get the contents of the site:
            Document doc = Jsoup.connect(siteUrl).get();

            // getting all tags with href on them (links):
            Elements links = doc.select("a[href]");

            // creating nodes with those links
            for (Element link : links) {
                String href = link.attr("abs:href");

                // skipping if link is empty or already visited:
                if (href.isEmpty() || crawler.hasVisited(href)) continue;

                System.out.println("Found link: " + href);
                crawler.addSite(href);
                this.addChildren(href, crawler);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void addChildren (String siteUrl, Crawler crawler) {
        children.add(new Node(siteUrl, crawler));
        crawler.addSite(siteUrl);
    }
}
