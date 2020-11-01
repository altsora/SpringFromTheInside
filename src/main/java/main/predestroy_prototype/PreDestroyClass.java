package main.predestroy_prototype;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PreDestroyClass {
    String destroyMethod();
}
