import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Crawler {
    private final HashMap<String, URLDepthPair> links = new HashMap<>();
    private final LinkedList<URLDepthPair> pool = new LinkedList<>();

    private int depth = 0;

    public Crawler(String url, int dep) {
        depth = dep;
        pool.add(new URLDepthPair(url, 0));
    }

    public void run() {
        while (pool.size() > 0)
            parseLink(pool.pop());
        for (URLDepthPair link : links.values())
            System.out.println(link);

        System.out.println();
        System.out.printf("Found %d URLS\n", links.size());
    }

    public static Pattern LINK_REGEX = Pattern.compile(
            "<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1");

    private void parseLink(URLDepthPair link) {
        if (links.containsKey(link.getURL())) {
            return;
        }
        links.put(link.getURL(), link);
        if (link.getDepth() >= depth)
            return;

        try {
            URL url = new URL(link.getURL());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            Scanner s = new Scanner(con.getInputStream());
            while (s.findWithinHorizon(LINK_REGEX, 0) != null) {
                String newURL = s.match().group(2);
                if (newURL.startsWith("/"))
                    newURL = link.getURL() + newURL;
                else if (!newURL.startsWith("http"))
                    continue;
                URLDepthPair newLink = new URLDepthPair(newURL, link.getDepth() + 1);
                pool.add(newLink);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showHelp() {
        System.out.println("usage: java Crawler <URL> <depth>");
        System.exit(1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter URL: ");
        String url = scan.nextLine();

        System.out.println("Enter depth: ");
        int depth = 0;
        try {
            depth = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            showHelp();
        }

        Crawler crawler = new Crawler(url, depth);
        crawler.run();
    }
}