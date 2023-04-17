package com.example.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidStudentCourse.class)
public @interface StudentCourseValidator {

    String message() default "Invalid Course.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
