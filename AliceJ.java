import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AliceJ {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("Alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\s+"));
        Stream<String> wordsStream = words.stream();
        Stream<String> longWords = wordsStream.filter(w -> w.length() > 12);

//         обычный
        long start = System.nanoTime();
        int count = 0;
        for (String w : words) {
            if (w.length() > 12) {
                count++;
//                System.out.println(w);
            }
        }
        long stop = System.nanoTime();
        System.out.println(count);
        System.out.println("Time diff = " + (stop - start));

//        фунциональный
        long start8 = System.nanoTime();
        long count8 = words.stream().filter(w -> w.length() > 12).count();
        long stop8 = System.nanoTime();
        System.out.println("Time diff = " + (stop8 - start8));

//        функциональный с распараллеливанием
        long start8p = System.nanoTime();
        long count8p = words.parallelStream().filter(w -> w.length() > 12).count();
        long stop8p = System.nanoTime();
        System.out.println("Time diff = " + (stop8p - start8p));

    }
}
