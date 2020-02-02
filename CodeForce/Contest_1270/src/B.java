import java.util.*;


public class B{

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int noOfTests = scr.nextInt();
        int arrayLen, curNo;
        int max, min;
        List<Integer> array;

        for (int i = 0; i < noOfTests; i++) {
            arrayLen = scr.nextInt();
            if (arrayLen == 0){
                continue;
            }
            array = new ArrayList<>();
            for (int j = 0; j < arrayLen; j++) {
                array.add(scr.nextInt());
            }
            max = Collections.max(array);
            min = Collections.min(array);
            if (max - min >= arrayLen) {
                System.out.println("YES");
                System.out.println(array.indexOf(min) + " " + (array.indexOf(max)+1));
            } else {
                System.out.println("NO");
            }
        }

        return;
    }
}