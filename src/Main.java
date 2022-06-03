import java.util.Objects;
import java.util.Scanner;


class Edit{
    static void edit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("수정하실 항목을 성명, 연락처, 주소 순으로 입력하여 주십시오.");
        String name, phone, address;
        System.out.println("성명 :");
        name = sc.next();
        System.out.println("연락처 :");
        phone = sc.next();
        System.out.println("주소 :");
        address = sc.next();

            }
        }


class deletion{

    public void delete() {
        String[] array2 = new_person.array2;
        System.out.println("삭제할 이름을 입력하세요");
        Scanner sc = new Scanner(System.in);
        String name = String.valueOf(Objects.requireNonNull(sc).next());
        for(int i = 0; i < new_person.getCnt(); i++){
            if(array2[i].equals(name)){
                for(int j = i; j < new_person.getCnt(); j++){
                    array2[j] = array2[j+1];
                    array2[j] = array2[j+1];
                }
                new_person.setCnt();
                System.out.println("삭제되었습니다.");
            }
        }
}

public static class Exit{
    static void exit(){
        System.out.println("종료하시겠습니까?");
        System.out.println("1.종료");
        System.out.println("2.종료하지 않고 계속 진행");
        Scanner sc = new Scanner(System.in);
        int exit = sc.nextInt();
        if(exit == 1){
            System.out.println("종료되었습니다.");
            System.exit(0);
        }
        else if(exit == 2){
            System.out.println("종료되지 않았습니다.");
        }
    }

}


}
public class Main {
    public static Object main;
    public static void main(String[] args){
        menu m = new menu();
        menu.menu_print();
        m.menu_select();

    }
    public static void main2(){
        //추가,검색, 수정, 삭제, 전체출력, 종료
        menu m = new menu();
        menu.menu_print();
        m.menu_select();



    }
}
    class menu{
        Scanner sc= new Scanner(System.in);
        static void menu_print(){
            System.out.println("1.추가");
            System.out.println("2.수정");
            System.out.println("3.삭제");
            System.out.println("4.전체출력");
            System.out.println("5.종료");
            System.out.println("6.검색");
        }
        void menu_select(){
            int select;
            System.out.println("메뉴를 선택하세요.");
            select = sc.nextInt();
            switch (select) {
                case 1 -> {
                    new_person.add2();
                }
                case 2 -> {
                    System.out.println("수정할 인덱스를 입력하세요.");
                    Edit.edit();
                }
                case 3 -> {
                    System.out.println("삭제할 인덱스를 입력하세요.");
                    deletion d = new deletion();
                    d.delete();
                    Main.main2();
                }
                case 4 -> {
                    System.out.println("전체출력");
                    total_print.prin2();
                    System.out.flush();
                    Main.main2();
                }
                case 5 -> {
                    System.out.println("종료");
                    deletion.Exit.exit();
                }
                case 6 -> {
                    System.out.println("검색할 이름을 입력하세요.");
                    Search2.search();
                    Main.main2();
                }
                default -> {
                    System.out.println("잘못된 입력입니다.");
                    Main.main2();
                }
            }
        }

}
