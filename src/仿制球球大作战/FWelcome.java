package 仿制球球大作战;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FWelcome extends JFrame {           //欢迎界面
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public FWelcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 560, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("开始游戏");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new FChoose();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(209, 208, 125, 44);
		contentPane.add(btnNewButton);
		JLabel lb = new JLabel("New label");           //添加开始界面图片
		lb.setBounds(0, 0, 542, 303);
		ImageIcon Welcome=new ImageIcon("Welcome.jpg");
		lb.setIcon(Welcome);
		
		contentPane.add(lb);
		setVisible(true);
	}
	
	public static void main(String args[]){
		new FWelcome();
	}
}
