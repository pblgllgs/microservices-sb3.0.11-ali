package com.pblgllgs.school;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findStudentsBySchoolId(Integer schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(
                School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build()
        );
        var students = studentClient.findStudentsBySchoolId(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
