import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int hour = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());

        minutes += time;
        int hours = minutes / 60;
        int restMinutes = minutes % 60;

        if (hours > 0) {
            hour = hour + hours > 23 ? hour + hours - 24 : hour + hours;
            sb.append(hour).append(" ").append(restMinutes);
        } else {
            sb.append(hour).append(" ").append(restMinutes);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
