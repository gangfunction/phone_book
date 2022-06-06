//미완

import java.sql.*;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;


public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        App.main1();
    }

    public static void board_read() {
        try {
            PreparedStatement pstmt;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            String sql = "select * from board";
            pstmt = requireNonNull(con).prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("id : " + rs.getInt("id"));
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
        System.out.println("수정할 글의 id를 입력하세요.");
        String id = sc.next();
        System.out.println("수정할 글의 제목을 입력하세요.");
        String title = sc.next();
        System.out.println("수정할 글의 내용을 입력하세요.");
        String content = sc.next();
        try {
            PreparedStatement pstmt;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            String sql = "update board set title=?,content=? where id=? ";
            pstmt = requireNonNull(con).prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, id);
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
    public static void board_delete(){
        try {
            PreparedStatement pstmt;
            Scanner sc = new Scanner(System.in);
            System.out.println("삭제할 글 번호를 입력하세요.");
            int num = sc.nextInt();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
            String sql = "delete from board where id=?";
            pstmt = requireNonNull(con).prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.executeUpdate();
            System.out.println("게시판 글삭제가 완료되었습니다");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static boolean isLogin_status = false;
        static boolean flag = true;

        public static void isLogin() throws ClassNotFoundException {
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
            System.out.println(con);
            if (con != null) {
                String sql = "alter user ?@localhost identified by ?;";

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.setString(2, pw);

                pstmt.execute();
                System.out.println(sql);
                flag = true;
                System.out.println("로그인 성공");
                System.out.println("로그인한 유저 : " + id);
                isLogin_status= true;
            }

        } catch (SQLException e) {
            // RuntimeException은 인풋값이 잘못되거나 의도적으로 프로그래머가 잘못된 코드를 작성하여 에러가 발생한 경우
            throw new RuntimeException(e);
        }
        }

    public static void menu_select() throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        if (flag) {
            //board 테이블 제작

            //로그인 성공시 메뉴 출력
            System.out.println("1.게시판 글쓰기");
            System.out.println("2.게시판 글수정");
            System.out.println("3.게시판 글삭제");
            System.out.println("4.게시판 글보기");
            System.out.println("5.로그아웃");
            //입력받은 메뉴를 저장하기 위한 변수
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("게시판 글쓰기");
                    App.board_write();
                    App.menu_select();
                    break;
                case 2:
                    System.out.println("게시판 글수정");
                    App.board_update();
                    App.menu_select();
                    break;
                case 3:
                    System.out.println("게시판 글삭제");
                    App.board_delete();
                    App.menu_select();
                    break;
                case 4:
                    System.out.println("게시판 글보기");
                    App.board_read();
                    App.menu_select();
                    break;
                case 5:
                    System.out.println("로그아웃");
                    App.isLogin_status = false;
                    App.isLogin();
                    break;
                default:
                    System.out.println("잘못된 메뉴를 입력하셨습니다.");
                    App.menu_select();
                    break;
            }}}







    public static void main1() throws ClassNotFoundException, SQLException {
            Scanner sc = new Scanner(System.in);
            System.out.println("어서오십시오, 자바꿈나무 데이터베이스입니다.");
            System.out.println("어떤 모드를 선택하시겠습니까?");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 종료");
            System.out.println("4. 처음 시작할때 세팅용으로 사용하는 모드 -1회용- ");

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
                        pstmt.executeQuery("select user, host from user;");
                        pstmt.executeUpdate();
                        System.out.println(pstmt.executeQuery("select user, host from user;"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                case 2:

                    //preparedStatement 사용하여 쿼리문을 실행하는 방법
                    //rdbms 동일하거나 비슷한 데이터베이스문을 높은 효율성으로 반복적으로 실행하기위해 사용하는 기능
                    //반환된 결과값을 저장하기위해서 사용하는 객체

                    App.isLogin();
                    App.menu_select();
                    //로그인한 유저 표시
                    //게시판용 데이터베이스 제작



                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                case 4:
                    //데이터 베이스 제작
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
                        String sql2 = "select jdbc;";
                        pstmt = requireNonNull(con).prepareStatement(sql2);
                        pstmt.executeQuery(sql2);
                        System.out.println("데이터베이스 선택 완료");
                    } catch (SQLException e) {
                        System.out.println("데이터베이스 선택 실패");
                        try {
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
                            String sql = "create database jdbc";
                            pstmt = requireNonNull(con).prepareStatement(sql);
                            pstmt.executeQuery(sql);
                            System.out.println("데이터베이스 생성 완료");
                            App.main1();

                        } catch (SQLException e1) {
                            System.out.println("데이터베이스 생성 실패");
                            App.main1();
                        }
                        App.main1();
                    }
                    //게시판 제작

                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "1234");
                        String sql = "create table board(no int not null auto_increment, title varchar(100) not null, content varchar(1000) not null, writer varchar(20) not null, primary key(no));";
                        pstmt = requireNonNull(con).prepareStatement(sql);
                        pstmt.executeQuery(sql);
                        System.out.println("board 테이블 생성 완료");
                        App.main1();
                    } catch (Exception e) {
                        System.out.println("board 테이블 생성 실패");
                        e.printStackTrace();
                    }
                    App.main1();
                default:
                    throw new IllegalStateException("Unexpected value: " + select);
            }
        }
        }

