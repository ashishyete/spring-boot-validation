package com.example.mapper;

import com.example.entity.Student;
import com.example.dto.StudentDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    Student toEntity(StudentDto studentDto);

    StudentDto toDto(Student student);

    List<Student> toEntityList(List<StudentDto> studentDto);

    List<StudentDto> toDtoList(List<Student> student);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Student partialUpdate(StudentDto studentDto, @MappingTarget Student student);
}