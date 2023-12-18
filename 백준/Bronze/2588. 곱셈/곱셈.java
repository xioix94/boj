import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number1 = Integer.parseInt(br.readLine());
        int number2 = Integer.parseInt(br.readLine());

        int hundred = number2 / 100;
        int ten = (number2 % 100) / 10;
        int one = ((number2 % 100) % 10) / 1;

        sb.append(number1 * one).append('\n');
        sb.append(number1 * ten).append('\n');
        sb.append(number1 * hundred).append('\n');
        sb.append(number1 * number2);

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}