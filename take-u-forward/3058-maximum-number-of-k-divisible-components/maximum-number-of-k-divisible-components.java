class Solution {

    public int result = 0;
    List<Integer>[] adjacencyList;
    public int[] values;
    public int k;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.values = values;
        this.k = k;
        adjacencyList = new ArrayList[n];
        
        for (int i = 0; i < n; i++)
            adjacencyList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }
        dfs(0, -1);
        return result;
    }

    public long dfs(int current, int parent) {
        long total = values[current];
        for(int child: adjacencyList[current])
            if(child != parent) 
                total += dfs(child, current);
        if(total%k == 0)
            result += 1;
        return total;
    }

}