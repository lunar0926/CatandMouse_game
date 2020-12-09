package termproject;
public class Mouse extends GameObject {
	int ranNumber; // Game 클래스에서 random 정수값을 저장하는 변수
	int count = 0; // Mouse의 이동 횟수 
	public Mouse (int startX, int startY, int distance) {
		super(startX, startY, distance);
		
	}
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	protected void move() {
 
		if (getX() == 0 && ranNumber == 3 || getX() == 9 && ranNumber == 2 
				|| getY() == 0 && ranNumber == 1 || getY() == 19 && ranNumber == 4) {
			setXY(x, y); // 예외처리. 이동하지 않는 경우
		}
		else if (ranNumber == 1) { // 왼쪽
			setXY(x, y-distance);
		}
		else if (ranNumber == 2) { // 아랫쪽
			setXY(x+distance, y);
		}
		else if (ranNumber == 3) { // 위쪽
			setXY(x-distance, y);
		}
		else {
			setXY(x, y+distance); // 오른쪽
		}
		
	}
	@Override
	protected char getShape() {
		return 'm';
	}
	// 충돌 확인 함수는 그대로 상속받음. 
}
