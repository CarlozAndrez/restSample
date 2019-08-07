import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Carlos", "Armando", "Rodrigo", "Sara", "Christian", "Camilo", "castaño", "casas");


        List<String> namesStartedWithC =  names.stream()
                .map(x -> x.toUpperCase())
                .filter(x -> x.charAt(0) == 'C')
                .sorted()
                .collect(Collectors.toList());

        System.out.println("List: "+namesStartedWithC.toString());
        //_Using Streams and Lambdas print the names that start with the letter c

    }

}


