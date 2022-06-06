import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        menu.mode_print();
        menu.mode_select();


    }
    public static void main1() {
        menu.menu_print();
        menu.menu_select();

    }

    public static void main2() {
        //추가,검색, 수정, 삭제, 전체출력, 종료
        menu.hash_print();
        menu.hash_select();

    }

}

class menu {
    static Scanner sc = new Scanner(System.in);
    static void mode_print(){
        System.out.println("어서오십시오. 손님");
        System.out.println("어떤 모드를 선택하시겠습니까?");
        System.out.println("1.리스트 사용");
        System.out.println("2.해시맵 사용");
    }
    static void mode_select(){
        int mode = 0;
        try{
            mode = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("잘못된 입력입니다.");
            System.exit(0);
        }
        switch(mode){
            case 1:
                System.out.println("리스트 사용을 선택하셨습니다.");
                Main.main1();
                break;
            case 2:
                System.out.println("해시맵 사용을 선택하셨습니다.");
                Main.main2();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                System.exit(0);
                break;
        }
    }
    static void menu_print() {
        System.out.println("----------------------------------------------------");
        System.out.println("1.추가");
        System.out.println("2.수정");
        System.out.println("3.삭제");
        System.out.println("4.전체출력");
        System.out.println("5.종료");
        System.out.println("6.검색");
        System.out.println("----------------------------------------------------");
    }

    static void menu_select() {
        int select = 0;
        System.out.println("메뉴를 선택하세요. 1~6");
        System.out.println("----------------------------------------------------");

        try{
             select = sc.nextInt();
        }catch(InputMismatchException e){
            menu_select();
        }
        switch (select) {
            case 1 -> Addition.add2();
            case 2 -> Edit.edit();
            case 3 -> Deletion.delete();
            case 4 -> Prin2.prin2();
            case 5 -> Exit.exit();
            case 6 -> Search.search();
            default -> Main.main1();
        }
    }

    static void hash_print() {
        System.out.println("----------------------------------------------------");
        System.out.println("1.Create");
        System.out.println("2.Read");
        System.out.println("3.Update");
        System.out.println("4.Delete");
        System.out.println("5.Quit");
        System.out.println("----------------------------------------------------");
    }
    static void hash_select() {
        int select = 0;
        System.out.println("메뉴를 선택하세요. 1~5");
        System.out.println("----------------------------------------------------");
        System.out.println("현재 등록된 상태");
        Hash.hashprint();
        System.out.println("----------------------------------------------------");
        try{
            select = sc.nextInt();
        }catch(InputMismatchException e){
            menu_select();
        }
        switch (select) {
            case 1 -> Hash.hashadd();
            case 2 -> Hash.hashsearch();
            case 3 -> Hash.hashedit();
            case 4 -> Hash.hashdelete();
            case 5 -> Hash.hashquit();
            default -> Main.main2();
        }
    }

}
