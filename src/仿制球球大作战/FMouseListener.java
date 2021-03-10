package 仿制球球大作战;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class FMouseListener implements MouseMotionListener{
	 
	 public FMyBall myball;
	 
	 public FMouseListener(FMyBall a) {         //构造函数传入我方小球对象
		this.myball=a;
	 }
	 public void mouseDragged(MouseEvent e) {
	 }

	 public void mouseMoved(MouseEvent e) {        //鼠标移动改变对象的属性值
		myball.x=e.getX();
		myball.y=e.getY();
	 }
	
	
	
}