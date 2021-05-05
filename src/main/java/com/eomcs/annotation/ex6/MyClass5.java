// 애노테이션 프로퍼티 타입
package com.eomcs.annotation.ex6;

// @MyAnnotation은 타입(인터페이스와 클래스)에만 붙일 수 있다.
//@MyAnnotation5 // OK!
public class MyClass5 {

  @MyAnnotation5
  int i; // 컴파일 오류!

  //  @MyAnnotation5
  public void m(@MyAnnotation5 int b) {
    @MyAnnotation5
    int a;
  } // OK!
}
