import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Main {
    public static final String URL_PREFIX = "this-is-a-seo-friendly-url-";
    public static final int NUMBER_OF_URLS = 2000000;

    public static void main(String[] args) {
        problemTwo();
        problemThree();
    }

    public static void problemTwo() {
        RouteSet routeSet = new RouteSet();

        // Setup the URL mappings
        for (int i = 1; i <= NUMBER_OF_URLS; i++) {
            routeSet.addUrlMapping(URL_PREFIX + i, "f" + String.valueOf(i));
        }

        Instant start = Instant.now();

        // Process 1000 URLs
        for (int i = 0; i < 1000; i++) {
            int randomUrlNumber = (int) (NUMBER_OF_URLS * Math.random());
            System.out.println(routeSet.getUrlMapping(URL_PREFIX + randomUrlNumber));
        }

        System.out.println("1000 URLs processed in " +
                ChronoUnit.MILLIS.between(start, Instant.now()) + "ms");
    }

    public static void problemThree() {
        Cluster cluster = new Cluster();

        // Add two locations to our cluster
        cluster.add(new Location());
        cluster.add(new Location());

        // Add some colliding URLs
        for (int i = 1; i <= 2; i++) {
            String actualUrl = "f" + i;
            String route = cluster.addRoute("this-will-be-a-collision", actualUrl);
            System.out.println("Added route '" + route + "' mapped to '" + actualUrl + "'");
        }
    }
}
