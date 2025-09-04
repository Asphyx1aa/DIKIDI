package ru.dikidi.common.annotations;

import org.junit.jupiter.api.extension.ExtendWith;
import ru.dikidi.common.enums.EmployeeRole;
import ru.dikidi.common.extensions.EmployeeExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ExtendWith(EmployeeExtension.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WithEmployee {
    EmployeeRole role() default EmployeeRole.CREATOR;
}
