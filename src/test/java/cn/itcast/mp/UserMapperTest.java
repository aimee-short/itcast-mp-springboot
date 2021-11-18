package cn.itcast.mp;

import cn.itcast.mp.mapper.UserMapper;
import cn.itcast.mp.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelect(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testFindById(){
        User users = userMapper.findById(1L);
        System.out.println(users.toString());
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("zhangfei");
        user.setName("张飞");
        user.setPassword("124");
        user.setAge(111);
        userMapper.insert(user);


    }

    @Test
    public void testDelete(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",111);

        userMapper.delete(queryWrapper);


    }
    @Test
    public void testQueryPage(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("password","123456");

        // 第0页跟第1页内容一样
        Page<User> page = new Page<>(2,3);
        IPage<User> userIPage = userMapper.selectPage(page, queryWrapper);
        System.out.println(userIPage.toString());
    }

    @Test
    public void testEq(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        String name = "张飞";
        Integer age = 20;
        queryWrapper.eq(name != null && name != "",User::getName,name);
        queryWrapper.gt(User::getAge, age);

        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

}
