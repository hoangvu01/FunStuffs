import java.util.*;

public class B1 {

  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int testCases = scanner.nextInt();
//    int n, s;
//    s = scanner.nextInt();
//    int[] verses;
//    for (int k = 0; k < testCases; k++){
//      n = scanner.nextInt();
//      s = scanner.nextInt();
//      verses = new int[n];
//      for (int i = 0; i < n; i++) {
//        verses[i] = scanner.nextInt();
//      }
////      System.out.println(solutionB(verses, s));
//    }
    System.out.println(solutionB(new int[]{2,9,1,3,18,1,4}, 11));
    return;
  }

  public static int solutionB(int[] verses, int time) {
    for (int i = 0; i < verses.length; i++){
      if (verses[i] > time || time <= 0){
        return verses.length - i - 1;
      }

      time -= verses[i];
    }

    return 0;
  }
}