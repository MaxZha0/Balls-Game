package 仿制球球大作战;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FChoose extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int choise;                         //该变量保存不同难度的速度值
	
	public FChoose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb = new JLabel("请您选择适当的难度：");
		lb.setFont(new Font("宋体", Font.PLAIN, 25));
		lb.setBounds(52, 59, 331, 47);
		contentPane.add(lb);
		
		JButton bt0 = new JButton("简单");
		bt0.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FGameBody.choice=1;
				new FGameBody();
			}
		});
		bt0.setBounds(30, 178, 113, 27);
		contentPane.add(bt0);
		
		JButton bt1 = new JButton("困难");
		bt1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FGameBody.choice=2;
				new FGameBody();
			}
		});
		bt1.setBounds(157, 178, 113, 27);
		contentPane.add(bt1);
		
		JButton bt2 = new JButton("地狱");
		bt2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FGameBody.choice=3;
				new FGameBody();
			}
		});
		bt2.setBounds(284, 178, 113, 27);
		contentPane.add(bt2);
		setVisible(true);
	}

}
