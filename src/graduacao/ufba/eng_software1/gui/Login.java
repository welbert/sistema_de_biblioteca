package graduacao.ufba.eng_software1.gui;

import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JInternalFrame {

	private static Login instance;
	private JTextField txfLogin;
	private JPasswordField txfPassword;
	private MainFrame PMainFrame;

	public static Login getInstance(){
		if(instance==null)
			instance = new Login();
		
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setClosable(true);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(100, 100, 237, 182);
		
		JLabel lblLogin = new JLabel("Usuário: ");
		
		JLabel lblPassword = new JLabel("Senha: ");
		
		txfLogin = new JTextField();
		txfLogin.setColumns(10);
		
		txfPassword = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PMainFrame.showMessage("Em Desenvolvimento...");
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addComponent(lblLogin))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txfLogin, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
								.addComponent(txfPassword, 101, 101, 101)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(btnLogin)
							.addPreferredGap(ComponentPlacement.RELATED, 64, GroupLayout.PREFERRED_SIZE)))
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(txfLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	public MainFrame getPMainFrame() {
		return PMainFrame;
	}

	public void setPMainFrame(MainFrame pMainFrame) {
		PMainFrame = pMainFrame;
	}
}
