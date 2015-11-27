import java.awt.Color;
import java.awt.Graphics;

public class Barre extends Element {

	double nextX = r.nextInt(340);

	public Barre(double x, double y) {
		this.x = x;
		this.y = y;
		tailleX = 60;
		tailleY = 20;
		couleur = Color.green;

		updateHitbox();
	}

	public void paintComponent(Graphics g) {
		g.setColor(couleur);
		g.fillRoundRect((int) x, (int) y, tailleX, tailleY, 20, 20);
		g.setColor(Color.black);
		g.drawRoundRect((int) x, (int) y, tailleX, tailleY, 20, 20);
		if (y + tailleY > 600) {
			g.setColor(couleur);
			g.fillRoundRect((int) nextX, 0, tailleX, (int) y + tailleY - 600, 20, 20);
			g.setColor(Color.black);
			g.drawRoundRect((int) nextX, 0, tailleX, (int) y + tailleY - 600, 20, 20);
			if (y > 600) {
				y = 0;
				x = nextX;
				nextX = r.nextInt(340);
			}
		}

		if (x + tailleX > 400) {
			g.setColor(couleur);
			g.fillRoundRect(0, (int) y, (int) x + tailleX - 400, tailleY, 20, 20);
			g.setColor(Color.black);
			g.drawRoundRect(0, (int) y, (int) x + tailleX - 400, tailleY, 20, 20);
			if (x > 400)
				x = 0;
		} else if (x < 0) {
			g.setColor(couleur);
			g.fillRoundRect((400 - (int) (-x)), (int) y, (int) (-x), tailleY, 20, 20);
			g.setColor(Color.black);
			g.drawRoundRect((400 - (int) (-x)), (int) y, (int) (-x), tailleY, 20, 20);
			if (x < 0 - tailleX)
				x = 400 - tailleX;
		}
	}

}
