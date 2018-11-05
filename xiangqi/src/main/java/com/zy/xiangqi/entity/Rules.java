package com.zy.xiangqi.entity;

import com.zy.xiangqi.entity.Checkerboard.Piece;

/**
 * 游戏规则类
 * @author ZhangYan
 * @version v1.0.0
 * @data 2017-4-23
 */
public class Rules {
	private Piece[][] qizi;//声明棋子数组
	private boolean canMove=false;//是否可以移动
	private int i;
	private int j;
	public Rules(Piece[][] qizi){
		this.qizi=qizi;
	}
	/**
	 * 判断棋子是否可以移动
	 * @param startI 初始的x轴位置
	 * @param startJ 初始的Y轴位置
	 * @param endI 要移动的X轴位置
	 * @param endJ 要移动的Y轴位置
	 * @param name 棋子的姓名
	 * @return 用于判断是否可以走棋
	 */
	public boolean canMove(int startI,int startJ,int endI,int endJ,String name){
		int maxI;//一些辅助变量
		int minI;
		int maxJ;
		int minJ;
		canMove=true;
		if(startI>=endI){//确定其坐标的大小关系
			maxI=startI;
			minI=endI;
		}else{
			maxI=endI;
			minI=startI;
		}
		if(startJ>=endJ){
			maxJ=startJ;
			minJ=endJ;
		}else{
			maxJ=endJ;
			minJ=startJ;
		}
		if(name.equals("車")){
			this.ju(maxI,minI,maxJ,minJ);
		}else if(name.equals("馬")){
			this.ma(maxI,minI,maxJ,minJ,startI,startJ,endI,endJ);
		}else if(name.equals("相")){
			this.xiangR(maxI,minI,maxJ,minJ,startI,startJ,endI,endJ);
		}else if(name.equals("象")){
			this.xiangW(maxI,minI,maxJ,minJ,startI,startJ,endI,endJ);
		}else if(name.equals("士")||name.equals("仕")){
			this.shi(maxI,minI,maxJ,minJ,startI,startJ,endI,endJ);
		}else if(name.equals("帥")||name.equals("將")){
			this.jiang(maxI,minI,maxJ,minJ,startI,startJ,endI,endJ);
		}else if(name.equals("炮")||name.equals("砲")){
			this.pao(maxI,minI,maxJ,minJ,startI,startJ,endI,endJ);
		}else if(name.equals("兵")){
			this.bing(maxI,minI,maxJ,minJ,startI,startJ,endI,endJ);
		}else if(name.equals("卒")){
			this.zu(maxI,minI,maxJ,minJ,startI,startJ,endI,endJ);
		}
		return canMove;
	}
	public void ju(int maxI,int minI,int maxJ,int minJ){
		if(maxI==minI){//如果在一条横线上
			for(j=minJ+1;j<maxJ;j++){
				if(qizi[maxI][j]!=null){//如果中间有棋子
					canMove = false;//不可以走棋
					break;
				}
			}
		}else if(maxJ==minJ){//如果在一条竖线上
			for(i=minJ+1;i<maxJ;i++){
				if(qizi[i][maxJ]!=null){//如果中间有棋子
					canMove=false;
					break;
				}
			}
		}else if(maxI!=minI&&maxJ!=minJ){
			canMove=false;//不可以走棋
		}
	}
	private void ma(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ) {
		int a=maxI-minI;
		int b=maxJ-minJ;//获得两坐标之间的差
		if(a==1&&b==2){//如果是竖着的"日"字
			if(startJ>endJ){//如果是从下向上走
				if(qizi[startI][startJ-1]!=null){//如果马腿处有棋子
					canMove = false;
				}
			}else{//如果从上往下走
				if(qizi[startI][startJ+1]!=null){//如果马腿处有棋子
					canMove = false;
				}
			}
		}else if(a==2&&b==1){//如果是横着走"日"字
			if(startI>endI){//如果是从右往左走
				if(qizi[startI-1][startJ]!=null){
					canMove = false;
				}
			}else{//如果是从左往右走
				if(qizi[startI+1][startJ]!=null){
					canMove = false;
				}
			}
		}else if(!((a==2&&b==1)||(a==1&&b==2))){//如果不是走日字
			canMove = false;
		}
	}
	private void xiangR(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ) {
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==2&&b==2){//如果走的是"田"字
			if(endJ>4){//如果过河了
				canMove = false;
			}
			if(qizi[(maxI+minI)/2][(maxJ+minJ)/2]!=null){//如果"田"字中间有棋子
				canMove = false;
			}
		}else{
			canMove = false;
		}
	}
	private void xiangW(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ) {
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==2&&b==2){//如果走的是"田"字
			if(endJ<5){//如果过河了
				canMove = false;
			}
			if(qizi[(maxI+minI)/2][(maxJ+minJ)/2]!=null){//如果"田"字中间有棋子
				canMove = false;
			}
		}else{
			canMove = false;
		}
	}
	private void shi(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ) {
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==1&&b==1){//如果是小斜线
			if(startJ>4){//如果是下方的士
				if(endJ<7){//如果下方的士越界
					canMove = false;
				}
			}else{//如果是上方的仕
				if(endJ>2){//如果上方的仕越界
					canMove = false;
				}
			}
			if(endI>5||endI<3){//如果左右越界
				canMove = false;
			}
		}else{//如果不是小斜线
			canMove = false;
		}
	}
	private void jiang(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ) {
		int a=maxI-minI;
		int b=maxJ-minJ;
		if((a==1&&b==0)||(a==0&&b==1)){//如果走一小格
			if(startJ>4){//如果是下方的將
				if(endJ<7){//如果越界
					canMove = false;
				}
			}else{//如果是上方的将
				if(endJ>2){//如果越界
					canMove = false;
				}
			}
			if(endI>5||endI<3){//如果左右越界,不可以走
				canMove = false;
			}
		}else{//如果走的不是一小格
			canMove = false;
		}
	}
	private void pao(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ) {
		if(maxI==minI){//如果走的竖线
			if(qizi[endI][endJ]!=null){//如果终点有棋子
				int count=0;
				for(j=minJ+1;j<maxJ;j++){
					if(qizi[minI][j]!=null){//判断起点与终点之间有几个棋子
						count++;
					}
				}
				if(count!=1){//如果不是一个棋子
					canMove = false;
				}
			}else if(qizi[endI][endJ]==null){//如果终点没有棋子
				for(j=minJ+1;j<maxJ;j++){
					if(qizi[minI][j]!=null){//如果起止点之间有棋子
						canMove = false;
						break;
					}
				}
			}
		}else if(maxJ==minJ){//如果走的是横线
			if(qizi[endI][endJ]!=null){//如果终点有棋子
				int count=0;
				for(i=minI+1;i<maxI;i++){
					if(qizi[i][minJ]!=null){//判断起点与终点之间有几个棋子
						count++;
					}
				}
				if(count!=1){//如果不是一个棋子
					canMove = false;
				}
			}else if(qizi[endI][endJ]==null){//如果终点没有棋子
				for(i=minI+1;i<maxI;i++){
					if(qizi[i][minJ]!=null){//如果起止点之间有棋子
						canMove = false;
						break;
					}
				}
			}
		}else if(maxJ!=minJ||maxI!=minI){//如果不是横线也不是竖线 就不能走
			canMove = false;
		}
	}
	private void bing(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ) {
		if(startJ<5){//如果还没有过河
			if(startI!=endI){//如果不是向前走
				canMove = false;
			}
			if(endJ-startJ!=1){//如果走的不是一格
				canMove = false;
			}
		}else{//如果已经过河
			if(startI==endI){//如果走的是竖线
				if(endJ-startJ!=1){//如果走的不是一格
					canMove = false;
				}
			}else if(startJ==endJ){//如果走的是横线
				if(maxI-minI!=1){//如果走的不是一格
					canMove = false;
				}
			}else if(startI!=endI&&startJ!=endJ){//如果走的不是横线也不是竖线
				canMove = false;
			}
		}
	}
	private void zu(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ) {
		if(startJ>4){//如果还没有过河
			if(startI!=endI){//如果不是向前走
				canMove = false;
			}
			if(endJ-startJ!=-1){//如果走的不是一格
				canMove = false;
			}
		}else{//如果已经过河
			if(startI==endI){//如果走的是竖线
				if(endJ-startJ!=-1){//如果走的不是一格
					canMove = false;
				}
			}else if(startJ==endJ){//如果走的是横线
				if(maxI-minI!=1){//如果走的不是一格
					canMove = false;
				}
			}else if(startI!=endI&&startJ!=endJ){//如果走的不是横线也不是竖线
				canMove = false;
			}
		}
	}
}