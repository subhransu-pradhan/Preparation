package HowToCrackCodingInterview.chapter1ArrayAndString;
/*Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column is set to 0.*/
public class ReplicateZeroInNXM {

    public static void setZero(int[][] array, int N, int M, boolean[] row, boolean[] column){
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<M; j++){
                if (row[i] || column[j]){
                    array[i][j] = 0;
                }
            }
        }
    }

    public static void getZero(int[][] array, int N, int M, boolean[] row, boolean[] column){
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<M; j++){
                if (array[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
    }

    public static void print(int[][] data, int N, int M){
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<M; j++)
            {
                System.out.print(data[i][j]+"\t");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String args[]){
        int N = 6;
        int M = 7;
        int[][] data = new int[][]{
                {   8,  8,  8,  9,  9,  9,  9},
                {   8,  8,  1,  1,  1,  9,  9},
                {   8,  1,  8,  1,  9,  1,  9},
                {   5,  1,  1,  0,  1,  1,  0},
                {   5,  1,  6,  1,  0,  1,  0},
                {   5,  6,  1,  1,  1,  0,  0}
        };
        boolean[] row = new boolean[N];
        boolean[] column = new boolean[M];
        getZero(data, N,M,row,column);
        print(data, N, M);
        System.out.println();
        System.out.println();
        setZero(data, N,M,row,column);
        print(data, N, M);

    }
}
