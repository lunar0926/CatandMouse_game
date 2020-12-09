package termproject;

public class Cat extends GameObject {
	// x, y, distance �ʵ嵵 ��ӹ���
	String key; // ������ ���ϴ� ����
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
	// �浹 Ȯ�� �Լ��� �״�� ��ӹ���. 
	
}
