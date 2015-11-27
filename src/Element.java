import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class Element {

	Random r = new Random();
	
	double x;
	double y;
	int tailleX;
	int tailleY;

	Color couleur;

	Rectangle hitbox;

	public void updateHitbox() {
		hitbox = new Rectangle((int) x, (int) y, tailleX, tailleY);
	}

}
