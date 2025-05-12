class Solution {

    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int node=0; node<isConnected.length; node++) {
            count += DFS(isConnected, visited, node);
        }
        return count;
    }

    private int DFS(int[][] isConnected, Set<Integer> visited, int src) {
        if(visited.contains(src))
            return 0;
        visited.add(src);
        for(int neighbor=0; neighbor<isConnected[src].length; neighbor++)
            if(isConnected[src][neighbor]==1 && !visited.contains(neighbor))
                DFS(isConnected, visited, neighbor);
        return 1;
    }

}