import java.util.Scanner;

class Member{
        int memberId;
        String memberName;
        String plan;
        int duration;
        double fees;
        boolean isActive;

        static int idCounter = 1001;

        Member(){
                memberId = idCounter++;
                isActive = true;
        }

        void calculateFees(){
                if(plan.equalsIgnoreCase("Monthly")){
                        fees = duration *1000;

                }else if(plan.equalsIgnoreCase("yearly")){
                        fees = duration * 10000;
                }
        }
}

public class GymMembershipSystem {
        public static void main(String [] args){
                Scanner sc = new Scanner(System.in);
                Member[] members = new Member[20];
                int count= 0;
                int choice;
                do{
                        System.out.println("<==== Gym Membership System ====>");
                        System.out.println("1. New Member Registation");
                        System.out.println("2. View All Members");
                        System.out.println("3. Deactivate Membership");
                        System.out.println("4. Generate Bill.");
                        System.out.println("5. Exit");
                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        switch(choice){
                                case 1:
                                        if(count >=20){
                                                System.out.println("Member Limit Reached.");
                                                break;
                                        }
                                        Member m= new Member();
                                        sc.nextLine();
                                        System.out.println("Member Name:");
                                        m.memberName = sc.nextLine();
                                        System.out.println("plan (Monthly/Yearly):");
                                        m.plan = sc.nextLine();
                                        System.out.println("Duration (in months/years): ");
                                        m.duration = sc.nextInt();
                                        m.calculateFees();
                                        members[count++] = m;
                                        System.out.println("Member Registration is done");
                                        System.out.println("Member ID: " + m.memberId);
                                        break;
                                case 2:
                                        System.out.println(
                                                "<==== All Members ====>");
                                        for(int i=0;i<count;i++){
                                                Member mem = members[i];
                                                System.out.println("ID: " + mem.memberId + ", Name: " + mem.memberName + ", Plan: " + mem.plan + ", Duration: " + mem.duration + ", Fees: " + mem.fees + ", Active: " + mem.isActive);
                                        }break;
                                case 3 :
                                        System.out.println("Enter Member ID to Deactivate :");
                                        int id = sc.nextInt();
                                        boolean found = false;
                                        for ( int i =0;i<count;i++){
                                                if(members[i].memberId == id){
                                                        members[i].isActive = false;
                                                        System.out.println("Membership Deactivated for ID: " + id);
                                                        found = true;
                                                        break;
                                                }
                                        }
                                        if(!found){
                                                System.out.println("Member ID not found.");
                                        }
                                        break;
                                case 4:
                                        System.out.println("Enter Member ID to Generate Bill:");
                                        int billId = sc.nextInt();
                                        boolean BillFound = false;
                                        for(int i=0;i<count;i++){
                                                if(members[i].memberId == billId){
                                                        Member mem = members[i];
                                                        System.out.println("<=== Bill ===>");
                                                        System.out.println("Member Name:"+ mem.memberName);
                                                        System.out.println("Plan: " + mem.plan);
                                                        System.out.println("Duration: " + mem.duration);
                                                        System.out.println("Total Fees: " + mem.fees);
                                                        System.out.println("Status:"+ (mem.isActive ? "Active" : "Inactive"));
                                                        BillFound = true;
                                                        break;
                                                }
                                        }
                                        if (!BillFound) {
                                                System.out.println("Member ID not found.");
                                        }
                                        break;

                                case 5:
                                        System.out.println("Exiting...");
                                        break;
                                default:
                                        System.out.println("Invalid Choice. Try Again.");
                                        

                                }
                }while(choice!=5);
                
        }
}
