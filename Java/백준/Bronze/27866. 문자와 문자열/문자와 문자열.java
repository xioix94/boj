import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 첫번째 input 뽑아서 저장
        // 두번째 인풋 뽑아서 -1 후 인덱스에 해당하는 값 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        System.out.println(word.charAt(Integer.parseInt(br.readLine()) - 1));

    }
}
