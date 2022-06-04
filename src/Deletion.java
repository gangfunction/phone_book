import java.util.Scanner;

public class Deletion {

    public static void delete() {
        System.out.println("삭제할 이름을 입력하세요");
        Scanner sc = new Scanner(System.in);
        String name2 = sc.next();
        int result = 0;
        //조사해서 삭제할 이름이 어떤 인덱스에 있는지 확인,
        int i;
        for (i = 0; i < Addition.cnt; i++) {
            if (Addition.array[i].contains(name2)) {
                result = i;
                break;
            }
        }
        // 삭제 시키기
        for (i = result; i < Addition.cnt; i++) {
            Addition.array[i] = Addition.array[i + 1];
            System.out.println("삭제되었습니다.");

        }
        Addition.cnt--;
        Main.main1();
    }
}