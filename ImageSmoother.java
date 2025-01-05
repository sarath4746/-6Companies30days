class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = img[i][j];
                int cnt = 1;

                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        
                        int ni = i + di;
                        int nj = j + dj;

                        if (di == 0 && dj == 0) continue ;

                        if (ni >= 0 && ni < m && nj >= 0 && nj < n) { //make sure ni and nj withing the bounds of m & n .
                            sum += img[ni][nj];
                            cnt++;
                        }
                    }
                }
                
                res[i][j] = sum / cnt;
            }
        }

        return res;
    }
}
