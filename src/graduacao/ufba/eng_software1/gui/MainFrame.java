package graduacao.ufba.eng_software1.gui;

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_D);
		menuBar.add(menu);

		// Set up the first menu item.
		JMenuItem menuItem;
		menuItem = new JMenuItem("About...");
		menuItem.setMnemonic(KeyEvent.VK_H);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuItem.setActionCommand("ABOUT");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Exit...");
		menuItem.setMnemonic(KeyEvent.VK_Q);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("EXIT");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ABOUT":
			createFrameAbout();
			break;

		case "EXIT":
			quit();
			break;
		default:
			break;
		}
	}

	protected void createFrameAbout() {
		// About frame = About.getInstance();
		// frame.setVisible(true);
	}

	protected void quit() {
		System.exit(0);
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

	public void log(String message) {
		if (Config.log)
			try {
				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				log.salvar(dateFormat.format(date) + " -> " + message);
			} catch (Exception e) {
			}
	}

}
