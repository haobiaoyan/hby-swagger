package com.hby.springbootswagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
@Data
@ApiModel(description = "获取用户信息返回DTO")
public class GetUserResponse {
    @ApiModelProperty(value = "用户信息列表")
    private List<User> userInfoList=new ArrayList<>();
}
