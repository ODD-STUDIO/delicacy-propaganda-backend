package com.odd.delicacy.entity.join;

import com.odd.delicacy.base.BaseEntity;
import com.odd.delicacy.valid.Create;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * 商品实体类
 *
 * @author zy
 * @date 2021/7/5 18:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinInfo extends BaseEntity<JoinInfo> {

    @NotBlank(groups = {Create.class}, message = "加盟者姓名不能为空")
    private String franchiseesName;

    private String franchiseesPhonenum;

    private String franchiseesAddress;

    private String franchiseesReason;
}
