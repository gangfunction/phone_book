import java.util.Scanner;

public class deletion{

    public void delete() {
        String[] array2 = new_person.array2;
        System.out.println("삭제할 이름을 입력하세요");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int i,j;
        for( i = 0; i < new_person.getCnt(); i++){
            if(array2[i].equals(name)){
                for(j = 0; j < new_person.getCnt() ; j++ ){
                    array2[j] = array2[j+1];
                    array2[j] = array2[j+1];
                }
                System.out.println("삭제되었습니다.");
            }
        }
    }
}