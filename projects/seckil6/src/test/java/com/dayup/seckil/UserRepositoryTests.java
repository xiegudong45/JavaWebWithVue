package com.dayup.seckil;

import com.dayup.seckil.model.User;
import com.dayup.seckil.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

  @Autowired
  public UserService userService;

  @Test
  public void test() {
    User user = new User("alx", "1234");

    Assert.assertNotNull(userService.regist(user));
  }
}
