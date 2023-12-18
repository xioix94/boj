import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("\\    /\\").append("\n");
        sb.append(" )  ( ')").append("\n");
        sb.append("(  /  )").append("\n");
        sb.append(" \\(__)|");

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}