import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = IntStream.range(1, 31).boxed().collect(Collectors.toCollection(ArrayList::new));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }

            int num = Integer.parseInt(input);
            arrayList.remove(Integer.valueOf(num));
        }

        arrayList
                .forEach(System.out::println);
    }
}
