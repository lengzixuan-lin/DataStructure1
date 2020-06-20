/**
 * 需求：棋盘游戏进行存档和读档
 * 解决方案：利用稀疏数组对棋盘游戏进行存档和读档
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建棋盘二维数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 2;
        for(int[] row : chessArr1){
            for(int item : row){
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        //读取棋盘真值得个数
        int sum = 0;
        for(int i = 0; i < 11;i++){
            for(int j = 0;j < 11;j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        //利用真值数来定义稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //将棋盘的真值保存到稀疏数组
        int count = 0;
        for(int i = 0;i < 11;i++){
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }

            }
        }

        for(int [] row : sparseArr){
            for(int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        System.out.println();
        //解析稀疏数组
        int [][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1;i <= sparseArr[0][2];i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("解析稀疏数组：");
        for(int [] row : chessArr2){
            for(int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }


}
