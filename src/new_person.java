import java.util.Scanner;

public class new_person {


    static String[] array2 = new String[30];
    public static int cnt;

    public static String[] getArray2() {
        return array2;
    }
    static Scanner sc = new Scanner(System.in);

    public static int getCnt() {
        return cnt;
    }


    public static void setCnt() {
    }


    public static void add2() {
        System.out.println("추가하실 항목을 성명, 연락처, 주소 순으로 입력하여 주십시오.");
        String name, phone, address;
        System.out.println("성명 :");
        name = sc.next();
        System.out.println("연락처 :");
        phone = sc.next();
        System.out.println("주소 :");
        address = sc.next();

        if (new_person.cnt < 30) {
            int cnt = 0;

            String alpha = name+"\t"+phone+"\t"+address;
            array2[cnt++] = alpha;
            new_person.cnt = cnt;
            System.out.println("추가되었습니다.");
            Main.main2();
        } else {
            System.out.println("추가할 수 없습니다.");
            Main.main2();
            }



    }
    }
