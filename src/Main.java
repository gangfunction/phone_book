import java.util.InputMismatchException;
import java.util.Scanner;


class Exit {
    static void exit() {
        System.out.println("종료하시겠습니까?");
        System.out.println("1.종료");
        System.out.println("2.종료하지 않고 계속 진행");
        Scanner sc = new Scanner(System.in);
        int exit = sc.nextInt();
        if (exit == 1) {
            System.out.println("종료되었습니다.");
            System.exit(0);
        } else if (exit == 2) {
            System.out.println("종료되지 않았습니다.");
            Main.main2();
        }
    }

}


class Main {
    public static void main(String[] args) {
        menu.menu_print();
        menu.menu_select();

    }

    public static void main2() {
        //추가,검색, 수정, 삭제, 전체출력, 종료
        menu.menu_print();
        menu.menu_select();

    }
}

class menu {
    static Scanner sc = new Scanner(System.in);

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
        System.out.println("메뉴를 선택하세요. 1~6 까지의 자연수를 입력바랍니다.");
        System.out.println("----------------------------------------------------");
        try{
             select = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("잘못된 입력입니다.");
        }
        switch (select) {
            case 1 -> Addition.add2();
            case 2 -> Edit.edit();
            case 3 -> Deletion.delete();
            case 4 -> Prin2.prin2();
            case 5 -> Exit.exit();
            case 6 -> Search.search();
            default -> Main.main2();
        }
    }

}
