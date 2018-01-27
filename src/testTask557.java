import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class testTask557 {

    public static void main(String ... args) throws IOException {
        try(Scanner scanner = new Scanner(Paths.get("INPUT.TXT"));
            FileWriter out = new FileWriter("OUTPUT.TXT")){
            ArrayList<Integer> countAndSize = new ArrayList<>(Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            int count = countAndSize.get(0);
            int size = countAndSize.get(1);
            ArrayList<Integer> lineAndColumn = new ArrayList<>(Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            int primeNumber = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()).get(0);
            ArrayList<Integer> array = new ArrayList<>();
            scanner.nextLine();
            for(int i = 0 ; i < size ; i++){
                if(i == (lineAndColumn.get(0)-1)) {
                    array.addAll(Arrays.stream(scanner.nextLine()
                            .split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                }else{
                    scanner.nextLine();
                }
            }
            while(count > 1) {
                scanner.nextLine();
                ArrayList<Integer> array1 = new ArrayList<>(Collections.nCopies(countAndSize.get(1),0));
                for(int i = 0 ; i < size; i++){
                    ArrayList<Integer> array2 = new ArrayList<>(Arrays.stream(scanner.nextLine()
                            .split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
                    for (int j = 0; j < size; j++) {
                        array1.set(j, (array1.get(j) + array.get(i) * array2.get(j)) % primeNumber);
                    }
                }
                Collections.copy(array,array1);
                count--;
            }
            out.write(String.valueOf(array.get(lineAndColumn.get(1)-1)));
            out.flush();
        }
        catch(IOException e){

            e.printStackTrace();
        }
    }
}
