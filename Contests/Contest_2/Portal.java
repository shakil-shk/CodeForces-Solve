
import java.io.*;
import java.util.*;

public class Portal {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] p = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }

            int[] result = solve(p, n, x, y);

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    sb.append(' ');
                }
                sb.append(result[i]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static int[] solve(int[] p, int n, int x, int y) {
        int leftLen = x;
        int midLen = y - x;
        int rightLen = n - y;
        int combLen = leftLen + rightLen;

        int[] combined = new int[combLen];
        for (int i = 0; i < leftLen; i++) {
            combined[i] = p[i];
        }
        for (int i = 0; i < rightLen; i++) {
            combined[leftLen + i] = p[y + i];
        }

        if (midLen == 0) {
            return p.clone();
        }

        int minMid = Integer.MAX_VALUE, rotStart = 0;
        for (int i = x; i < y; i++) {
            if (p[i] < minMid) {
                minMid = p[i];
                rotStart = i - x;
            }
        }

        int[] midRot = new int[midLen];
        for (int i = 0; i < midLen; i++) {
            midRot[i] = p[x + (rotStart + i) % midLen];
        }

        int split = combLen;
        for (int i = 0; i < combLen; i++) {
            if (combined[i] > midRot[0]) {
                split = i;
                break;
            }
        }

        int[] result = new int[n];
        int idx = 0;
        for (int i = 0; i < split; i++) {
            result[idx++] = combined[i];
        }
        for (int i = 0; i < midLen; i++) {
            result[idx++] = midRot[i];
        }
        for (int i = split; i < combLen; i++) {
            result[idx++] = combined[i];
        }
        return result;
    }
}
