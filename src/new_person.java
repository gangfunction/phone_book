import java.util.Scanner;

public class new_person {
    static Scanner sc = new Scanner(System.in);
    static String[] array2 = new String[30];
    static int cnt = 0;
    public static String[] getArray2() {
        return array2;
    }
    public static void add2() {
        System.out.println("추가하실 항목을 성명, 연락처, 주소 순으로 입력하여 주십시오.");
        String phone, address;
        System.out.println("성명 :");
        String name = sc.next();
        System.out.println("연락처 :");
        phone = sc.next();
        System.out.println("주소 :");
        address = sc.next();
        while (true){
            if (new_person.getCnt() <30) {
                String beta = name+"\t"+phone+"\t"+address;
                new_person.array2[cnt++] = beta;
                System.out.println("추가되었습니다.");

                menu.getMain();
                menu.getMain2();
                break;
            } else {
                System.out.println("추가할 수 없습니다.");

                menu.getMain();
                menu.getMain2();
                break;
            }
        }
    }

    static int getCnt() {
        return cnt;
    }


}

