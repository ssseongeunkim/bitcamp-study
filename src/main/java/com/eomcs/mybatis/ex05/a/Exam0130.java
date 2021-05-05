// SqlSession 사용법 - select 문 실행하기 : 자바 객체의 프로퍼티 이름과 컬럼명을 일치시키기 II
package com.eomcs.mybatis.ex05.a;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.AttachFile;
import com.eomcs.mybatis.vo.Board;

public class Exam0130 {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex05/a/mybatis-config.xml")).openSession();

    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard2");

    for (Board b : boards) {
      System.out.println("[게시글 상세보기]");
      System.out.printf("번호 : %d\n", b.getNo());
      System.out.printf("제목 : %s\n", b.getTitle());
      System.out.printf("내용 : %s\n", b.getContent());
      System.out.printf("종료일 : %s\n", b.getRegisteredDate());
      System.out.printf("조회수 : %d\n", b.getViewCount());


      System.out.println("첨부파일 : ");

      //      if (b.getAttachFiles().size() == 1 && b.getAttachFiles().get(0).getFileNo() == 0) {
      //        //        b.getAttachFiles().get(0).getFilePath() == null
      //        System.out.println("  첨부파일이 없습니다.");
      //        continue;
      //      }

      for (AttachFile f : b.getAttachFiles()) {
        System.out.printf("  %d - %s\n", f.getFileNo(), f.getFilePath());
      }

      System.out.println("------------------------");
    }


    sqlSession.close();
  }

}


