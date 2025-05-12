class Solution {

    public int findCircleNum(int[][] isConnected) {
        Map<Integer, Set<Integer>> graph = constructGraph(isConnected);
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int node: graph.keySet()) {
            count += DFS(graph, visited, node);
        }
        return count;
    }

    private Map<Integer, Set<Integer>> constructGraph(int[][] isConnected) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int size = isConnected.length;
        for(int row = 0; row < size; row++) {    
            for(int col = 0; col < size; col++) {
                if(!graph.containsKey(row))
                    graph.put(row, new HashSet<>());
                if(!graph.containsKey(col))
                    graph.put(col, new HashSet<>());
                if(isConnected[row][col] == 1) {
                    graph.get(row).add(col);
                    graph.get(col).add(row);
                }
            }
        }
        return graph;
    }

    private int DFS(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int node) {
        if(visited.contains(node))
            return 0;
        visited.add(node);
        for(int neighbor: graph.get(node))
            DFS(graph, visited, neighbor);
        return 1;
    }

}