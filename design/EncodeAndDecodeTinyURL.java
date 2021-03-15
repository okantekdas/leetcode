package leetcode.design;

import java.util.HashMap;

/* https://leetcode.com/problems/encode-and-decode-tinyurl/ */
/* Runtime: 4 ms, faster than 71.55% Memory Usage: 39 MB, less than 82.65% */
public class EncodeAndDecodeTinyURL {
    public class Codec {

        HashMap<String, String> shortToLong = new HashMap<>();

        static final String TINY_URL_PREFIX = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {

            String shortUrl = TINY_URL_PREFIX + longUrl.hashCode();
            shortToLong.put(shortUrl, longUrl);

            return shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {

            return shortToLong.get(shortUrl);
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));
}
