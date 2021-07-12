package com.odd.delicacy.entity.admin;

import com.odd.delicacy.base.BaseEntity;
import com.odd.delicacy.valid.Create;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Administer extends BaseEntity<Administer> {

    /**
     * 用户的名字
     */
    @NotBlank(groups = {Create.class},message = "用户名不能为空")
    private String name;

    /**
     * 登录的用户名
     */
    @NotBlank(groups = {Create.class},message = "用户名不能为空")
    private String username;


    private String password;
}
