package snake;

import apcs.Window;

public class game {

	public static void main(String[] args) {
		//Window.size(1366, 723);
		Window.size(800, 500);
		Window.setFrameRate(15);
		int score = 0;
		snake head = new snake();
		foooooood f = new foooooood();

		boolean menu = true;
		int color = 255, change = 0;

		while (true) {
			if (menu == false) {
				Window.out.background("black");
				for (int i = 0; i < Window.width() + 2; i += 11) {
					for (int j = 0; j < Window.width() + 1; j += 11) {
						Window.out.color(30,30,30);
						Window.out.square(i - 2, j - 3, 10);
					}

				}
				Window.out.color("white");
				Window.out.font("monospaced", 30);
				Window.out.print("Score: " + score, 10, 40);

				head.draw();
				head.changeDirection();
				head.move();

				f.draw();

				if (head.checkBoundaries()) {
					head = new snake();
					score = 0;
				}

				if (head.checkEatSelf(head)) {
					head = new snake();
					score = 0;
				}
				if (head.checkFood(f)) {
					head.grow();
					f.checkIfSelfEaten();
					score ++;
				}
			}
			else {

				Window.out.background("black");
				Window.out.color(0,color,0);
				Window.out.font("monospaced", 50);
				Window.out.print("SNAKE", Window.width() / 2 - 75, Window.height() / 2 - 100);
				Window.out.color("light gray");
				Window.out.rectangle(Window.width() / 2, Window.height() / 2, 200, 50);
				if (Window.mouse.getX() > Window.width() / 2 - 100 && Window.mouse.getX() < Window.width() / 2 + 100 && Window.mouse.getY() > Window.height() / 2 - 25 && Window.mouse.getY() < Window.height() / 2 + 25) {
					Window.out.color("gray");
					Window.out.rectangle(Window.width() / 2, Window.height() / 2, 200, 50);
					if (Window.mouse.clicked()) {
						menu = false;
					}
				}
				Window.out.color("black");
				Window.out.font("monospaced", 30);
				Window.out.print("play", Window.width() / 2 - 40, Window.height() / 2 + 10);
				if (color <= 0) {
					change = 20;
				}
				else if (color >= 255) {
					change = -20;
				}
				color += change;
			}
			Window.frame();
		}

	}

}
