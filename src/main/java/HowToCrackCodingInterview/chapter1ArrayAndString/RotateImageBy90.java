package HowToCrackCodingInterview.chapter1ArrayAndString;
//Given an image represented by an NxN matrix, where each pixel in the image is 4
//bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

public class RotateImageBy90 {

    public static int[][] rotateImage(int[][] image, int N){
        int rotationCycle = N%2 == 0 ? N/2:N/2+1;
        for(int i = 0; i < N/2; i++)
        {
            for(int j = 0; j<rotationCycle; j++)
            {
                int temp = image[i][j];
                image[i][j] = image[N-1-j][i];
                image[N-1-j][i] = image[N-1-i][N-1-j];
                image[N-1-i][N-1-j] = image[j][N-1-i];
                image[j][N-1-i] = temp;
            }
        }
        return image;
    }

    public static void print(int[][] data, int N){
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<N; j++)
            {
                System.out.print(data[i][j]+"\t");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] a){
        int[][] data = new int[][]{
                {   8,  8,  8,  9,  9,  9,  9},
                {   8,  8,  1,  1,  1,  9,  9},
                {   8,  1,  8,  1,  9,  1,  9},
                {   5,  1,  1,  0,  1,  1,  0},
                {   5,  1,  6,  1,  0,  1,  0},
                {   5,  6,  1,  1,  1,  0,  0},
                {   6,  4,  4,  0,  0,  0,  0}
        };
        print(data, 7);
        System.out.println();
        System.out.println();
        System.out.println("After rotation : ");
        System.out.println();
        System.out.println();

        rotateImage(data, 7);
        print(data, 7);
    }
}
