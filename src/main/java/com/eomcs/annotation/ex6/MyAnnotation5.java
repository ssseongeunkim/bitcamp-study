// 애노테이션 적용 범위
package com.eomcs.annotation.ex6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.FIELD})
public @interface MyAnnotation5 {
  String v1() default "가나다";
}


