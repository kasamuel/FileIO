public class Student implements Comparable<Student>{
	private String nam;
	private int score;
	public Student(String n, int e){
		nam=n;
		score=e;
	}
	public int getScore(){
		return score;
	}
	public String toString(){
		return nam+" has a score of "+score;
	}
	public int compareTo(Student t){
		return this.nam.compareTo(t.nam);
	}
}