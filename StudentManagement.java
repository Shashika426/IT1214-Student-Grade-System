import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		ArarayList<Student> students=new ArrayList<>();
		
		int choice;
		
		do{
			System.out.println("\n===Student Grade Management System===");
			System.out.println("1. Add Student");
			System.out.println("2. Display All Students");
			System.out.println("3. Search Student By ID");
			System.out.println("4. Calculate Average Marks");
			System.out.println("5. Exit");
			System.out.println("Enter Choice:");
			
			choice=input.nextInt();
			input.nextLine();
			
			switch(choice){
				case 1:
					System.out.pintln("Enter Student ID: ");
					String id=input.nextLine();
					System.out.println("Enter Student Name: ");
					String name=input.nextLine();
					System.out.println("Enter Marks: ");
					double marks=input.nextDouble();
					
					students.add(new Student(id,name,marks));
					System.out.println("Student Added Succesfully!");
				break;
				
				case 2:
					if(students.isEmpty()){
						System.out.println("No Students Available!");
					}else{
						for(Student s:students){
							s.displayStudents();
						}
					}
				break;
				
				case 3:
					System.out.println("Enter Student ID to Search: ");
					String searchId=input.nextLine();
					boolean found=false;
					
					for(Student s:students){
						if(s.getStudentId().equals(searchId)){
							s.displayStudent();
							found=true;
							break;
						}
					}
					if(!found){
						System.out.println("Student Not Found!");
					}
				break;
				
				case 4:
					if(students.isEmpty()){
						System.out.println("No Student Records Available.");
					}else{
						double total=0;
						for(Student s:students){
							total=total+s.getMarks();
						}
						double average=total/students.size();
						System.out.println("Average Marks: "+average);
					}
				break;
				
				case 5:
					System.out.println("Program Ended");
				break;
				
				default:
					System.out.println("Invalid Choice");
			}
		}while (choice!=5);
		input.close();
	}
}