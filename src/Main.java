
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> it = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            it.add(x);
        }
        Collections.sort(it, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer integer : it) {
            System.out.print(integer+" ");
        }
    }
}
