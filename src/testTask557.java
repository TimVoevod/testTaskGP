import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class testTask557 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");

        int m = in.nextInt();
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int p = in.nextInt();

        int[][] mA = new int[n][n];
        int[][] mB = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mA[i][j] = in.nextInt();
            }
        }

        if (m>1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mB[i][j] = in.nextInt();
                }
            }


            int[][] res = new int[n][n];


            for (int t = 0; t < m - 2; t++) {

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            res[i][j] += mA[i][k] * mB[k][j];
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mA[i][j] = res[i][j];
                        mB[i][j] = in.nextInt();
                        res[i][j] = 0;
                    }
                }

            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        res[i][j] += mA[i][k] * mB[k][j];
                    }
                }
            }
            out.println(res[a - 1][b - 1] % p);
            out.println(res[a - 1][b - 1]);
            out.close();
        }
        else
        {
            out.println(mA[a - 1][b - 1] % p);
            out.close();
        }
    }

}
