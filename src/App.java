//미완

import java.sql.*;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;


public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        App.main1();
    }

    static boolean isLogin_status = false;
    static boolean menu_status;



    public static void board_read() {
        try {
            PreparedStatement pstmt;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            String sql = "select * from board";
            pstmt = requireNonNull(con).prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("title : " + rs.getString("title"));
                System.out.println("content : " + rs.getString("content"));
                System.out.println("---------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void board_update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정할 글의 제목을 입력하세요.");
        String title = sc.next();
        String title_tobefixed= title;
        System.out.println("수정할 글의 내용을 입력하세요.");
        String content = sc.next();
        try {
            PreparedStatement pstmt;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            String sql = "update board set title=?,content=? where title=?";
            pstmt = requireNonNull(con).prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, title_tobefixed);
            pstmt.executeUpdate();
            System.out.println("게시판 글수정이 완료되었습니다");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void board_write() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게시판 글쓰기를 선택하셨습니다.");
        System.out.println("작성할 글의 제목을 입력하세요.");
        String title = sc.next();
        System.out.println("작성할 글의 내용을 입력하세요.");
        String content = sc.next();
        try {
            PreparedStatement pstmt;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            String sql = "insert into board(title,content) values(?,?)";
            pstmt = requireNonNull(con).prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.executeUpdate();
            System.out.println("게시판 글쓰기가 완료되었습니다");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void board_delete() {
        try {
            PreparedStatement pstmt;
            Scanner sc = new Scanner(System.in);
            System.out.println("삭제할 글 제목을 입력하세요.");
            String title = sc.next();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            String sql = "delete from board where title=?";
            pstmt = requireNonNull(con).prepareStatement(sql);
            pstmt.setString(1,title);
            pstmt.executeUpdate();
            System.out.println("게시판 글삭제가 완료되었습니다");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        static boolean flag = true;

        public static void isLogin () throws ClassNotFoundException {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("로그인을 선택하셨습니다.");
                System.out.println("아이디를 입력하세요.");
                String id = sc.next();
                System.out.println("비밀번호를 입력하세요.");
                String pw = sc.next();
                PreparedStatement pstmt;

                Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc 접속 실패시 ClassNotFoundException 발생
                //db연결을 위해서 사용하는 객체
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
                //입력받은 아이디와 비밀번호를 이용하여 쿼리문을 실행하는 방법
                //sql 넘기기 전에 sql 문법으로 인식되지 않기위해 ?표시를 해준다.
                flag = false;
                if (con != null) {
                    String sql = "alter user ?@localhost identified by ?;";

                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, id);
                    pstmt.setString(2, pw);

                    pstmt.execute();
                    flag = true;
                    System.out.println("로그인 성공");
                    System.out.println("-------------");
                    System.out.println("로그인한 유저 : " + id);
                    System.out.println("-------------");
                    isLogin_status = true;
                }

            } catch (SQLException e) {
                // RuntimeException은 인풋값이 잘못되거나 의도적으로 프로그래머가 잘못된 코드를 작성하여 에러가 발생한 경우
                throw new RuntimeException(e);
            }
        }

        public static void menu_select () throws ClassNotFoundException, SQLException {
            Scanner sc = new Scanner(System.in);
            if (flag) {
                //board 테이블 제작

                //로그인 성공시 메뉴 출력
                System.out.println("-------------");
                System.out.println("1.게시판 글쓰기");
                System.out.println("2.게시판 글수정");
                System.out.println("3.게시판 글삭제");
                System.out.println("4.게시판 글보기");
                System.out.println("5.게시판 생성(1회용)");
                System.out.println("6.로그아웃");
                System.out.println("-------------");
                //입력받은 메뉴를 저장하기 위한 변수
                int menu = sc.nextInt();

                switch (menu) {
                    case 1 -> {
                        System.out.println("게시판 글쓰기");
                        System.out.println("-------------");
                        App.board_write();
                        App.menu_select();
                    }
                    case 2 -> {
                        System.out.println("게시판 글수정");
                        System.out.println("-------------");
                        App.board_update();
                        App.menu_select();
                    }
                    case 3 -> {
                        System.out.println("게시판 글삭제");
                        System.out.println("-------------");
                        App.board_delete();
                        App.menu_select();
                    }
                    case 4 -> {
                        System.out.println("게시판 글보기");
                        System.out.println("-------------");
                        App.board_read();
                        App.menu_select();
                    }
                    case 5 -> {
                        System.out.println("게시판 생성");
                        App.board_create();
                        App.menu_select();
                    }
                    case 6 -> {
                        System.out.println("로그아웃");
                        isLogin_status = false;
                        App.main1();
                    }
                    default -> {
                        System.out.println("잘못된 메뉴를 입력하셨습니다.");
                        App.menu_select();
                    }
                }
            }
        }


        public static void main1 () throws ClassNotFoundException, SQLException {
            Scanner sc = new Scanner(System.in);
            int cnt=0;
            if(cnt == 0){
                //카운트 변수를 설정해서 단 한번만 보여주기.
                System.out.println("어서오십시오, 자바꿈나무 데이터베이스입니다.");
                ++cnt;

            }
            System.out.println("어떤 모드를 선택하시겠습니까?");
            System.out.println("1. 회원가입");

            if (isLogin_status) {
                menu_status = false;
                System.out.println("2. 로그아웃");
            } else {
                menu_status = true;
                System.out.println("2. 로그인");
            }
            if (menu_status) {
            } else {
            }
            System.out.println("3. 종료");
            if(isLogin_status){
                System.out.println("4. 게시판");
            }

            // 로그인 상태 표시
            System.out.println("로그인 상태: " + isLogin_status);
            PreparedStatement pstmt;
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("회원가입을 선택하셨습니다.");
                    System.out.println("아이디를 입력하세요.");
                    String id = sc.next();
                    //아이디 중복체크
                    ResultSet rs;
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
                        String sql = "select User, Host from mysql.user where User = ?;";
                        pstmt = requireNonNull(con).prepareStatement(sql);
                        pstmt.setString(1, id);
                        rs = pstmt.executeQuery();
                        if (rs.next()) {
                            System.out.println("중복된 아이디가 있습니다.");

                            App.main1();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //아이디 중복체크 끝
                    System.out.println("비밀번호를 입력하세요.");
                    String pw = sc.next();
                    //비밀번호 입력 여부 확인
                    System.out.println("비밀번호를 한번 더 입력하세요.");
                    String pw2 = sc.next();
                    if (!pw.equals(pw2)) {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                        App.main1();
                    }
                    //비밀번호 입력 여부 확인 끝
                    //회원등록
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
                        String sql = "create user ?@localhost identified by ?;";
                        pstmt = requireNonNull(con).prepareStatement(sql);
                        pstmt.setString(1, id);
                        pstmt.setString(2, pw);
                        pstmt.executeUpdate();
                        String sql2 = "grant super on *.* to ?@localhost;";
                        pstmt = requireNonNull(con).prepareStatement(sql2);
                        pstmt.setString(1, id);
                        pstmt.executeUpdate();
                        System.out.println("회원가입이 완료되었습니다.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                case 2:

                    //preparedStatement 사용하여 쿼리문을 실행하는 방법
                    //rdbms 동일하거나 비슷한 데이터베이스문을 높은 효율성으로 반복적으로 실행하기위해 사용하는 기능
                    //반환된 결과값을 저장하기위해서 사용하는 객체
                    if(menu_status){
                        App.isLogin();
                    }else{
                        menu_status = false;
                        isLogin_status = false;
                        System.out.println("로그아웃이 완료되었습니다.");
                        App.main1();
                    }
                    App.menu_select();
                    //로그인한 유저 표시
                    //게시판용 데이터베이스 제작


                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);

                case 4:
                    menu_select();
                default:
                System.out.println("잘못된 입력입니다.");
                App.main1();
        }}
    public static void board_create() throws SQLException, ClassNotFoundException {
        //데이터 베이스 제작
        Connection con;
        if (isLogin_status) {

            System.out.println("데이터베이스 선택 시도");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            String sql2 = "use jdbc;";
            PreparedStatement pstmt;
            pstmt = requireNonNull(con).prepareStatement(sql2);
            pstmt.executeUpdate();
            System.out.println("데이터베이스 선택 완료");
            System.out.println("-------------");
            System.out.println("기존 테이블 삭제 시도");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            String sql = "drop table if exists board;";
            pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("기존 테이블 삭제 완료");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
                sql = "create table jdbc.board(no int not null auto_increment, title varchar(100) not null, content varchar(1000) not null, primary key(no));";
                pstmt = requireNonNull(con).prepareStatement(sql);
                pstmt.executeUpdate();
                System.out.println("board 테이블 생성 완료");
                App.main1();
            } catch (Exception e) {
                System.out.println("board 테이블 생성 실패");
                e.printStackTrace();
            }
        } else {
            System.out.println("데이터베이스 선택 실패");
            System.out.println("데이터베이스 생성 시도");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
                String sql = "create database jdbc";
                PreparedStatement pstmt;
                pstmt = requireNonNull(con).prepareStatement(sql);
                pstmt.executeQuery(sql);
                System.out.println("데이터베이스 생성 완료");
                App.main1();
                try {
                    System.out.println("board테이블 생성시도");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
                    sql = "create table jdbc.board(no int not null auto_increment, title varchar(100) null, content varchar(1000) null, primary key(no));";
                    pstmt = requireNonNull(con).prepareStatement(sql);
                    pstmt.executeQuery(sql);
                    System.out.println("board 테이블 생성 완료");
                    App.main1();
                } catch (Exception e1) {
                    System.out.println("board 테이블 생성 실패");
                }

            } catch (SQLException e1) {
                System.out.println("데이터베이스 생성 실패");
                App.main1();
            }
            App.main1();
        }
        //게시판 제작

    }
        }


