import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class testTask557 {

    public static void main(String ... args) throws IOException {
        Scanner in = new Scanner(Paths.get("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");
            ArrayList<Integer> countAndSize = new ArrayList<>(Arrays.stream(in.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            int m = countAndSize.get(0);
            int n = countAndSize.get(1);
            ArrayList<Integer> lineAndColumn = new ArrayList<>(Arrays.stream(in.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            int primeNumber = Arrays.stream(in.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()).get(0);
            ArrayList<Integer> array = new ArrayList<>();
            in.nextLine();
            for(int i = 0 ; i < n ; i++){
                if(i == (lineAndColumn.get(0)-1)) {
                    array.addAll(Arrays.stream(in.nextLine()
                            .split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                }else{
                    in.nextLine();
                }
            }
            while(m > 1) {
                in.nextLine();
                ArrayList<Integer> array1 = new ArrayList<>(Collections.nCopies(countAndSize.get(1),0));
                for(int i = 0 ; i < n; i++){
                    ArrayList<Integer> array2 = new ArrayList<>(Arrays.stream(in.nextLine()
                            .split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                    for (int j = 0; j < n; j++) {
                        array1.set(j, (array1.get(j) + array.get(i) * array2.get(j)) % primeNumber);
                    }
                }
                Collections.copy(array,array1);
                m--;
            }
            out.write(String.valueOf(array.get(lineAndColumn.get(1)-1)));
            out.flush();
    }
}

