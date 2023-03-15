package cn.itcast.user.web;

import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    //获取端口
    @Value("${server.port}")
    int port;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        User user =userService.queryById(id);
        user.setAddress(port+"");//将一个无用的地址替换成port
        return user;
    }
}
