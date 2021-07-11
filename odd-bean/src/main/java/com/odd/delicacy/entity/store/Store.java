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
    private String store_name;

    /**
     * 店铺营业时间
     */
    @NotBlank(groups = {Create.class}, message = "店铺营业时间不能为空")
    private String store_opentime;

    /**
     *店铺地址
     */
    @NotBlank(groups = {Create.class}, message = "店铺地址不能为空")
    private String store_address;

    /**
     *店铺联系电话
     */
    @NotBlank(groups = {Create.class}, message = "店铺联系电话不能为空")
    private String store_tele;

    /**
     * 默认为0 ，0为正常显示状态 ，1为隐藏状态
     */
    private Integer is_conceal;

    /**
     * 默认为0 ， 0为正常状态，1为删除状态
     */
    private Integer is_deleted;



}
