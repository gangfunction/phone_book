import java.util.Scanner;

public class Search2{
    static void search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("검색하실 이름을 입력하세요.");
        String name = sc.next();
        for(int i = 0; i < new_person.getCnt(); i++){
            if(new_person.array2[i].equals(name)){
                System.out.println(new_person.array2[i]);
            }
        }
    }}
