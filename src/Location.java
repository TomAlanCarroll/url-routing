/**
 * A representation of a server backend
 */
public class Location {
    private RouteSet routeSet = new RouteSet();

    /**
     * Tests if a given URL is set at this location
     * @param friendlyUrl The SEO friendly URL
     * @return {@code true} if friendlyUrl doesn't already exist in the cluster; {@code false} otherwise
     */
    public boolean hasUrl (String friendlyUrl) {
        if (routeSet.getMappings().containsKey(friendlyUrl)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a route to this location's routeSet
     * @param friendlyUrl A SEO friendly URL
     * @param actualUrl The actual URL to map towards
     */
    public void addRoute(String friendlyUrl, String actualUrl) {
        this.routeSet.addUrlMapping(friendlyUrl, actualUrl);
    }
}
