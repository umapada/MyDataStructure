package DROP_BOX;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given a url startUrl and an interface HtmlParser, implement a Multi-threaded web crawler to crawl all links that are under the same hostname as startUrl.

Return all urls obtained by your web crawler in any order.

Your crawler should:

Start from the page: startUrl
Call HtmlParser.getUrls(url) to get all urls from a webpage of given url.
Do not crawl the same link twice.
Explore only the links that are under the same hostname as startUrl.
 */
  class HtmlParser {
      public List<String> getUrls(String url) { return null;};
  }

public class WebCrawlerMultithreaded {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);

        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);

        return crawl(startUrl, htmlParser, hostname, visited)
                .collect(Collectors.toList());
    }

    private Stream<String> crawl(String startUrl, HtmlParser htmlParser, String hostname, Set<String> visited) {
        Stream<String> stream = htmlParser.getUrls(startUrl)
                .parallelStream()
                .filter(url -> isSameHostname(url, hostname))
                .filter(url -> visited.add(url))
                .flatMap(url -> crawl(url, htmlParser, hostname, visited));

        return Stream.concat(Stream.of(startUrl), stream);
    }

    private String getHostname(String url) {
        int idx = url.indexOf('/', 7);
        return (idx != -1) ? url.substring(0, idx) : url;
    }

    private boolean isSameHostname(String url, String hostname) {
        if (!url.startsWith(hostname)) {
            return false;
        }
        return url.length() == hostname.length() || url.charAt(hostname.length()) == '/';
    }
}
