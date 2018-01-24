import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by user on 24.01.18.
 */
public class testTask579 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");

        int nminus = 0, nplus = 0, nminussum = 0, nplussum = 0;
        int k = in.nextInt();
        int[] n = new int[k];

        for (int i = 0; i < k; i++){
            n[i]=in.nextInt();
        }

        for (int i = 0; i < k; i++){
            if (n[i]<0){
                nminus++;
                nminussum += n[i];
            }
            else if (n[i]>0){
                nplus++;
                nplussum += n[i];
            }
        }

        int[] minusnumbers = new int[nminus];
        int[] plusnumbers = new int[nplus];

        int g = 0, j = 0;

        for (int i = 0; i < k; i++){
            if (n[i]<0){
                minusnumbers[j]=i+1;
                j++;
            }
            else if (n[i]>0){
                plusnumbers[g]=i+1;
                g++;
            }
        }

        if (Math.abs(nplussum) >= Math.abs(nminussum)){
            out.println(nplus);
            for (int i = 0; i < g; i++) {
                out.print(plusnumbers[i] + " ");
            }
        }
        else {
            out.println(nminus);
            for (int i = 0; i < j; i++) {
                out.print(minusnumbers[i] + " ");
            }
        }

        out.close();
    }
}
