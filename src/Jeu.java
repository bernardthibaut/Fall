import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Jeu extends JPanel {

	Random r = new Random();

	Carre carre;
	ArrayList<Barre> barres = new ArrayList<>();

	double acceleration = 0.2;

	double vitesseX = 0.0;

	Image background = new ImageIcon("res/background.png").getImage();

	public Jeu() {
		carre = new Carre(175, 0);

		for (int i = 0; i < 5; i++) {
			Barre b = new Barre(r.nextInt(340), 550 - (r.nextInt(50) + i * 140));
			barres.add(b);
		}

		chute();
	}

	int fini = 0;

	public void paint(Graphics g) {

		g.drawImage(background, 0, 0, null);

		if (fini == 0) {
			carre.paintComponent(g);
			for (Barre barre : barres)
				barre.paintComponent(g);

			g.setFont(new Font("arial", 0, 20));
			g.drawString("G = " + ((int) (carre.gravite * 100) / 100.0), 10, 40);
		} else if (fini == 1) {
			g.setFont(new Font("arial", 0, 40));
			g.drawString("GAGNE !", 100, 150);
		} else if (fini == -1) {
			g.setFont(new Font("arial", 0, 40));
			g.drawString("PERDU !", 100, 150);
		}
	}

	public void chute() {

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {

			public void run() {

				carre.x += vitesseX;
				carre.y += carre.gravite;
				carre.gravite += acceleration;
				carre.updateHitbox();

				for (Barre barre : barres) {
					barre.y += 2;
					barre.updateHitbox();
					if (carre.hitbox.intersects(barre.hitbox) && carre.gravite > 0
							&& carre.y < barre.y - carre.tailleY + carre.gravite * 2) {
						carre.y = barre.y - carre.tailleY - 1;
						carre.gravite = -(7 + carre.gravite / 5.0);
					}
				}

				if (carre.y <= 0 - carre.tailleY) {
					this.cancel();
					fini = 1;
					repaint();
				} else if (carre.y >= 600) {
					this.cancel();
					fini = -1;
					repaint();
				}

				repaint();

			}

		};

		timer.scheduleAtFixedRate(task, 0, 10);
	}

}
