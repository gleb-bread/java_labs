public class URLDepthPair {
    private String url;
    private int depth;

    public URLDepthPair(String URL, int dep) {
        url = URL;
        depth = dep;
    }

    public String getURL() {
        return url;
    }

    public int getDepth() {
        return depth;
    }

    public String toString() {
        return "<URL href=\"" + url + "\" depth=\"" + depth + "\" \\>";
    }
}