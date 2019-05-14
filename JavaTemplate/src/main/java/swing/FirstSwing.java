package swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class FirstSwing extends JFrame {

	private JPanel contentPane;

	private Map<String,Object> memMap = new HashMap<String,Object>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstSwing frame = new FirstSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstSwing() {
		setFont(new Font("宋体", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 642, 436);
		contentPane.add(tabbedPane);
		
		final JPanel panelA = new JPanel();
		tabbedPane.addTab("面板A", null, panelA, null);
		panelA.setLayout(null);
		
		JButton btnNewButton = new JButton("测试弹出框");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopupDialog.popuptest();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		//文件选择框
			final JFileChooser fileChooser = new JFileChooser();
			fileChooser.setBorder(new LineBorder(new Color(0, 0, 0)));
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fileChooser.setMultiSelectionEnabled(true);
			fileChooser.setDialogType(JFileChooser.APPROVE_OPTION);	
			fileChooser.setBounds(114, 53, 509, 316);
			fileChooser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
						//点击了打开
						
						panelA.remove(fileChooser);
					}else if(e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
						//点击了取消
						panelA.remove(fileChooser);
					}
				}
			});
			panelA.add(fileChooser);
			
			
		btnNewButton.setBounds(134, 13, 113, 27);
		panelA.add(btnNewButton);
			
		JLabel label = new JLabel("文件：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(74, 58, 61, 27);
		panelA.add(label);
		
		JButton button = new JButton("运行");
		button.setBounds(501, 58, 77, 27);
		panelA.add(button);
			
		JTextPane textPane = new JTextPane();
		textPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//调出文件选择框

			}
		});
		textPane.setForeground(new Color(0, 0, 0));
		textPane.setBounds(134, 61, 342, 24);
		panelA.add(textPane);
		
		
		JPanel panelB = new JPanel();
		tabbedPane.addTab("面板B", null, panelB, null);
		panelB.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(51, 52, 192, 24);
		panelB.add(comboBox);
		
		JPanel panelC = new JPanel();
		tabbedPane.addTab("面板C", null, panelC, null);
		panelC.setLayout(null);
		
		JLabel lblCcccc = new JLabel("CCCCC");
		lblCcccc.setBounds(298, 5, 40, 18);
		panelC.add(lblCcccc);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
