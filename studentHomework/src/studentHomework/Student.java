package studentHomework;

public class Student {

	private int no;   
	private String name; 
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avr;
	private int price;
	
	public Student(int no, String name, int kor, int eng, int mat, int tot, double avr, int price) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avr = avr;
		this.price = price;
	}

	public Student() {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avr = avr;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvr() {
		return avr;
	}

	public void setAvr(double avr) {
		this.avr = avr;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avr=" + avr + ", price=" + price+ "]";
	}
	
	
}
