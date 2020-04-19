class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length ==  0 || grid  == null) return 0;
        boolean[][] found = new boolean[grid.length][grid[0].length];
        int noislands = 0;
        for(int  i = 0; i<grid.length;i++){
            for(int j = 0; j < grid[i].length;j++){
                if(grid[i][j] == '1' && !found[i][j]){
                    noislands += foundEarth(grid, found, i, j);
                }
            }
        }
        printArray(found);
        
        return noislands; 
    }
    
    public int foundEarth(char[][] grid, boolean[][] found, int row, int col){
        if(row > grid.length - 1 ||
           row < 0 ||
           col > grid[row].length -1 ||
           col < 0 ||
           grid[row][col] == '0'  || 
           found[row][col] == true){
            return 0;
        }
        found[row][col] = true;
        foundEarth(grid, found, row+1, col);
        foundEarth(grid, found, row-1, col);

        foundEarth(grid, found, row, col+1);
        foundEarth(grid, found, row, col-1);

        return 1;
    }
    
    public void printArray(boolean[][] array){
        for (boolean[] arr : array){
            System.out.println(Arrays.toString(arr));
        }
    }
}