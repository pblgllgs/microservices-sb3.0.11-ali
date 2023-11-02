package com.pblgllgs.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<School> createStudent(@RequestBody School school){
        return new ResponseEntity<>(schoolService.saveSchool(school), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllStudents(){
        return new ResponseEntity<>(schoolService.findAllSchools(),HttpStatus.OK);
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findStudentsBySchoolId(@PathVariable("school-id") Integer schoolId){
        return new ResponseEntity<>(schoolService.findStudentsBySchoolId(schoolId),HttpStatus.OK);
    }
}
