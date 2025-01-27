class Solution {
    List<Integer>[] graph, subGraph;
    int subGraphRoot, longestPath;
    boolean[] inStack; 
    int[] result;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        createGraph(n, edges);
        result = new int[n - 1];
        dfs(0);
        return result;
    }

    private void createGraph(int n, int[][] edges) {
        graph = new List[n];
        subGraph = new List[n];
        inStack = new boolean[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
            subGraph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
            graph[e[1] - 1].add(e[0] - 1);
        }
    }

    private void dfs(int node) {
        subGraphRoot = node;
        inStack[node] = true;
        buildSubGraph(0, 0, Collections.singletonList(node), new ArrayList<>());
        for (int neighbor : graph[node]) {
            if (inStack[neighbor]) {
                continue;
            } 
            dfs(neighbor);
        }
    }

    private void buildSubGraph(int index, int j, List<Integer> frontier, List<Integer> next) {
        if (index >= frontier.size()) {
            buildNextLevel(next);
            return;
        }
        int current = frontier.get(index);
        if (j >= graph[current].size()) {
            buildSubGraph(index + 1, 0, frontier, next);
        } else {
            int successor = graph[current].get(j);
            if (inStack[successor]) {
                buildSubGraph(index, j + 1, frontier, next);
                return;
            }
            inStack[successor] = true;
            next.add(successor);
            subGraph[current].add(successor);
            buildSubGraph(index, j + 1, frontier, next);
            next.remove(next.size() - 1);
            subGraph[current].remove(subGraph[current].size() - 1);
            buildSubGraph(index, j + 1, frontier, next);
            inStack[successor] = false;
        }
    }

    private void buildNextLevel(List<Integer> next) {
        if (next.isEmpty()) { 
            longestPath = 0;
            calculateLongestPath(subGraphRoot);
            if (longestPath > 1) {
                ++result[longestPath - 2];
            }
        } else {
            buildSubGraph(0, 0, next, new ArrayList<>());
        }
    }

    private int calculateLongestPath(int node) {
        int max = 0, secondMax = 0;
        for (int child : subGraph[node]) {
            int height = calculateLongestPath(child);
            if (height >= max) {
                secondMax = max;
                max = height;
            } else {
                secondMax = Math.max(secondMax, height);
            }
        }
        longestPath = Math.max(longestPath, secondMax + max + 1);
        return max + 1;
    }
}