import java.util.Scanner;

public class Search {
    static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색하실 이름을 입력하세요.");
        String name = sc.next();
        for (int i = 0; i < Addition.cnt; i++) {
            if (Addition.array[i].equals(name)) {
                System.out.println(Addition.array[i]);
                Main.main2();
            }
        }
    }
}
