package com.pblgllgs.school;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
@Component
public interface StudentClient {
    @GetMapping("/school/{school-id}")
    List<Student> findStudentsBySchoolId(@PathVariable("school-id") Integer schoolId);
}
