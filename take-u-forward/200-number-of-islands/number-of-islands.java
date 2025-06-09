class Solution {

    private final char water = '0';

    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {

        Set<Integer> visited = new HashSet<>();

        rows = grid.length;
        cols = grid[0].length;

        int islands = 0;

        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                islands += dfs(grid, row, col, visited);
            }
        }

        return islands;
    }

    private int dfs(char[][] grid, int row, int col, Set<Integer> visited) {

        int currentNode = row*cols + col;
        boolean inBound = 0 <= row && row < rows && 0 <= col && col < cols;
        if(!inBound || water == grid[row][col] || visited.contains(currentNode)) {
            return 0;
        }
        visited.add(currentNode);

        dfs(grid, row-1, col, visited);
        dfs(grid, row+1, col, visited);
        dfs(grid, row, col-1, visited);
        dfs(grid, row, col+1, visited);
        
        return 1;
    }

}