class Solution {

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int node=0; node<isConnected.length; node++)
            count += DFS(isConnected, visited, node);
        return count;
    }

    private int DFS(int[][] isConnected, boolean[] visited, int src) {
        if(visited[src])
            return 0;
        visited[src] = true;
        for(int neighbor=0; neighbor<isConnected[src].length; neighbor++)
            if(isConnected[src][neighbor]==1 && !visited[neighbor])
                DFS(isConnected, visited, neighbor);
        return 1;
    }

}