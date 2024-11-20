package studentHomework;

public class Student {

	private int no;   
	private String name; 
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avr;
	
	public Student(int no, String name, int kor, int eng, int mat, int tot, double avr) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avr = (kor+eng+mat)/3.0;
	}

	public Student() {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avr = (kor+eng+mat)/3.0;
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

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avr=" + avr + "]";
	}
	
	
}
