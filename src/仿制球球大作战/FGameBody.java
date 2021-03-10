package 仿制球球大作战;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FGameBody extends JFrame {

	private static final long serialVersionUID = 1L;
	public FMyBall myball;
	public FMouseListener mouselistener;
	public JPanel mainpanel;
	public boolean isover=false;
	public ArrayList<FOtherBalls> balllist=new ArrayList<FOtherBalls>();//敌方小球
	public static int choice=1;
	public Random random= new Random();
	public FGameBody gb;
	public int health=4;
	public JPanel contentPane;
	String s1;
	String s2;

	public static void main(String[] args) {
		new FGameBody();
	}

	public FGameBody() {
		
	
		
		gb=this;
		myball=new FMyBall(200, 200, 50);
		mouselistener=new FMouseListener(myball);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		setResizable(false);
		setTitle("球球大作战");
		mainpanel=new JPanel();
		mainpanel.addMouseMotionListener(mouselistener);
		Container a=getContentPane();
		a.add(mainpanel);
		mainpanel.setLayout(null);
	
		CheckBall();
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		
		Image bi = this.createImage(1600, 900);// 创建一张图片
		Graphics buffg = bi.getGraphics();// 拿到这张图片的画笔
		buffg.setColor(Color.YELLOW);
		buffg.fillOval(myball.x-myball.width/2, myball.y+30-myball.width/2, myball.width, myball.width);  //添加我方小球
		
		for (int i = 0; i < balllist.size(); i++) {
			FOtherBalls oball=balllist.get(i);
			buffg.setColor(oball.color);
			buffg.fillOval(oball.x-oball.width/2, oball.y+30-oball.width/2, oball.width, oball.width);  //循环添加敌方小球
		}

		repaint();
		
		g.drawImage(bi, 0, 0, null);// 利用窗体的画笔将整张图片画进窗体
		
//		g.drawString(s1, 50, 50);   //尝试显示分数
	
	}
	
	public void CheckBall() {
		new Thread() {
			public void run() {
				while(!isover) {
					if(balllist.size()==0) {
						for (int i = 0; i < 12; i++) {
							FOtherBalls oball=new FOtherBalls(gb,i);
//							oball.color=new Color(random.nextInt(10));
							oball.color=new Color(random.nextInt(200),random.nextInt(50),random.nextInt(150));
							oball.x=random.nextInt(1200)+200;
							oball.y=random.nextInt(500)+200;
							oball.width=myball.width-20+3*i;
							oball.start();
							balllist.add(oball);
						}
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
	}
}


//class showpanel extends JPanel{
//
//	private static final long serialVersionUID = 1L;
//	private JTextField text1;
//	private JTextField text2;
//	public FGameBody gb;
////	private String s1=Integer.toString(FMyBall.width);
////	private String s2=Integer.toString(gb.health);
//	
//	
//	public showpanel(FGameBody a,String s1,String s2) {
//		this.gb=a;
//		setLayout(null);
//		
//		JLabel lb1 = new JLabel("分数");
//		lb1.setFont(new Font("宋体", Font.PLAIN, 20));
//		lb1.setBounds(0, 0, 50, 27);
//		add(lb1);
//		
//		JLabel lb2 = new JLabel("生命");
//		lb2.setFont(new Font("宋体", Font.PLAIN, 20));
//		lb2.setBounds(0, 36, 50, 27);
//		add(lb2);
//		
//		text1 = new JTextField();
//		text1.setFont(new Font("宋体", Font.PLAIN, 20));
//		text1.setBounds(51, 1, 86, 24);
//		add(text1);
//		text1.setColumns(10);
//		
//		text2 = new JTextField();
//		text2.setFont(new Font("宋体", Font.PLAIN, 20));
//		text2.setBounds(51, 37, 86, 24);
//		add(text2);
//		text2.setColumns(10);
//		
//		text1.setText(s1);
//		text2.setText(s2);
//		setVisible(true);
//
//	}
//
//}
