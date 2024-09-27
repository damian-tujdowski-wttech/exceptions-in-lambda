import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// Handling checked exceptions, in this example MalformedURLException with use of:
// - custom functional interface
// - custom method using generics
public class WrapperMethod {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://wp.pl", "https://onet.pl");

        urls.stream()
                .map(throwingFunctionWrapper(url -> new URL(url)))
                .forEach(url -> System.out.println(url.getHost()));
    }

    static <T, R> Function<T, R> throwingFunctionWrapper(ThrowingFunction<T, R, MalformedURLException> throwingFunction) {
        return url -> {
            try {
                return throwingFunction.apply(url);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        };
    }

}
