// 애노테이션 프로퍼티 타입
package com.eomcs.annotation.ex6;

// @MyAnnotation은 타입(인터페이스와 클래스)에만 붙일 수 있다.
//@MyAnnotation3 // OK!
public class MyClass3 {

  //  @MyAnnotation3
  int i; // 컴파일 오류!

  @MyAnnotation3
  public void m() {
    //    @MyAnnotation3
    int a;
  } // OK!
}
