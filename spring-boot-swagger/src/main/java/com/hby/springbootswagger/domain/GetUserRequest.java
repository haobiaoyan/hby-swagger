package com.hby.springbootswagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@Getter
//@Setter
@Data
@ApiModel(description = "获取用户信息请求DTO")
public class GetUserRequest {
    @ApiModelProperty(value = "关键字")
    private String userKeyword;
}
