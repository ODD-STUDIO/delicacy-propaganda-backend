package com.odd.delicacy.entity.good;

import com.odd.delicacy.base.BaseEntity;
import com.odd.delicacy.entity.picture.Picture;
import com.odd.delicacy.valid.Create;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 商品实体类
 *
 * @author Tanglinfeng
 * @date 2021/7/5 18:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good extends BaseEntity<Good> {

    @NotBlank(groups = {Create.class}, message = "商品名称不能为空")
    private String goodName;

    @NotBlank(groups = {Create.class}, message = "商品描述不能为空")
    private String goodDesc;

    /** 商品状态：0 表示非新品，1 表示新品 */
    private Integer goodStatus;

    @Valid
    @NotNull(groups = {Create.class}, message = "商品分类不能为空")
    private GoodCategory goodCategory;

    private String goodThumb;

    private List<Picture> pictureList;
}
