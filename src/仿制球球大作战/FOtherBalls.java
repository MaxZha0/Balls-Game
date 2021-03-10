package 仿制球球大作战;

import java.awt.Color;

import javax.swing.JOptionPane;

public class FOtherBalls extends Thread{
	private FGameBody gb;
	public int xspeed=1;
	public int yspeed=1;
	public int x=800;
	public int y=300;
	public int width=100;
	public Color color=Color.black;
	public boolean isbegin=true;
	public boolean restart=false;
	int i;
	
	public  FOtherBalls(FGameBody a,int i) {
		this.gb = a;
	}
	
	public void run() {	
		
		while(!gb.isover) {
			while(isbegin) {
				if(this.width>gb.myball.width) {//敌方球大的情况
					if(this.x>=gb.myball.x) {
						this.x-=xspeed;
					}
					else this.x+=xspeed;
				
					if(this.y>=gb.myball.y) {
						this.y-=yspeed;
					}
					else this.y+=yspeed;
				}
				else {                        //敌方球小的情况
					if(this.x>=gb.myball.x) {
						this.x+=xspeed;
					}
					else this.x-=xspeed;
				
					if(this.y>=gb.myball.y) {
						this.y+=yspeed;
					}
					else this.y-=yspeed;
				}
			
			//设定小球的速度，分正负
				if(xspeed>0) {
					this.xspeed =(FGameBody.choice*5) - width / 30;
				}
				if(xspeed<0) {
					this.xspeed =-(FGameBody.choice*5) + width / 30;
				}
				if(yspeed>0) {
					this.yspeed =(FGameBody.choice*5) - width / 30;
				}
				if(yspeed<0) {
					this.yspeed =-(FGameBody.choice*5) + width / 30;
				}
			
				//判断敌方x出界，改变速度方向
				if(this.x > 1600 - this.width / 2||this.x<30) {
					if(xspeed*yspeed<0) {
						this.yspeed*=-1;
					}
					this.xspeed*=-1;
				}
				//判断敌方y出界
				if(this.y > 850 - this.width / 2||this.y<30) {
					if(xspeed*yspeed<0) {
						this.xspeed*=-1;
					}
					this.yspeed*=-1;
				}
			
			//判断我方出界
				if(gb.myball.x>=1600) {
					gb.myball.x=1600;
				}
				if(gb.myball.y>=900) {
					gb.myball.y=900;
				}
				if(gb.myball.x<=0) {
					gb.myball.x=0;
				}
				if(gb.myball.y<=0) {
					gb.myball.y=0;
				}
				ishit();
				gb.repaint();
			
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
			try {       //？？？？？？？？？？？？？？？影响中断后重启？？
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void ishit() { //平方和求距离

		int x0 = (this.x - gb.myball.x ) * (this.x - gb.myball.x );
		int y0 = (this.y-gb.myball.y) * (this.y-gb.myball.y);
		int r = (int) Math.sqrt(x0 + y0);
		
		if(r<=this.width/2+gb.myball.width/2) {   //相撞的条件
			if(this.width>=gb.myball.width) {   //如果敌方小球更大
				
				if(gb.health==0) {               //失败条件:没命
					gb.isover=true;
					for (int i = 0; i < gb.balllist.size(); i++) {   //通关后停止所有球
						gb.balllist.get(i).isbegin=false;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
					//消失后等待1秒
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					Object[] options2= {"退出","返回"};
					int m2 = JOptionPane.showOptionDialog(null,"很遗憾你失败了！最终得分:"+gb.myball.width ,
							"球球大作战", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options2, options2[1]);
					if(m2==1) {
						gb.dispose();
						new FWelcome();
					}
					else {
						System.exit(0);
					}
				}
				
				
				for (int i = 0; i < gb.balllist.size(); i++) {      //如果有命
					gb.balllist.get(i).isbegin=false;
				}
				Object[] options= {"退出","再来一次"};
				int m = JOptionPane.showOptionDialog(null,"你被大球吃掉啦！得分:"+gb.myball.width+"\n      剩余生命:"+gb.health ,
						"球球大作战", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(m==1) {
					gb.health--;
					System.out.println(gb.health);
					for (int i = 0; i < gb.balllist.size(); i++) {
						gb.balllist.get(i).isbegin=true;
					}
				}	
				else {
					System.exit(0);
				}
	
			
		}
			if(this.width<gb.myball.width) {     //如果我方球大
				gb.myball.width+=2;          //吃掉一个球大小就增大一些
				this.isbegin=false;
				gb.balllist.remove(this);     //数组中去掉这个球
				
				if(gb.myball.width==130) {               //通关条件
					gb.isover=true;
					for (int i = 0; i < gb.balllist.size(); i++) {   //通关后停止所有球
						gb.balllist.get(i).isbegin=false;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					gb.balllist.clear();                       //再清除所有球
					
					//消失后等待1秒
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					Object[] options= {"退出","返回"};
					int m = JOptionPane.showOptionDialog(null,"恭喜你通关了！最终得分:"+gb.myball.width ,
							"球球大作战", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
					if(m==1) {
						gb.dispose();
						new FWelcome();
					}
					else {
						System.exit(0);
					}
				}
				
				
			}
	}
	
	}
	
}
