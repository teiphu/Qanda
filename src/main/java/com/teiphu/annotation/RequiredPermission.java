package com.teiphu.annotation;

import java.lang.annotation.*;

/**
 * @Author Teiphu
 * @Creation 2019.05.20 上午 01:46
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequiredPermission {
    String value();
}
