import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double number1 = Double.parseDouble(st.nextToken());
        double number2 = Double.parseDouble(st.nextToken());

        System.out.println(number1 / number2);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
