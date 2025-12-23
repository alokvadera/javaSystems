import java.util.Scanner;

public class PostOfficeBilling {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Customer Name:");
            String Name = sc.nextLine();
            
            double total = 0;

            System.out.println("Service: (1.Spped post:),(2.parcel:)");
            int service=sc.nextInt();
            System.out.print("Enter Weight:");
            double Weight = sc.nextDouble();
            System.out.println("Enter Distance:");
            double Distance = sc.nextDouble();
            double fee=0;
            if(service==1){
                fee=35+(Distance/100)*10+(Weight-.5)*20;
            }else if(service==2){
                fee=50* Weight +(Distance/500)*15;
            }
            double gst=fee*0.18;
            total=fee+gst;
            System.out.println("<==== Post Office Billing ===>");
            System.out.println("Customer Name: " + Name);
            System.out.println("fee: "+ fee);
            System.out.println("GST (18%): "+ gst);
            System.out.println("Total Amount: "+ total);
            sc.close();
        }
}
