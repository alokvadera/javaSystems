import java.util.Scanner;

class Student{
    int studentid;
    String name;
    int roomNo;
    boolean mess;
    double rent;
    static int idcounter = 101;

    Student(){
        studentid = idcounter++;
    }

    void calculateRent(){
    double roomRent = 5000;
    double messCharge = mess ? 3000:0;
    rent = roomRent + messCharge;
}}

public class HostelManagementSystem {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        Student[] students = new Student[20];
        int count =0;
        int choice;

        do{
            System.out.println("<====== Hostel Management System ====>");
            System.out.println("1.Register New Student");
            System.out.println("2.View All Students");
            System.out.println("3.Generate Monthly Bill");
            System.out.println("4.Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(choice>=20){
                        System.out.println("Hostel Full. Cannot register more students.");  
                        break;
                    }

                    Student s = new Student();
                    sc.nextLine();
                    System.out.println("Student Name:");
                    s.name = sc.next();
                    System.out.println("Room Number:");
                    s.roomNo = sc.nextInt();
                    System.out.println("Mess facility required? (true/false):");
                    s.mess = sc.nextBoolean();
                    s.calculateRent();
                    students[count++] = s;
                    System.out.println("Student Registered Successfully!");
                    System.out.println("Student ID: " + s.studentid);
                    break;
                case 2:
                    System.out.println("<=== Student List ===>");
                    for(int i=0; i<count; i++){
                        Student st = students[i];
                        System.out.println("ID: " + st.studentid + ", Name: " + st.name + ", Room No: " + st.roomNo + ", Mess: " + st.mess);
                    }
                    break;
                case 3:
                    System.out.println("Enter Student ID to generate bill:");
                    int id = sc.nextInt();
                    boolean found = false;
                    for(int i=0; i<count; i++){
                        if(students[i].studentid == id){
                            Student st= students[i];
                            System.out.println("<=== Your Monthly Bill ===>");
                            System.out.println("student ID:"+ st.studentid);
                            System.out.println("Name: " + st.name);
                            System.out.println("Room NO:"+st.roomNo);
                            System.out.println("Mess:"+st.mess);
                            System.out.println(" Rent: " + st.rent);
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Studnet Not Found");

                    }break;
                case 4:
                    System.out.println("Thank you using the Hostel Mangement System.");
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;  
                    
            }
        }while(choice != 4);
    }
}
