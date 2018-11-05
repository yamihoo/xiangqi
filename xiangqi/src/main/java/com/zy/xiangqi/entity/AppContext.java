package com.zy.xiangqi.entity;

import java.util.Date;
import java.util.List;

/**
 * 应用中心
 * @author ZhangYan
 *
 */
public final class AppContext {
	private Date starttiem;//服务器启动时间
	private List<User> online;//所有在线用户
	private List<Room> rooms;//所有房间列表
	
	private List<Activitys> activitys;//当前活动
	private List<News> news;//新闻/公告
	
	private List<User> level;//等级排行榜
	private List<User> height;//段位排行榜
	private List<User> charm;//魅力排行榜
}
