package snake;

import apcs.Window;

public class foooooood {
	int x, y, side = 10;
	
	public foooooood() {
		x = Window.rollDice(Window.width() - side) + side / 2 + 1;
		y = Window.rollDice(Window.height() - side) + side / 2 + 1;
	}
	
	public void draw() {
		Window.out.randomColor();
		Window.out.square(x, y, side);
	}
	
	public void checkIfSelfEaten() {
		x = Window.rollDice(Window.width() - side) + side / 2 + 1;
		y = Window.rollDice(Window.height() - side) + side / 2 + 1;
	}
}
