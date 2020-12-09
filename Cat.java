package termproject;

public class Cat extends GameObject {
	// x, y, distance 필드도 상속받음
	String key; // 방향을 정하는 변수
	public Cat (int startX, int startY, int distance) {
		super(startX, startY, distance); 
	}
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	protected void move() {
		if (key.equals("a")) {
			setXY(x, y-distance);
		}
		else if (key.equals("s")) {
			setXY(x+distance, y);
		}
		else if (key.equals("d")) {
			setXY(x-distance, y);
		}
		else if (key.equals("f")) {
			setXY(x, y+distance);
		}
	}
	@Override
	protected char getShape() {
		return 'c';
	}
	// 충돌 확인 함수는 그대로 상속받음. 
	
}
