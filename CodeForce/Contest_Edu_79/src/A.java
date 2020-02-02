import java.lang.reflect.Array;
import java.util.*;

public class A {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[] tests = new int[n];

    for (int i = 0; i < n; i++) {
      if (solutionA(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
    return;
  }

  public static boolean solutionA(int x, int y, int z) {
    if (twoNumbersDiff(x + y, z)
            || twoNumbersDiff(x + z, y)
            || twoNumbersDiff(y + z, x)) {
      return true;
    }

    if (x + y >= z && x + z >= y && y + z >= x){
      return  true;
    }

    return false;

  }

  public static boolean twoNumbersDiff(int x, int y) {
    return (x == y || x == y + 1 || x == y - 1);
  }
}
