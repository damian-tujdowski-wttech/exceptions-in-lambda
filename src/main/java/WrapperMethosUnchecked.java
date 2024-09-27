import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// Handling unchecked exceptions, in this example NullPointerException
public class WrapperMethosUnchecked {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("roman", "marta", "krzysztof", null);

        names.stream()
                .map(name -> getString(name))
                .forEach(System.out::println);

        names.stream()
                .map(toUppercaseName())
                .forEach(System.out::println);
    }

    // Method provides implementation of Function.apply() method
    private static String getString(String name) {
        try {
            return name.toLowerCase();
        } catch (NullPointerException npe){
            System.out.println("Name seems to be null. Mapping null to surprise");
        }
        return "surprise";
    }

    // Method returns Function with apply() method implementation
    static Function<String, String> toUppercaseName() {
        return name -> {
            try {
                return name.toUpperCase();
            } catch (NullPointerException e) {
                System.out.println("Name seems to be null. Mapping null to surprise");
            }
            return "surprise";
        };
    }
}
