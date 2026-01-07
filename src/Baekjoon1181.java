import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1181 {
    public static void main(String[] args) throws IOException {
        // 입출력 속도를 늘리기 위한 BuffereReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력받을 단어 수
        String [] words =  new String [n];

        for (int i = 0; i < n; i++) { // 단어 입력
            String s = br.readLine();
            words[i] = s;
        }

        Arrays.sort(words, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2); // s1과 s2의 각 char을 빼서 음수면 그대로 양수면 swap
            }
            return s1.length() - s2.length(); // s1길이와 s2 길이를 빼서 음수면 그대로, 양수면 s1과 s2 위치 swap
        });

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]).append("\n");

        for (int i = 1; i < n; i++) {
            if (!words[i].equals(words[i - 1])) {
                sb.append(words[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
