import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number1 = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());
        int number3 = Integer.parseInt(st.nextToken());

        if (number1 == number2 && number2 == number3) {
            System.out.println(10000 + number1 * 1000);
        } else if (number1 == number2 && number2 != number3 || number1 == number3 && number3 != number2) {
            System.out.println(1000 + number1 * 100);
        } else if (number1 != number2 && number2 == number3) {
            System.out.println(1000 + number2 * 100);
        } else {
            int max = number1;
            if (max < number2) {
                max = number2;
            }

            if (max < number3) {
                max = number3;
            }

            System.out.println(max * 100);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
