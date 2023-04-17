package com.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ValidStudentCourse implements ConstraintValidator<StudentCourseValidator, String> {

    @Override
    public boolean isValid(String course, ConstraintValidatorContext constraintValidatorContext) {
        List<String> validCourses = Arrays.asList("Electronics", "Mechanical", "Computer");
        return validCourses.contains(course);
    }
}
