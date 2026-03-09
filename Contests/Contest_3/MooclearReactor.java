
import java.io.*;
import java.util.*;

public class MooclearReactor {

    static int[] cntTree, sumTree;
    static int[] sortedX;
    static int R;

    static void update(int pos, int dc, int ds) {
        for (int i = pos; i <= R; i += i & -i) {
            cntTree[i] += dc;
            sumTree[i] += ds;
        }
    }

    static int queryCnt(int pos) {
        int c = 0;
        for (int i = pos; i > 0; i -= i & -i) {
            c += cntTree[i];
        }
        return c;
    }

    static long querySum(int pos) {
        long s = 0;
        for (int i = pos; i > 0; i -= i & -i) {
            s += sumTree[i];
        }
        return s;
    }

    static final long NEG_INF = Long.MIN_VALUE / 2;

    static long topKSum(int k) {
        if (k <= 0) {
            return 0L;
        }
        int totalC = queryCnt(R);
        if (totalC < k) {
            return NEG_INF;
        }
        long totalS = querySum(R);
        int target = totalC - k;
        int pos = 0;
        for (int bit = Integer.highestOneBit(R); bit > 0; bit >>= 1) {
            if (pos + bit <= R && cntTree[pos + bit] <= target) {
                pos += bit;
                target -= cntTree[pos];
            }
        }
        int cntAbove = totalC - queryCnt(pos);
        long sumAbove = totalS - querySum(pos);
        if (cntAbove == k) {
            return sumAbove;
        }
        int cntAtBoundary = queryCnt(pos + 1) - queryCnt(pos);
        long sumAtBoundary = querySum(pos + 1) - querySum(pos);
        long valAtBoundary = sortedX[pos];
        int cntFromHigher = cntAbove - cntAtBoundary;
        int needed = k - cntFromHigher;
        return sumAbove - sumAtBoundary + (long) needed * valAtBoundary;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] px = new int[n], py = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                px[i] = Integer.parseInt(st.nextToken());
                py[i] = Integer.parseInt(st.nextToken());
            }

            int[] sx = new int[m], sy = new int[m];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                sx[i] = Integer.parseInt(st.nextToken());
                sy[i] = Integer.parseInt(st.nextToken());
            }

            int[] tmp = Arrays.copyOf(px, n);
            Arrays.sort(tmp);
            int unique = 0;
            for (int v : tmp) {
                if (unique == 0 || tmp[unique - 1] != v) {
                    tmp[unique++] = v;
                }
            }
            sortedX = Arrays.copyOf(tmp, unique);
            R = unique;

            cntTree = new int[R + 2];
            sumTree = new int[R + 2];

            Integer[] idx = new Integer[n];
            for (int i = 0; i < n; i++) {
                idx[i] = i;
            }
            Arrays.sort(idx, (a, b) -> py[a] - py[b]);

            for (int i = 0; i < n; i++) {
                int r = Arrays.binarySearch(sortedX, px[i]) + 1;
                update(r, 1, px[i]);
            }

            int ptr = 0;
            long[] g = new long[n + 2];
            Arrays.fill(g, NEG_INF);
            g[0] = 0;
            long baseAnswer = 0;

            for (int threshold = 0; threshold <= n; threshold++) {
                while (ptr < n && py[idx[ptr]] < threshold) {
                    int xi = px[idx[ptr]];
                    int r = Arrays.binarySearch(sortedX, xi) + 1;
                    update(r, -1, -xi);
                    ptr++;
                }

                g[threshold] = topKSum(threshold);

                long fk = topKSum(threshold + 1);
                if (fk != NEG_INF) {
                    baseAnswer = Math.max(baseAnswer, fk);
                }
            }

            long[] G = new long[n + 2];
            G[0] = 0;
            for (int j = 1; j <= n; j++) {
                G[j] = g[j] != NEG_INF ? Math.max(G[j - 1], g[j]) : G[j - 1];
            }

            for (int i = 0; i < m; i++) {
                long bestWith = (long) sx[i] + G[Math.min(sy[i], n)];
                long ans = Math.max(baseAnswer, bestWith);
                sb.append(ans);
                if (i < m - 1) {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
