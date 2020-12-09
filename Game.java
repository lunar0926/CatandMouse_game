package termproject;
import java.util.*;
public class Game {

	public static void main(String[] args) {
		Cat c = new Cat(0, 0, 1);
		Mouse m = new Mouse(5, 16, 1);
		
		Random r = new Random();
		
		System.out.println("** Cat의 Mouse 잡기 게임을 시작합니다. **");
		char[][] grid = new char[10][20]; // 10행 20열의 격자판 2차원 배열 생성
		for (int i=0; i < 10; i++) {
			for (int j=0; j < 20; j++) {
				grid[i][j] = '-';
			}
		}
		grid[c.getX()][c.getY()] = c.getShape();
		grid[m.getX()][m.getY()] = m.getShape();
		// Cat 과 Mouse의 초기 위치
		
		while(c.collide(m) == false) { // Cat이 Mouse를 잡을 때까지 무한 반복
			// 격자판 출력
			for (int i=0; i < 10; i++) {
				for (int j=0; j < 20; j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println("");
			}
			// 사용자 키 입력
			Scanner s = new Scanner(System.in);
			System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
			c.key = s.next();
			
			if ((c.getX() == 0 && c.key.equals("d")) || (c.getX() == 9 && c.key.equals("s")) 
					|| (c.getY() == 0 && c.key.equals("a")) || (c.getY() == 19 && c.key.equals("f"))) {
				System.out.println("고양이가 더이상 그 방향으로 이동할 수 없습니다. 다시 입력해주세요." );
				continue;
			} // 예외 처리
			
			grid[c.getX()][c.getY()] = '-';
			c.move();  
			grid[c.getX()][c.getY()] = c.getShape();
			// Cat 이동

			m.count++;
			m.ranNumber = (r.nextInt(4)+1); // 1~4 사이의 랜덤 값
			if (m.count == 6) {
				m.count = 0;
			} 
			else if (m.getX() == 0 && m.ranNumber == 3 || m.getX() == 9 && m.ranNumber == 2 
					|| m.getY() == 0 && m.ranNumber == 1 || m.getY() == 19 && m.ranNumber == 4) {
				continue;
			} // 예외 처리. Mouse가 더 이상 이동할 수 없는 경우
			else if (m.count > 3){ 
				grid[m.getX()][m.getY()] = '-';
				m.move();
				grid[m.getX()][m.getY()] = m.getShape();
			}
			if (c.collide(m) == true ) {
				grid[c.getX()][c.getY()] = c.getShape(); // Cat(c)만 표기.
				for (int i=0; i < 10; i++) {
					for (int j=0; j < 20; j++) {
						System.out.print(grid[i][j]);
					}
					System.out.println("");
				} // 격자엔 c만 표기
				System.out.println("Cat win!!"); // Cat이 Mouse를 잡으면 이 문장을 출력하고 무한 반복 종료
				break;
			}
		}		
		
	}	
}
