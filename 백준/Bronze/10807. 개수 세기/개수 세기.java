import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfInt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetNumber = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < numberOfInt; ++i) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == targetNumber) {
                ++count;
            }
        }


        System.out.print(count);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
