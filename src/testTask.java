import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class testTask {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");

        String m = in.nextLine();
        String n = in.nextLine();

        int lastPos = 0;
        String found = "YES";
        for(char a : m.toCharArray()){
            int pos = n.indexOf(a, lastPos);
            if(pos == -1){
                found = "NO";
                break;
            }
            lastPos = pos + 1;
        }
        out.println(found);
        out.close();
    }

}