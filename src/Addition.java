import java.util.Scanner;

public class Addition {
    static Scanner sc = new Scanner(System.in);

    //배열에 들어갈 수 있는 총량 설정
    static String[] array = new String[30];
    static int cnt = 0;

    public static String[] getarray() {
        return array;
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

        if (Addition.cnt < 30) {
            String alpha = name + "\t" + phone + "\t" + address;
            Addition.array[cnt++] = alpha;
            System.out.println("추가되었습니다.");

            Main.main2();
        } else {
            System.out.println("추가할 수 없습니다.");

            Main.main2();
            }
        }
    }

