import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 배열 역순으로 만드는 함수 작성
        // 2. N만큼 배열 생성
        // 3. M만큼 돌면서 배열 역순으로 변경

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(input[0]); ++i) {
            result.add(i + 1);
        }

        for (int i = 0; i < Integer.parseInt(input[1]); ++i) {
            String[] changeValues = br.readLine().split(" ");
            int start = Integer.parseInt(changeValues[0]);
            int end = Integer.parseInt(changeValues[1]);
            result = changePartlyReverse(start - 1, end - 1, result);
        }

        for (int i = 0; i < result.size(); ++i) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static ArrayList<Integer> changePartlyReverse(int start, int end, ArrayList<Integer> list) {
        if (start != end) {
            // 부분 배열 뽑아서 역순으로 생성
            // 인덱스 다시 돌면서 역순으로 생성한 배열의 요소 삽입
            ArrayList<Integer> reverse = new ArrayList<>();
            for (int j = start; j <= end; ++j) {
                reverse.add(list.get(j));
            }

            reverse = sortReverse(reverse);

            int num = 0;
            for (int j = start; j <= end; ++j) {
                list.set(j, reverse.get(num));
                ++num;
            }
        }

        return list;
    }

    public static ArrayList<Integer> sortReverse(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; ++i) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, temp);
        }

        return list;
    }
}
