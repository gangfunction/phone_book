import java.util.Scanner;

public class deletion{

    public static void delete() {
        System.out.println("삭제할 이름을 입력하세요");
        Scanner sc = new Scanner(System.in);
        String name2 = sc.next();
        int result = 0;
        //조사해서 삭제할 이름이 어떤 인덱스에 있는지 확인,
        int i;
        for (i=0; i < new_person.cnt; i++) {
            if (new_person.array2[i].contains(name2)) {
                result = i;
                break;
            }
        }
        // 다음값과 일치시켜 삭제 시키기
        for (i = result; i < new_person.cnt; i++) {
            new_person.array2[i] = new_person.array2[i + 1];
            System.out.println("삭제되었습니다.");

        }
        new_person.cnt--;
        Main.main2();
    }
        }