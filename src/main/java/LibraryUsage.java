import com.machinezoo.noexception.Exceptions;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

// Handling checked exceptions with external library
public class LibraryUsage {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://wp.pl", "https://onet.pl");

        urls.stream()
                .map(url -> Exceptions.wrap().get(() -> new URL(url)))
                .forEach(url -> System.out.println(url.getHost()));
    }
}
