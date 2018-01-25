import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class testTask670 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");

        int size = in.nextInt();
        ArrayList<Integer> m = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            m.add(i+1);
        }

        for (int k = 0; k < size; k++) {
            int array[] = new int[(int) Math.log10(m.get(k)) + 1];
            for (int i = 0; i < array.length; i++) {
                array[i] = m.get(k) % 10;
                m.set(k, (m.get(k))/10);
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = i; j < array.length; j++)
                    if (array[i] == array[j] && i != j) {
                        size++;
                        m.add(size);
                        i = array.length-1;
                        j = array.length-1;
                    }
            }
        }

        out.println(size);
        out.close();
    }

}