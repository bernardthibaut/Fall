import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Fenetre {

	JFrame f = new JFrame("Fall");
	Jeu jeu = new Jeu();

	boolean gauchePressed = false;
	boolean droitePressed = false;

	public Fenetre() {
		f.setPreferredSize(new Dimension(400, 600));
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);

		f.setBackground(Color.white);
		f.setContentPane(jeu);

		f.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_ESCAPE)
					System.exit(1);

				if (key == KeyEvent.VK_Q || key == KeyEvent.VK_LEFT) {
					gauchePressed = true;
					jeu.vitesseX = -2.0;
				}

				if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					droitePressed = true;
					jeu.vitesseX = 2.0;
				}
			}

			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_Q || key == KeyEvent.VK_LEFT) {
					gauchePressed = false;
				}

				if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					droitePressed = false;
				}

				if (!gauchePressed && !droitePressed)
					jeu.vitesseX = 0.0;
			}

		});

		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Fenetre();
	}

}
