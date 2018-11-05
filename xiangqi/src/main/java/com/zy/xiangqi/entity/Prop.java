package com.zy.xiangqi.entity;

/**
 * 道具接口
 * @author ZhangYan
 *
 */
public interface Prop {
	public String getName();//道具名称
	public Double getPrice();//获取道具价格
	public String getType();//道具分类: 功能道具 礼品道具
}
