class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            // validate board[i][0]                
            Set<Integer> numj = new HashSet<>();
            for(int j=0;j<9;j++){                
                if(Character.isDigit(board[i][j])){
                    Integer num = board[i][j] - '0';
                    if(numj.contains(num))
                        return false;
                    else 
                        numj.add(num);
                }
            }   
        }
        for(int j=0;j<9;j++){
            // validate board[0][j]
            Set<Integer> numj = new HashSet<>();
            for(int i=0;i<9;i++){                
                if(Character.isDigit(board[i][j])){
                    Integer num = board[i][j] - '0';
                    if(numj.contains(num))
                        return false;
                    else 
                        numj.add(num);
                }
            }   
        }
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                // validate box[0][0]
                Set<Integer> box = new HashSet<>();
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        if(Character.isDigit(board[i+k][j+l])){
                            Integer num = board[i+k][j+l] - '0';
                            if(box.contains(num))
                                return false;
                            else 
                                box.add(num);
                        }
                    }
                }
            }   
        }
        return true;
    }
}