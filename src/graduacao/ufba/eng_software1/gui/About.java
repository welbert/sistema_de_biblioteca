package graduacao.ufba.eng_software1.gui;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import graduacao.ufba.eng_software1.utils.Config;
import javax.swing.border.LineBorder;
import java.awt.Color;


@SuppressWarnings("serial")
public class About extends JInternalFrame {
	private static About instance;

	public static About getInstance(){
		if(instance==null)
			instance = new About();
		
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public About() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setClosable(true);
		setTitle("Sobre");
		setBounds(100, 100, (int) Math.round(230+Config.URL_REPOSITORY.length()*1.8), 186);
		
		JLabel lblSistemaDeBiblioteca = new JLabel("Sistema de Biblioteca");
		
		JLabel lblVerso = new JLabel("Vers\u00E3o "+Config.VERSION);
		
		JLabel lblDesenvolvidoPorMayara = new JLabel("Desenvolvido por Mayara e Welbert");
		
		JLabel lblRepositorio = new JLabel(Config.URL_REPOSITORY);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRepositorio)
						.addComponent(lblDesenvolvidoPorMayara)
						.addComponent(lblVerso)
						.addComponent(lblSistemaDeBiblioteca))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(66, Short.MAX_VALUE)
					.addComponent(lblSistemaDeBiblioteca)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblVerso)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDesenvolvidoPorMayara)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblRepositorio)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
