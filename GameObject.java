package termproject;

public abstract class GameObject {
	protected int distance; // 한 번 이동거리 
	protected int x, y; // 현재 위치(화면 맵 상의 위치)
	public GameObject(int startX, int startY, int distance) { // 초기 위치와 이동거리 설정 생성자
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean collide(GameObject p) { // 이 객체가 객체 p와 충돌헀으면 true 리턴
		if(this.x == p.getX() && this.y == p.getY()) {
			return true;
		} 
		else {
			return false;
		}
	}
	protected abstract void move(); // 이동한 후의 새로운 위치로 x, y 변경
	protected abstract char getShape(); // 객체의 모양을 나타내는 문자 리턴 
}
