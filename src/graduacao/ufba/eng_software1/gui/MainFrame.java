package graduacao.ufba.eng_software1.gui;

import graduacao.ufba.eng_software1.bd.BancoDados;
import graduacao.ufba.eng_software1.utils.Arquivo;
import graduacao.ufba.eng_software1.utils.Config;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	JDesktopPane desktop;
	private static MainFrame instance;
	private Arquivo log;

	public static MainFrame getInstance() {
		if (instance == null)
			instance = new MainFrame();

		return instance;
	}

	/**
	 * Create the application.
	 */
	private MainFrame() {
		super(".:Biblioteca:.");

		try {
			log = new Arquivo("log.err");
		} catch (Exception e) {
		}

		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height
				- inset * 2);

		desktop = new JDesktopPane();
		setContentPane(desktop);
		setJMenuBar(createMenuBarFile());

		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
	}

	protected JMenuBar createMenuBarFile() {
		JMenuBar menuBar = new JMenuBar();
		JMenuItem menuItem;
		JMenu menu;
		
		menu = new JMenu("Arquivo");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		// Set up the first menu item.
		menuItem = new JMenuItem("Login...");
		menuItem.setMnemonic(KeyEvent.VK_L);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("LOGIN");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Sair...");
		menuItem.setMnemonic(KeyEvent.VK_Q);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("EXIT");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		
		//------------ Ajuda
		
		menu = new JMenu("Ajuda");
		menu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menu);
		
		
		menuItem = new JMenuItem("Sobre...");
		menuItem.setMnemonic(KeyEvent.VK_H);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuItem.setActionCommand("ABOUT");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ABOUT":
			createFrame(e.getActionCommand());
			break;
		case "LOGIN":
			createFrame(e.getActionCommand());
			break;
		case "EXIT":
			quit();
			break;
		default:
			break;
		}
	}

	protected void createFrame(String asFrame) {
		JInternalFrame frame = null;
		switch (asFrame) {
		case "ABOUT":
			frame = About.getInstance();
			break;
		case "LOGIN":
			frame = Login.getInstance();
			((Login)frame).setPMainFrame(this);
			break;
		default:
			log("Falha ao chamar a função 'CreateFrame' com o valor "+asFrame);
			return;
		}
		
		 if(!containsOnArray(desktop.getComponents(), frame)){
			 Dimension desktopSize = desktop.getSize();
			 Dimension jInternalFrameSize = frame.getSize();
			 frame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			     (desktopSize.height- jInternalFrameSize.height)/2);
			 desktop.add(frame);
			 frame.setVisible(true);
		 }
	}

	protected void quit() {
		System.exit(0);
	}
	
	private boolean containsOnArray(Object[] aoArray, Object aoElement ){
		for(int i = 0;i < aoArray.length;i++)
			if(aoArray[i]==aoElement)
				return true;
		return false;
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {

		MainFrame frame = MainFrame.getInstance();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void showMessage(String message){
		JOptionPane.showMessageDialog(null, message);
	}
	
	public boolean executeQuery(String sql){
		BancoDados.getInstance();
		return true;
	}

	public void log(String message) {
		if (Config.LOG)
			try {
				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				log.salvar(dateFormat.format(date) + " -> " + message);
			} catch (Exception e) {
			}
	}

}
