package com.hby.springbootswagger.controller;

import com.hby.springbootswagger.domain.GetUserRequest;
import com.hby.springbootswagger.domain.GetUserResponse;
import com.hby.springbootswagger.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "查询个人信息", description = "查询个人信息")
public class UserController {

    @ApiOperation(notes = "根据姓名模糊匹配用户", value = "根据姓名模糊匹配用户")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public ResponseEntity<GetUserResponse> openAccount(@RequestBody GetUserRequest requestDto) {
        GetUserResponse responseDto = new GetUserResponse();
        List<User> userList = new ArrayList<>();
        User user;
        for (int i = 0; i < 100; i++) {
            user = new User();
            user.setId(String.valueOf(i));
            user.setUserName("hby" + i);
            user.setUserAge(String.valueOf(10 + i));
            user.setUserHeight(String.valueOf(160 + i));
            user.setUserWeight(String.valueOf(60 + i));
            user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            userList.add(user);
        }
        responseDto.setUserInfoList(userList);
        return ResponseEntity.ok(responseDto);
    }
}
