import java.util.Scanner;

class LaundryOrder{
        int orderId;
        String customerName;
        int shirts,pants,bedsheets;
        double totalbill;
        boolean isCompleted;

        static int ordercounter = 1001;

        public LaundryOrder(){
                orderId = ordercounter++;
                isCompleted = false;
        }

        void calculateBill(){
                double shirtprice =20;
                double pantprice= 30;
                double bedsheetprice=40;
                totalbill = (shirts * shirtprice)+(pants *pantprice)+(bedsheets*bedsheetprice);

        }
}

public class LaundryServiceManagementSystem {
        public static void main(String[] args) {
        
                Scanner sc= new Scanner(System.in);

                LaundryOrder[] orders = new LaundryOrder[10];
                int orderCount =0;

                int choice;
                do{
                        System.out.println("<==== Laundry Service Management System ====>");
                        System.out.println("1. New Laundry Order");
                        System.out.println("2. View All Orders");
                        System.out.println("3. Complete order");
                        System.out.println("4. Generate Bill");
                        System.out.println("5. Exit");
                        System.out.println("Enter your choice: ");
                        choice = sc.nextInt();
                        switch(choice){
                                case 1:
                                if(orderCount >=10){
                                        System.out.println("Order Limit Reached.");
                                        break;
                                }; 
                                LaundryOrder order = new LaundryOrder();
                                sc.nextLine();

                                System.out.println("Enter Customer Name:");
                                order.customerName = sc.nextLine();
                                System.out.println("Number of Shirts:");
                                order.shirts = sc.nextInt();
                                System.out.println("Number of Pants:");
                                order.pants = sc.nextInt();
                                System.out.println("Number of Bedsheets:");
                                order.bedsheets = sc.nextInt();
                                order.calculateBill();
                                orders[orderCount++]= order;

                                System.out.println("Order Placed Successfully.");
                                System.out.println("Order ID: " + order.orderId);
                                break;

                        case 2:
                                System.out.println("<==== All Laundry Orders ====>");
                                for(int i=0;i<orderCount;i++){
                                        LaundryOrder o = orders[i];
                                        System.out.println("Order ID: " + o.orderId + ", Customer Name: " + o.customerName + ", Total Bill: " + o.totalbill + ", Completed: " + o.isCompleted);
                                }
                                break;
                        case 3:
                                System.out.println("Enter Order ID to Complete:");
                                int id = sc.nextInt();
                                boolean found = false;
                                for(int i=0;i<orderCount;i++){
                                        if(orders[i].orderId == id){
                                                orders[i].isCompleted = true;
                                                System.out.println("Order ID " + id + " marked as Completed.");
                                                found = true;
                                                break;
                                        }
                                }    
                                
                                if(!found){
                                        System.out.println("Order ID not found.");
                                }
                                break;
                        case 4:
                                System.out.println("Enter Order ID to Generate Bill:");
                                int billId = sc.nextInt();

                                boolean billFound = false;
                                for(int i=0;i<orderCount;i++){
                                        if(orders[i].orderId == billId){
                                                LaundryOrder o = orders[i];
                                                System.out.println("<==== Laundry Bill ====>");

                                                System.out.println("Order ID: " + o.orderId);
                                                System.out.println("Customer Name: " + o.customerName);
                                                System.out.println("Shirts: " + o.shirts);
                                                System.out.println("Pants: " + o.pants);
                                                System.out.println("Bedsheets: " + o.bedsheets);
                                                System.out.println("Total Bill: " + o.totalbill);
                                                System.out.println("Completed: " + o.isCompleted);
                                                billFound = true;
                                                break;


                                        }
                                       
                                }
                                 if(!billFound){
                                                System.out.println("Order ID not found.");
                                        }
                                        break;
                        case 5:
                                System.out.println("Thanks for using Laundry Service");
                                System.exit(0);
                        default:
                                System.out.println("Invalid Choice. Try Again.");       
                                        
                                 
                        
                        
                        }
                }while(true);
        }
}
