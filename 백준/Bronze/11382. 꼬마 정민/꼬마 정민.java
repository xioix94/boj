import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long number1 = Long.parseLong(st.nextToken());
        long number2 = Long.parseLong(st.nextToken());
        long number3 = Long.parseLong(st.nextToken());

        System.out.print(number1 + number2 + number3);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
