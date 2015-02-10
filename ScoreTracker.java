import java.util.*;
import java.io.*;
public class ScoreTracker{
	
	public static void main(String args[]){
		//copied from previous project FOR NOW
		TreeMap<String,String> h=new TreeMap<String,String>();
		boolean out=true;
		Scanner sc = new Scanner(System.in);
		while(out){
			System.out.println("input a number choice:\n1: Add new course\n2: Display all courses\n3: quit");
			int i = Integer.parseInt(sc.nextLine());
			if(i==1){
				System.out.println("Enter the students name:");
				String name=sc.nextLine();
				System.out.println("Enter the students favorite course:");
				String course=sc.nextLine();
				h.put(name,course);
			}
			if(i==2){
				for(String f:h.keySet()){
					System.out.println(f+" likes the course "+h.get(f));
				}
			}
			if(i==3){
				out=false;
			}
		}
		sc.close();
	}
}