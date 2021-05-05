// 애노테이션 적용 범위
package com.eomcs.annotation.ex7;

import java.lang.annotation.Repeatable;

@Repeatable(value=Employees.class)
public @interface Employee {
  String value();
}


