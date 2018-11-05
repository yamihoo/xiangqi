package com.zy.xiangqi.entity;

/**
 * 棋盘
 * @author ZhangYan
 *
 */
public class Checkerboard {

	private Piece[][] pieces;//保存棋子各个位置
	private Integer count;//游戏回合
	private GameRole current;//该哪方走棋
	
	//初始化棋盘
	public void init() {
		
	}
	
	class Piece{//棋子类 内部类
		private String name;//棋子名称
		private GameRole role;//棋子阵营
		private Integer x;
		private Integer y;
		private Boolean focus=false;//是否被选中
	}
}
