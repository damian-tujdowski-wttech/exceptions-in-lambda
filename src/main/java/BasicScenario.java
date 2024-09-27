import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

// Handling exception in lambda expression body and basic improvement - moving handling to a method
public class BasicScenario {
    public static void main(String[] args) throws MalformedURLException {
        List<String> urls = Arrays.asList("https://wp.pl", "https://onet.pl");

//        List<URL> URLS = urls.stream()
//                .map(url -> new URL(url))
//                .collect(Collectors.toList());

// Exception handled in lambda expression body
        urls.stream()
                .map(spec -> {
                    try {
                        return new URL(spec);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .forEach(url -> System.out.println(url.getHost()));

//expression handling moved to a method
        urls.stream()
                .map(BasicScenario::getUrl)
                .forEach(url -> System.out.println(url.getHost()));
    }

    private static URL getUrl(String spec) {
        try {
            return new URL(spec);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}