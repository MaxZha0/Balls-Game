package �����������ս;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class FMouseListener implements MouseMotionListener{
	 
	 public FMyBall myball;
	 
	 public FMouseListener(FMyBall a) {         //���캯�������ҷ�С�����
		this.myball=a;
	 }
	 public void mouseDragged(MouseEvent e) {
	 }

	 public void mouseMoved(MouseEvent e) {        //����ƶ��ı���������ֵ
		myball.x=e.getX();
		myball.y=e.getY();
	 }
	
	
	
}