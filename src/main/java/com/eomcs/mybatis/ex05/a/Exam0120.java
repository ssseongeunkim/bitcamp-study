// SqlSession 사용법 - select 문 실행하기 : 자바 객체의 프로퍼티 이름과 컬럼명을 일치시키기 II
package com.eomcs.mybatis.ex05.a;

import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.AttachFile;
import com.eomcs.mybatis.vo.Board;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("게시글 번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    keyboard.close();


    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex05/a/mybatis-config.xml")).openSession();

    Board b = sqlSession.selectOne("BoardMapper.selectBoard2", no);

    System.out.println("[게시글 상세보기]");
    System.out.printf("번호 : %d\n", b.getNo());
    System.out.printf("제목 : %s\n", b.getTitle());
    System.out.printf("내용 : %s\n", b.getContent());
    System.out.printf("종료일 : %s\n", b.getRegisteredDate());
    System.out.printf("조회수 : %d\n", b.getViewCount());


    System.out.println("첨부파일 : ");

    for (AttachFile f : b.getAttachFiles()) {
      System.out.printf("  %d - %s\n", f.getFileNo(), f.getFilePath());
    }


    sqlSession.close();
  }

}


