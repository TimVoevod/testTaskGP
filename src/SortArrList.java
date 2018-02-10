import java.io.IOException;
import java.util.ArrayList;


class SortArrList {

    public static void merge(ArrayList<Integer> A, ArrayList<Integer> B) {
        for (int indexB = 0; indexB < B.size(); indexB++) {
            for (int indexA = 0; ; indexA++) {
                if (indexA == A.size() || A.get(indexA) > B.get(indexB)) {
                    A.add(indexA, B.get(indexB));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> A=new ArrayList();
        ArrayList<Integer> B=new ArrayList();

        A.add(1);
        A.add(13);
        A.add(24);
        A.add(27);
        A.add(39);
        A.add(74);

        B.add(2);
        B.add(5);
        B.add(16);
        B.add(20);
        B.add(42);
        B.add(80);

        merge(A,B);

        System.out.println(A);
    }
}