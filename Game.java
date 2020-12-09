package termproject;
import java.util.*;
public class Game {

	public static void main(String[] args) {
		Cat c = new Cat(0, 0, 1);
		Mouse m = new Mouse(5, 16, 1);
		
		Random r = new Random();
		
		System.out.println("** Cat�� Mouse ��� ������ �����մϴ�. **");
		char[][] grid = new char[10][20]; // 10�� 20���� ������ 2���� �迭 ����
		for (int i=0; i < 10; i++) {
			for (int j=0; j < 20; j++) {
				grid[i][j] = '-';
			}
		}
		grid[c.getX()][c.getY()] = c.getShape();
		grid[m.getX()][m.getY()] = m.getShape();
		// Cat �� Mouse�� �ʱ� ��ġ
		
		while(c.collide(m) == false) { // Cat�� Mouse�� ���� ������ ���� �ݺ�
			// ������ ���
			for (int i=0; i < 10; i++) {
				for (int j=0; j < 20; j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println("");
			}
			// ����� Ű �Է�
			Scanner s = new Scanner(System.in);
			System.out.print("����(a), �Ʒ�(s), ��(d), ������(f) >> ");
			c.key = s.next();
			
			if ((c.getX() == 0 && c.key.equals("d")) || (c.getX() == 9 && c.key.equals("s")) 
					|| (c.getY() == 0 && c.key.equals("a")) || (c.getY() == 19 && c.key.equals("f"))) {
				System.out.println("����̰� ���̻� �� �������� �̵��� �� �����ϴ�. �ٽ� �Է����ּ���." );
				continue;
			} // ���� ó��
			
			grid[c.getX()][c.getY()] = '-';
			c.move();  
			grid[c.getX()][c.getY()] = c.getShape();
			// Cat �̵�

			m.count++;
			m.ranNumber = (r.nextInt(4)+1); // 1~4 ������ ���� ��
			if (m.count == 6) {
				m.count = 0;
			} 
			else if (m.getX() == 0 && m.ranNumber == 3 || m.getX() == 9 && m.ranNumber == 2 
					|| m.getY() == 0 && m.ranNumber == 1 || m.getY() == 19 && m.ranNumber == 4) {
				continue;
			} // ���� ó��. Mouse�� �� �̻� �̵��� �� ���� ���
			else if (m.count > 3){ 
				grid[m.getX()][m.getY()] = '-';
				m.move();
				grid[m.getX()][m.getY()] = m.getShape();
			}
			if (c.collide(m) == true ) {
				grid[c.getX()][c.getY()] = c.getShape(); // Cat(c)�� ǥ��.
				for (int i=0; i < 10; i++) {
					for (int j=0; j < 20; j++) {
						System.out.print(grid[i][j]);
					}
					System.out.println("");
				} // ���ڿ� c�� ǥ��
				System.out.println("Cat win!!"); // Cat�� Mouse�� ������ �� ������ ����ϰ� ���� �ݺ� ����
				break;
			}
		}		
		
	}	
}
