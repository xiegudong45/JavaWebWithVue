package com.dayup.seckil.repository;

import com.dayup.seckil.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
