import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number1 = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());

        sb.append(number1 + number2).append('\n');
        sb.append(number1 - number2).append('\n');
        sb.append(number1 * number2).append('\n');
        sb.append(number1 / number2).append('\n');
        sb.append(number1 % number2);

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}