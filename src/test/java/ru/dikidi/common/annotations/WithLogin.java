package ru.dikidi.common.annotations;

import org.junit.jupiter.api.extension.ExtendWith;
import ru.dikidi.common.extensions.LoginExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ExtendWith(LoginExtension.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WithLogin {
}
