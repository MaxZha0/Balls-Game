package �����������ս;
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
	public int choise;                         //�ñ������治ͬ�Ѷȵ��ٶ�ֵ
	
	public FChoose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb = new JLabel("����ѡ���ʵ����Ѷȣ�");
		lb.setFont(new Font("����", Font.PLAIN, 25));
		lb.setBounds(52, 59, 331, 47);
		contentPane.add(lb);
		
		JButton bt0 = new JButton("��");
		bt0.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FGameBody.choice=1;
				new FGameBody();
			}
		});
		bt0.setBounds(30, 178, 113, 27);
		contentPane.add(bt0);
		
		JButton bt1 = new JButton("����");
		bt1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FGameBody.choice=2;
				new FGameBody();
			}
		});
		bt1.setBounds(157, 178, 113, 27);
		contentPane.add(bt1);
		
		JButton bt2 = new JButton("����");
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
