import java.util.Scanner;

public class Edit {
    public static void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정하실 이름을 입력하세요.");
        String name3 = sc.next();
        for (int i = 0; i < Addition.cnt; i++) {
            if (Addition.array[i].contains(name3)) {
                System.out.println(Addition.array[i]);
                System.out.println("수정하실 항목을 성명, 연락처, 주소 순으로 입력하여 주십시오.");
                String name2, phone2, address2;
                System.out.println("성명 :");
                name2 = sc.next();
                System.out.println("연락처 :");
                phone2 = sc.next();
                System.out.println("주소 :");
                address2 = sc.next();

                if (Addition.cnt < 30) {
                    int cnt = 0;

                    String alpha = name2 + "\t" + phone2 + "\t" + address2;
                    Addition.array[cnt] = alpha;
                    System.out.println("수정되었습니다.");

                    Main.main1();
                } else {
                    System.out.println("수정할 수 없습니다.");
                    Main.main1();
                }

            }
        }
    }
}