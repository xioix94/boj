import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[Integer.parseInt(st.nextToken())];
        int throwInCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < throwInCount; ++i) {
            st = new StringTokenizer(br.readLine());

            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            int ballNumber = Integer.parseInt(st.nextToken());

            for (int j = startIndex - 1; j < endIndex; ++j) {
                list[j] = ballNumber;
            }
        }


        for (int i = 0; i < list.length; ++i) {
            System.out.print(list[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
