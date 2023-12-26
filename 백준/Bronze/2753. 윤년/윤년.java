import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public long solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());

        if (number % 4 == 0) {
            if (number % 100 == 0) {
                if (number % 400 != 0) {
                    return 0;
                }

                return 1;
            }

            return 1;
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        long result = new Main().solution();
        System.out.println(result);
    }
}
