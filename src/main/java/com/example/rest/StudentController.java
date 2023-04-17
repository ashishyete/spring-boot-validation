package com.example.rest;

import com.example.dto.StudentDto;
import com.example.entity.Student;
import com.example.exception.UserNotFoundException;
import com.example.mapper.StudentMapper;
import com.example.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentMapper studentMapper;

    @PostMapping("/student")
    public Student addStudent(@RequestBody @Valid Student student) {
        return studentRepo.save(student);
    }

    @GetMapping("/students")
    public List<StudentDto> allStudents() {
        List<StudentDto> listOfStudentDto = studentMapper.toDtoList(studentRepo.findAll());
        List<StudentDto> returnList = new ArrayList<>();
        listOfStudentDto.stream().forEach(p -> {
            setUserNameAndUuid(p);
            returnList.add(p);
        });
        return returnList;
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(@PathVariable int id) {
        StudentDto student =  studentMapper.toDto(studentRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Student not found for Id : " + id)));
        return setUserNameAndUuid(student);
    }


    private StudentDto setUserNameAndUuid(StudentDto studentDto) {
        studentDto.setUserName(studentDto.getFirstName() + "-" + studentDto.getLastName());
        studentDto.setStudentUuid(UUID.randomUUID().toString());
        return studentDto;
    }

}
