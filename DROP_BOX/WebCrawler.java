package DROP_BOX;

/*
Given a url startUrl and an interface HtmlParser, implement a web crawler to crawl all links that are under the same hostname as startUrl.

Return all urls obtained by your web crawler in any order.

Your crawler should:

Start from the page: startUrl
Call HtmlParser.getUrls(url) to get all urls from a webpage of given url.
Do not crawl the same link twice.
Explore only the links that are under the same hostname as startUrl.
 */

import java.util.*;

public class WebCrawler {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String hostname = getHostname(startUrl);

        queue.offer(startUrl);
        set.add(startUrl);

        while (!queue.isEmpty()) {
            String currentUrl = queue.poll();
            for (String url : htmlParser.getUrls(currentUrl)) {
                if (url.contains(hostname) && !set.contains(url)) {
                    queue.offer(url);
                    set.add(url);
                }
            }
        }

        return new ArrayList<String>(set);
    }

    private String getHostname(String Url) {
        String[] ss = Url.split("/");
        return ss[2];
    }
}
