import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[Integer.parseInt(st.nextToken())];
        for (int i = 0; i < list.length; ++i) {
            list[i] = i + 1;
        }
        
        int changeCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < changeCount; ++i) {
            st = new StringTokenizer(br.readLine());

            int number1 = Integer.parseInt(st.nextToken()) - 1;
            int number2 = Integer.parseInt(st.nextToken()) - 1;

            int temp = list[number1];
            list[number1] = list[number2];
            list[number2] = temp;
        }


        for (int i = 0; i < list.length; ++i) {
            System.out.print(list[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
