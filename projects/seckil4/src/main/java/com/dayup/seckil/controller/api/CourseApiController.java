package com.dayup.seckil.controller.api;

import com.dayup.seckil.base.controller.BaseApiController;
import com.dayup.seckil.base.result.Result;
import com.dayup.seckil.model.Course;
import com.dayup.seckil.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CourseApiController extends BaseApiController {

  @Autowired
  public CourseService courseService;

  @RequestMapping(value="courseList", method= RequestMethod.GET)
  public Result<List<Course>> courseList() {

    return Result.success(courseService.findAllCourse());
  }
}
