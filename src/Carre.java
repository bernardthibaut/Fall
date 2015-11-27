import java.awt.Color;
import java.awt.Graphics;

public class Carre extends Element {

	double gravite = -1;

	public Carre(double x, double y) {
		this.x = x;
		this.y = y;
		tailleX = 35;
		tailleY = 35;
		couleur = Color.red;

		updateHitbox();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(couleur);
		g.fillRect((int) x, (int) y, tailleX, tailleY);
		g.setColor(Color.black);
		g.drawRect((int) x, (int) y, tailleX, tailleY);
		
		/*
		 * if (y + tailleY > 600) { g.setColor(couleur); g.fillRect((int) x, 0,
		 * tailleX, (int) y + tailleY - 600); g.setColor(Color.black);
		 * g.drawRect((int) x, 0, tailleX, (int) y + tailleY - 600); if (y >
		 * 600){ y = 0; } } else if (y < 0) { g.setColor(couleur);
		 * g.fillRect((int) x, 600 - (int) (-y), tailleX, (int) (-y));
		 * g.setColor(Color.black); g.drawRect((int) x, 600 - (int) (-y),
		 * tailleX, (int) (-y)); if (y < 0 - tailleY) y = 600 - tailleY; }
		 * 
		 */

		if (x + tailleX > 400) {
			g.setColor(couleur);
			g.fillRect(0, (int) y, (int) x + tailleX - 400, tailleY);
			g.setColor(Color.black);
			g.drawRect(0, (int) y, (int) x + tailleX - 400, tailleY);
			if (x > 400)
				x = 0;
		} else if (x < 0) {
			g.setColor(couleur);
			g.fillRect((400 - (int) (-x)), (int) y, (int) (-x), tailleY);
			g.setColor(Color.black);
			g.drawRect((400 - (int) (-x)), (int) y, (int) (-x), tailleY);
			if (x < 0 - tailleX)
				x = 400 - tailleX;
		}
	}

}
