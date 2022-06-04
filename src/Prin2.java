

public class Prin2 {
    static void prin2() {
        System.out.println("----------------------------------------------------");
        int array_size = Addition.array.length;
        System.out.println("이름\t연락처\t주소");
        if (Addition.cnt == 0) {
            System.out.println("저장된 정보가 없습니다.");
            Main.main2();
        }

        for (int i = 0; i < array_size; i++) {
            System.out.println(Addition.getarray()[i]);
        }
        Main.main2();

    }

}
