import java.io.*;
import java.util.*;

public class SecretFinder {

    public static void main(String[] args) throws Exception {
        int[] k1 = new int[1];
        int[] k2 = new int[1];


        List<long[]> points1 = readJson("testcase1.json", k1);
        List<long[]> points2 = readJson("testcase2.json", k2);

        long secret1 = findConstant(points1, k1[0]);
        long secret2 = findConstant(points2, k2[0]);

        System.out.println("Secret from TestCase 1: " + secret1);
        System.out.println("Secret from TestCase 2: " + secret2);
    }

    public static List<long[]> readJson(String fileName, int[] kHolder) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        List<long[]> points = new ArrayList<>();
        int k = 0;

        while ((line = br.readLine()) != null) {
            line = line.trim();

            if (line.startsWith("\"k\"")) {
                String[] parts = line.split(":");
                k = Integer.parseInt(parts[1].replace(",", "").trim());
                kHolder[0] = k;
            }

            if (line.matches("\"\\d+\"\\s*:\\s*\\{")) {
                int x = Integer.parseInt(line.split("\"")[1]);

                String baseLine = br.readLine().trim();
                String valueLine = br.readLine().trim();

                int base = Integer.parseInt(baseLine.split(":")[1].replace(",", "").replace("\"", "").trim());
                String value = valueLine.split(":")[1].replace(",", "").replace("\"", "").trim();

                long y = convertBase(value, base);
                points.add(new long[]{x, y});

                if (points.size() == k) {
                    break;
                }
            }
        }
        br.close();
        return points;
    }

    public static long convertBase(String val, int base) {
        long res = 0;
        for (int i = 0; i < val.length(); i++) {
            char ch = val.charAt(i);
            int digit;
            if (ch >= '0' && ch <= '9') {
                digit = ch - '0';
            } else {
                digit = (ch - 'a') + 10;
            }
            res = res * base + digit;
        }
        return res;
    }

    public static long findConstant(List<long[]> points, int k) {
        double sum = 0.0;

        for (int j = 0; j < k; j++) {
            double term = points.get(j)[1];
            for (int i = 0; i < k; i++) {
                if (i != j) {
                    double xi = points.get(i)[0];
                    double xj = points.get(j)[0];
                    term *= (0.0 - xi) / (xj - xi);
                }
            }
            sum += term;
        }

        return Math.round(sum);
    }
}
