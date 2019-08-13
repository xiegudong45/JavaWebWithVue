package com.dayup.seckil.base.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class BaseApiController {

}
