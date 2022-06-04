import java.util.Arrays;


public class total_print {
    static void prin2() {
        System.out.println("----------------------------------------------------");
        int array_size = new_person.getArray2().length;
        System.out.println("이름\t연락처\t주소");
        String array= Arrays.toString(new_person.getArray2());
        if (new_person.getCnt() == 0) {
            System.out.println("저장된 정보가 없습니다.");
        }

        for (int i = 0; i < array_size; i++) {
                System.out.println(new_person.getArray2()[i]);
            }
        }

    }
