package �����������ս;

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
				if(this.width>gb.myball.width) {//�з��������
					if(this.x>=gb.myball.x) {
						this.x-=xspeed;
					}
					else this.x+=xspeed;
				
					if(this.y>=gb.myball.y) {
						this.y-=yspeed;
					}
					else this.y+=yspeed;
				}
				else {                        //�з���С�����
					if(this.x>=gb.myball.x) {
						this.x+=xspeed;
					}
					else this.x-=xspeed;
				
					if(this.y>=gb.myball.y) {
						this.y+=yspeed;
					}
					else this.y-=yspeed;
				}
			
			//�趨С����ٶȣ�������
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
			
				//�жϵз�x���磬�ı��ٶȷ���
				if(this.x > 1600 - this.width / 2||this.x<30) {
					if(xspeed*yspeed<0) {
						this.yspeed*=-1;
					}
					this.xspeed*=-1;
				}
				//�жϵз�y����
				if(this.y > 850 - this.width / 2||this.y<30) {
					if(xspeed*yspeed<0) {
						this.xspeed*=-1;
					}
					this.yspeed*=-1;
				}
			
			//�ж��ҷ�����
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
			try {       //������������������������������Ӱ���жϺ���������
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void ishit() { //ƽ���������

		int x0 = (this.x - gb.myball.x ) * (this.x - gb.myball.x );
		int y0 = (this.y-gb.myball.y) * (this.y-gb.myball.y);
		int r = (int) Math.sqrt(x0 + y0);
		
		if(r<=this.width/2+gb.myball.width/2) {   //��ײ������
			if(this.width>=gb.myball.width) {   //����з�С�����
				
				if(gb.health==0) {               //ʧ������:û��
					gb.isover=true;
					for (int i = 0; i < gb.balllist.size(); i++) {   //ͨ�غ�ֹͣ������
						gb.balllist.get(i).isbegin=false;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
					//��ʧ��ȴ�1��
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					Object[] options2= {"�˳�","����"};
					int m2 = JOptionPane.showOptionDialog(null,"���ź���ʧ���ˣ����յ÷�:"+gb.myball.width ,
							"�������ս", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options2, options2[1]);
					if(m2==1) {
						gb.dispose();
						new FWelcome();
					}
					else {
						System.exit(0);
					}
				}
				
				
				for (int i = 0; i < gb.balllist.size(); i++) {      //�������
					gb.balllist.get(i).isbegin=false;
				}
				Object[] options= {"�˳�","����һ��"};
				int m = JOptionPane.showOptionDialog(null,"�㱻����Ե������÷�:"+gb.myball.width+"\n      ʣ������:"+gb.health ,
						"�������ս", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
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
			if(this.width<gb.myball.width) {     //����ҷ����
				gb.myball.width+=2;          //�Ե�һ�����С������һЩ
				this.isbegin=false;
				gb.balllist.remove(this);     //������ȥ�������
				
				if(gb.myball.width==130) {               //ͨ������
					gb.isover=true;
					for (int i = 0; i < gb.balllist.size(); i++) {   //ͨ�غ�ֹͣ������
						gb.balllist.get(i).isbegin=false;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					gb.balllist.clear();                       //�����������
					
					//��ʧ��ȴ�1��
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					Object[] options= {"�˳�","����"};
					int m = JOptionPane.showOptionDialog(null,"��ϲ��ͨ���ˣ����յ÷�:"+gb.myball.width ,
							"�������ս", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
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
