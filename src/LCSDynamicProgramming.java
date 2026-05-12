public class LCSDynamicProgramming {
    public static void main(String[] args) {
        String str1 = "SAHRANRAJWANI";
        String str2 = "ETAOINSHR";
        int m = str1.length();
        int n = str2.length();
        int[][] lcs = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        int i = m;
        int j = n;
        String result = "";
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result = str1.charAt(i - 1) + result;
                i--;
                j--;
            } else if (lcs[i - 1][j] > lcs[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("string 1: " + str1);
        System.out.println("string 2: " + str2);
        System.out.println("Longest common subsequence: " + result);
        System.out.println("length of lcs: " + result.length());
    }
}