package com.odd.delicacy.entity.store;

import com.odd.delicacy.base.BaseEntity;
import com.odd.delicacy.valid.Create;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Potato
 * @Date: 2021/7/11 15:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store extends BaseEntity<Store> {



    /**
     * 店铺名称
     */
    @NotBlank(groups = {Create.class}, message = "商店名字不能为空")
    private String storeName;

    /**
     * 店铺营业时间
     */
    @NotBlank(groups = {Create.class}, message = "店铺营业时间不能为空")
    private String storeOpentime;

    /**
     *店铺地址
     */
    @NotBlank(groups = {Create.class}, message = "店铺地址不能为空")
    private String storeAddress;

    /**
     *店铺联系电话
     */
    @NotBlank(groups = {Create.class}, message = "店铺联系电话不能为空")
    private String storeTele;

    /**
     * 默认为0 ，0为正常显示状态 ，1为隐藏状态
     */
    private Integer isConceal;

}
