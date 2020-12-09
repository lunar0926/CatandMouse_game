package termproject;
public class Mouse extends GameObject {
	int ranNumber; // Game Ŭ�������� random �������� �����ϴ� ����
	int count = 0; // Mouse�� �̵� Ƚ�� 
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
			setXY(x, y); // ����ó��. �̵����� �ʴ� ���
		}
		else if (ranNumber == 1) { // ����
			setXY(x, y-distance);
		}
		else if (ranNumber == 2) { // �Ʒ���
			setXY(x+distance, y);
		}
		else if (ranNumber == 3) { // ����
			setXY(x-distance, y);
		}
		else {
			setXY(x, y+distance); // ������
		}
		
	}
	@Override
	protected char getShape() {
		return 'm';
	}
	// �浹 Ȯ�� �Լ��� �״�� ��ӹ���. 
}
