// 해시는
import java.util.HashMap;
import java.util.Scanner;

public class Hash{

    static Scanner sc = new Scanner(System.in);
    
    static String name;
    static String phone;
    static String address;
    

    static HashMap<String, String> map = new HashMap<String, String>();

    public static void hashadd_sub(String key, String value) {
        map.put(key,value);
    }
    public static void hashprint() {
        for(String key:map.keySet()) {
            System.out.println("{"+key+","+map.get(key)+"}");
        }
    }
    public static void hashdelete() {
        System.out.println("삭제하실 이름을 입력하세요.");
        name = sc.next();
        map.remove(name);
        System.out.println("삭제되었습니다.");
        Main.main2();
    }

    public static void hashadd() {

        System.out.println("추가하실 항목을 성명, 연락처, 주소 순으로 입력하여 주십시오.");
        System.out.println("성명 :");
        String name = sc.next();
        System.out.println("연락처 :");
        phone = sc.next();
        System.out.println("주소 :");
        address = sc.next();
        Hash.hashadd_sub(name, phone+"\t"+address);
        System.out.println("추가되었습니다.");
        Main.main2();
    }

    public static void hashedit(){
        System.out.println("수정하실 이름을 입력하세요.");
        name = sc.next();
        System.out.println("수정하실 연락처를 입력하세요.");
        phone = sc.next();
        System.out.println("수정하실 주소를 입력하세요.");
        address = sc.next();
        map.put(name, phone+"\t"+address);
        System.out.println("수정되었습니다.");
        Main.main2();
    }


    public static void hashquit(){
        System.out.println("종료하시겠습니까?");
        System.out.println("1.예 2.아니오");
        int num = sc.nextInt();
        if(num == 1){
            System.out.println("종료되었습니다.");
            System.exit(0);
        }
        else{
            Main.main2();
        }
    }

    public static void hashsearch(){
        System.out.println("검색하실 이름을 입력하세요.");
        name = sc.next();
        System.out.println(map.get(name));
        Main.main2();
    }
}