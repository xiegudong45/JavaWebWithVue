package com.dayup.seckil;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Hello world!";
  }
}
