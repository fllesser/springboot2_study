package com.chowyijiu.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableField(exist = false) //表中不存在
    private String userName;
    @TableField(exist = false)
    private String password;

    public User(String userName, String password) {
        this.userName=userName;
        this.password=password;
    }

    //数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
