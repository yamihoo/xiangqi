package com.zy.xiangqi.entity;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class User {
	//主键及记录
	private Integer id;//id
	private String name;//昵称
	private String pwd;//密码
	private String imgpath;//头像路径
	private Integer level;//等级
	private Integer height;//段位
	private String role;//角色 user admin tourist游客
	private Boolean activity;//该账号邮箱是否已被验证/激活
	private Date createtime;//创建账户日期
	private String email;//邮箱
	private Integer charm;//魅力值
	private Integer coin;//金币
	private String city;//所在城市
	
	//外键
	private List<Record> records;//对战记录
	private List<User> friends;//好友列表
	private Map<Prop,Integer> props;//拥有的道具及其数量
	
}
