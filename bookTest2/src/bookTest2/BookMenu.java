package bookTest2;

public interface BookMenu {
	//상수, 추상메소드, 디폴트 메소드, private -> 모호성 발생되는 것들은 안된다.
	int PRINT = 1; 
	int INSERT = 2;
	int UPDATE = 3; 
	int DELETE = 4;
	int SALARY_UP = 5;
	int EXIT = 6;
}
