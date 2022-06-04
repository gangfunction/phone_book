import java.util.Scanner;

public class Exit {
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
            Main.main1();
        }
    }

}