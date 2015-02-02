import java.util.HashMap;
import java.util.Map;

/**
 * A representation of URL route mappings
 */
public class RouteSet {
    private Map<String, String> routeSet = new HashMap<String, String>();

    public String getUrlMapping(String friendlyUrl) {
        return routeSet.get(friendlyUrl);
    }

    /**
     * Adds a route to the routeSet
     * @param friendlyUrl A SEO friendly URL
     * @param actualUrl The actual URL to map towards
     */
    public void addUrlMapping(String friendlyUrl, String actualUrl) {
        routeSet.put(friendlyUrl, actualUrl);
    }

    public Map<String, String> getMappings() {
        return routeSet;
    }
}
