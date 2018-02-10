import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Words
{
    public static void main(String[] args)
    {

        if (args.length == 0)
        {
            System.err.print("Invalid parametrs for program. ");
            System.err.println("Program must have one parametr.");
            return;
        }

        Scanner in = new Scanner(System.in);
        String str;
        String[] w;
        ArrayList<String> res=new ArrayList();
        int j = 0;

        System.out.print("Параметр программы: ");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
        System.out.println("Строки: ");

        while (!(str = in.nextLine()).isEmpty())
        {
            w = str.split(" ");
            for (String iterStr: args) {
                for (int i = 0; i < w.length; i++) {
                    try {
                        if (w[i].matches(iterStr)) {
                            res.add(str);
                            break;
                        }
                    }
                    catch (PatternSyntaxException ex) {
                        if (w[i].equals(iterStr)) {
                            res.add(str);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Вывод:");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        in.close();
    }
}