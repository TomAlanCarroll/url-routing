import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The cluster of backend locations;
 */
public class Cluster {
    private List<Location> locations = new ArrayList<Location>();

    /**
     * Adds a location
     * @param location A non-null location
     */
    public void add(Location location) {
        locations.add(location);
    }

    /**
     * Adds a route to the cluster and adds a postfix if necessary
     * @param friendlyUrl A SEO friendly URL
     * @param actualUrl The actual URL to map towards
     * @return The processed SEO friendly URL. This have a postfix if there is a URL collision
     */
    public String addRoute(String friendlyUrl, String actualUrl) {
        String processedFriendlyUrl = friendlyUrl;
        int collisionPostfix = 2;

        while (!urlIsAcceptable(processedFriendlyUrl)) {
            processedFriendlyUrl = friendlyUrl + "-" + collisionPostfix;
            collisionPostfix++;
        }

        getAnyLocation().addRoute(processedFriendlyUrl, actualUrl);

        return processedFriendlyUrl;
    }

    /**
     * Tests if a given URL is acceptable in the cluster
     * @param friendlyUrl The SEO friendly URL
     * @return {@code true} if friendlyUrl doesn't already exist in the cluster; {@code false} otherwise
     */
    public boolean urlIsAcceptable (String friendlyUrl) {
        for (Location location : locations) {
            if (location.hasUrl(friendlyUrl)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Gets a random location in the cluster; Load-balancing could be added here in the future
     * @return A random location
     */
    public Location getAnyLocation() {
        int index = ThreadLocalRandom.current().nextInt(locations.size());
        return locations.get(index);
    }
}
