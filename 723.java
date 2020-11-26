class CandyCrush {

    public static void main(String[] args){
        int[][] board =  new int[][]{{1,3,5,5,2},{3,4,3,3,1},{3,2,4,5,2},{2,4,4,5,5},{1,4,4,1,1}};
        board = candyCrush(board);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] candyCrush(int[][] board) {

        //loop until there are no more consecutive candies
        while(true){

            //get the board dimensions
            int rows = board.length;
            int cols = board[0].length;
            boolean crushFound = false;

            //first loop through and mark all of the consecutive candies as negative
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    int currVal = Math.abs(board[i][j]);
                    if(currVal == 0) continue;
                    if(j < cols-2 && Math.abs(board[i][j+1]) == currVal && Math.abs(board[i][j+2]) == currVal){
                        crushFound = true;
                        int iter = j;
                        while(iter < cols && Math.abs(board[i][iter]) == currVal){
                            board[i][iter] = -1 * Math.abs(board[i][iter]);
                            iter++;
                        }
                    }
                    if(i < rows-2 && Math.abs(board[i+1][j]) == currVal && Math.abs(board[i+1][j]) == currVal){
                        crushFound = true;
                        int iter = i;
                        while(iter < rows && Math.abs(board[iter][j]) == currVal){
                            board[iter][j] = -1 * Math.abs(board[iter][j]);
                            iter++;
                        }
                    }
                }
            }

            //then go through and crush all of the negative values
            if(crushFound){
                for(int i = 0; i < cols; i++){
                    int bottom = rows-1;
                    while(bottom > -1){
                        if(board[bottom][i] < 0){
                            //push the column down
                            for(int j = bottom-1; j > -1; j--){
                                board[j+1][i] = board[j][i];
                            }
                            board[0][i] = 0;
                        }else{
                            bottom--;
                        }
                    }
                }
            } else{
                return board;
            }
        }
        
    }

}