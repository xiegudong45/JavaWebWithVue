package com.dayup.seckil.service;

import com.dayup.seckil.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
  public List<Course> findAllCourse();

  public Course findCourseByCourseNo(String courseNo);


  public int reduceStockByCourseNo(String courseNo);
}
