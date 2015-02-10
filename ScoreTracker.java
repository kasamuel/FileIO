import java.util.*;
import java.io.*;
public class ScoreTracker{
	private ArrayList<Student> students;
	public ScoreTracker(){
	}
	private void loadDataFromFile(String fileName)throws Exception{
		students=new ArrayList<Student>();
		try{
			FileReader reader=new FileReader(fileName);
			Scanner fil=new Scanner(reader);
			while(fil.hasNextLine()){
				String nam=fil.nextLine();
				String sc=fil.nextLine();
				int score=-1;
				if(!nam.contains(" ")){
					fil.close();
					throw new Exception("the line name "+nam+" doesn't contain both a first and last name");
				}
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
	public void processFiles(String[] filname)throws Exception{
		for(String s:filname){
			loadDataFromFile(s);
			printInOrder();
		}
	}
	private static String[] files={"scores2.txt", "badscore.txt","nofile.txt","badname.txt"};
	public static void main(String args[])throws Exception{
		ScoreTracker track=new ScoreTracker();
		track.processFiles(files);
	}
}