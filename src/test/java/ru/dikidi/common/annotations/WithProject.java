package ru.dikidi.common.annotations;

import org.junit.jupiter.api.extension.ExtendWith;
import ru.dikidi.common.enums.ProjectType;
import ru.dikidi.common.extensions.ProjectExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ExtendWith(ProjectExtension.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WithProject {
    ProjectType type() default ProjectType.COMPANY;
}

