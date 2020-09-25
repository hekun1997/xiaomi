package com.xiaomi;

import static org.junit.Assert.assertTrue;

import com.xiaomi.user.UserServiceApplication;
import com.xiaomi.user.entity.User;
import com.xiaomi.user.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Unit test for simple App.
 */
@SpringBootTest(classes = {UserServiceApplication.class})
@RunWith(SpringRunner.class)
public class UserServiceApplicationTest
{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllUserTest(){
        User user = User.builder()
                .username("hekun")
                .password("123")
                .role(0L)
                .createtime(new Date(System.currentTimeMillis()))
                .build();
        Integer userId = userRepository.save(user).getUserid();
        Assert.assertNotNull("save failed.",userId);
    }
}
