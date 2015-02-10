import java.util.*;
import java.io.*;
public class ScoreTracker{
	private ArrayList<Student> students;
	public ScoreTracker(){
	}
	private void loadDataFromFile(String fileName){
		students=new ArrayList<Student>();
		try{
			FileReader reader=new FileReader(fileName);
			Scanner fil=new Scanner(reader);
			while(fil.hasNextLine()){
				String nam=fil.nextLine();
				String sc=fil.nextLine();
				int score=-1;
				try{
					score=Integer.parseInt(sc);
				}
				catch(NumberFormatException f){
					System.out.println("ERROR: Score "+sc+" was not actually a number");
				}
				students.add(new Student(nam,score));
			}
			fil.close();
		}
		catch(FileNotFoundException e){
			System.out.println("ERROR: File was not found :(");
		}
		
	}
	private void printInOrder(){
		Collections.sort(students);
		for(Student t:students){
			System.out.println(t);
		}
	}
	public void processFiles(String[] filname){
		for(String s:filname){
			loadDataFromFile(s);
			printInOrder();
		}
	}
	private static String[] files={"scores2.txt", "badscore.txt","nofile.txt"};
	public static void main(String args[]){
		ScoreTracker track=new ScoreTracker();
		track.processFiles(files);
//		boolean out=true;
//		Scanner sc = new Scanner(System.in);
//		while(out){
//			System.out.println("input a number choice:\n1: Add new course\n2: Display all courses\n3: quit");
//			int i = Integer.parseInt(sc.nextLine());
//			if(i==1){
//				System.out.println("Enter the students name:");
//				String name=sc.nextLine();
//				System.out.println("Enter the students favorite course:");
//				String course=sc.nextLine();
//				h.put(name,course);
//			}
//			if(i==2){
//				for(String f:h.keySet()){
//					System.out.println(f+" likes the course "+h.get(f));
//				}
//			}
//			if(i==3){
//				out=false;
//			}
//		}
//		sc.close();
	}
}