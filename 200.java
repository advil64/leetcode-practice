import java.util.*;

class Islands {
    //this uses dfs to count number of islands, there is at least one
    //the DFS continues until a connected land mass is completely explored
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        //convert this land into water to avoid seeing this as an island
        grid[i][j] = '0';
        //we have hit more land, explore around it to see if it connects to more land
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}

class IslandsBFS {
    public int numIslands(char[][] grid) {
        int count = 0;
        Stack<int[]> myStack = new Stack<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    myStack.push(new int[]{i, j});
                    while(!myStack.isEmpty()){
                        int[] temp = myStack.pop();
                        if(temp[0] < 0 || temp[1] < 0 || temp[0] >= grid.length || temp[1] >= grid[0].length || grid[temp[0]][temp[1]] != '1'){
                            continue;
                        } else{
                            grid[temp[0]][temp[1]] = '0';
                            myStack.push(new int[]{temp[0]+1, temp[1]});
                            myStack.push(new int[]{temp[0]-1, temp[1]});
                            myStack.push(new int[]{temp[0], temp[1]+1});
                            myStack.push(new int[]{temp[0], temp[1]-1});
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}