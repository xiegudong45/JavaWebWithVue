package com.dayup.seckil.service.impl;

import com.alibaba.fastjson.JSON;
import com.dayup.seckil.model.Course;
import com.dayup.seckil.redis.CourseRedis;
import com.dayup.seckil.repository.CourseRepository;
import com.dayup.seckil.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private CourseRedis courseRedis;

  public static final String ALL_COURSE_REDIS = "allCourseRedis";

  @Override
  public List<Course> findAllCourse() {
    List<Course> courseList = new ArrayList<Course>();

    // read data from redis if exists
    String courseListString = (String) courseRedis.getString(ALL_COURSE_REDIS);
    courseList = JSON.parseArray(courseListString, Course.class);
    // else read data from mySQL
    if (StringUtils.isEmpty(courseListString)) {
      // read mySQL
      courseList = courseRepository.findAll();
      // cache in redis
      String coursesString = JSON.toJSONString(courseList);
      courseRedis.putString(ALL_COURSE_REDIS, coursesString, -1);
    }

    return courseList;
  }

  @Override
  public Course findCourseByCourseNo(String courseNo) {
    Optional<Course> course = courseRepository.findById(courseNo);
    return course.orElse(null); // course.isPresent() ? user.get() : null
  }
}
