package com.hby.springbootswagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@Getter
//@Setter
@Data
@ApiModel(description = "用户信息")
public class User {
    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "年龄")
    private String userAge;

    @ApiModelProperty(value = "身高")
    private String userHeight;

    @ApiModelProperty(value = "体重")
    private String userWeight;

    @ApiModelProperty(value = "创建时间")
    private String createTime;
}
