import java.util.Scanner;

public class MultiplicationOfTwoMatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] m1 = new int[3][2];
        int[][] m2 = new int[2][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("m1[" + i + "][" + j + "]=");
                m1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("m2[" + i + "][" + j + "]=");
                m2[i][j] = sc.nextInt();
            }
        }

        int[][] m3 = new int[3][3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 2; j++) {
                    sum += m1[k][j] * m2[j][k];
                }
                m3[i][k]=sum;
                sum=0;
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println("m3["+i+"]["+j+"]="+m3[i][j]);
            }
        }
    }
}
