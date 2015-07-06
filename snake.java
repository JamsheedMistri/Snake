package snake;

import apcs.Window;

public class snake {
	int x, y, side = 10, speed = 10, direction = 0;
	static final int up = 90, down = 270, right = 0, left = 180;
	snake next;

	//constructor for head of snake
	public snake() {
		x = Window.width() / 2;
		y = Window.height() / 2;
	}

	//constructor for body of snake
	public snake(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void draw() {
		Window.out.color(0, 255, 0);
		Window.out.square(x, y, side);
		if (next != null) {
			//			Window.out.color("blue");
			//			Window.out.square(x, y, side);
			next.draw();

		}
	}

	public void grow() {
		if (next == null) {
			switch (direction) {
			case up:
				next = new snake(x, y + side);
				break;
			case down:
				next = new snake(x, y - side);
				break;
			case left:
				next = new snake(x + side, y);
				break;
			case right:
				next = new snake(x - side, y);
				break;
			}
			next.direction = direction;
		}
		else {
			next.grow();
		}
	}

	public void move() {
		if (direction == up) {
			y -= speed;

		}
		if (direction == down) {
			y += speed;
		}

		if (direction == left) {
			x -= speed;
		}
		if (direction == right) {
			x += speed;
		}

		if (next != null) {
			next.move();
			next.direction = direction;
		}

	}

	public boolean checkBoundaries() {
		if (x < side || x > Window.width() - side || y < side || y > Window.height() - side) {
			return true;
		}
		else {
			return false;
		}

	}

	public boolean checkEatSelf(snake head) {
		if (next == null) {
			return false;
		}
		else {
			if (Math.abs(head.x - next.x) < side && Math.abs(head.y - next.y) < side) {
				return true;
			}

		}
		return next.checkEatSelf(head);
	}
	public boolean checkFood(foooooood f) {
		if (Math.abs(x - f.x) <= side && Math.abs(y - f.y) <= side) {
			return true;
		}
		return false;
	}
	public void changeDirection() {
		if (next == null) {
			if (Window.key.pressed("up")) {
				direction = up;
			}
			else if (Window.key.pressed("down")) {
				direction = down;
			}
			else if (Window.key.pressed("left")) {
				direction = left;
			}
			else if (Window.key.pressed("right")) {
				direction = right;
			}
		}
		else {
			if (Window.key.pressed("up") && direction != down) {
				direction = up;
			}
			else if (Window.key.pressed("down") && direction != up) {
				direction = down;
			}
			else if (Window.key.pressed("left") && direction != right) {
				direction = left;
			}
			else if (Window.key.pressed("right") && direction != left) {
				direction = right;
			}
		}

	}

}
