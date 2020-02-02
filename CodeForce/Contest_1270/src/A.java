import java.util.*;

public class A {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        int noOfTests = scr.nextInt();
        int highestCard, fstCards, sndCards;
        int curNo;
        boolean win;
        for (int i = 0; i < noOfTests; i++) {
            win = false;
            highestCard = scr.nextInt();
            fstCards = scr.nextInt();
            sndCards = scr.nextInt();
            for (int j = 0; j < fstCards; j++) {
                curNo = scr.nextInt();
                if (curNo == highestCard) {
                    win = true;
                    break;
                }
            }
            while (sndCards > 0) {
                scr.nextInt();
                sndCards--;
            }

            if (win) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        return;
    }
}
