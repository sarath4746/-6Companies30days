class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int dist[][] = new int[n][n] ;

        for (int i = 0 ; i < n ; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE) ;
            dist[i][i] = 0 ;
        }

        for (int edge[] : edges) {
            dist[edge[0]][edge[1]] = edge[2] ;
            dist[edge[1]][edge[0]] = edge[2] ;
        }
        for (int k = 0 ; k < n ; k++) {
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int city_cnt = Integer.MAX_VALUE ;
        int city_no = -1 ;

        for (int city = 0 ; city < n ; city++) {
            int cnt = 0;
            for (int adj_city = 0 ; adj_city < n ; adj_city++) {
                if (dist[city][adj_city] <= distanceThreshold) cnt++ ;
            }

            if (cnt <= city_cnt) {
                city_cnt = cnt ;
                city_no = city ;
            }
        }

        return city_no ;
    }
}