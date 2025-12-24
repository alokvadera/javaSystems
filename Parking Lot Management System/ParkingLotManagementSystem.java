import java.util.Scanner;

class slot{
    int slotNumber;
    boolean isOccupied;
    String VehicleNumber;
    String VehicleType;
    long inTime;
    slot(int slotNumber){
        this.slotNumber=slotNumber;
        this.isOccupied=false;


    }


    long getParkingCharge(){
        long Hours=(System.currentTimeMillis()-inTime)/(1000*60*60);

        if(Hours == 0){
            Hours = 1;
        }
        if (VehicleType.equalsIgnoreCase("car")){
            return Hours*50;
        }else{
            return Hours*50;
        }
    }
}
public class ParkingLotManagementSystem {

    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        slot[] slots = new slot[10];

        for(int i=0;i<10;i++){
            slots[i]=new slot(i+1);

        }
        int choice;
        do{
            System.out.println("<==== Parking Lot Management System ====>");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Parking Lot");
            System.out.println("3. Check Lot Availaibility");
            System.out.println("4. Search Vehicle");
            System.out.println("5. Exit System");
            System.out.println("Enter Your Choice:");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nPark Vehicle");
                    int freeslot = -1;

                    for(slot s: slots){
                        if(!s.isOccupied){
                            freeslot = s.slotNumber;
                            break;

                        }
                    }
                    if(freeslot == -1){
                        System.out.println("Parking Full");
                        break;
                    }
                    
                    System.out.println("Available Slot"+ freeslot);
                    System.out.println("Enter Vehicle Number:");
                    sc.nextLine();
                    String Vno = sc.nextLine();
                    System.out.println("Vehicle Type (car/bike)");
                    String type=sc.nextLine();
                    slot s= slots[freeslot-1];
                    s.VehicleNumber=Vno;
                    s.VehicleType=type;
                    s.isOccupied=true;
                    s.inTime=System.currentTimeMillis();
                    System.out.println("Vehicle Parked Successfully.");
                    break;

                case 2:
                    System.out.println("Enter Slot Number To Exit.");
                    int slotNo =sc.nextInt();
                    if(slotNo<0||slotNo>10){
                        System.out.println("Invalid Slot");
                        break;
                    }
                    slot ss= slots[slotNo-1];

                    if(!ss.isOccupied){
                        System.out.println("Slot Already Empty.");
                        break;
                    }

                    long charge = ss.getParkingCharge();

                    System.out.println("Vehicle Number:" + ss.VehicleNumber);
                    System.out.println("Vehicle Type:"+ ss.VehicleType);
                    System.out.println("Total Parking Charge:"+ charge);
                    ss.isOccupied=false;
                    ss.VehicleNumber=null;
                    ss.VehicleType=null;

                    System.out.println("Vehicle Exited.");
                    case 3:
                        System.out.println("<=== slot Availaibility ===>");
                        for(slot obj:slots){
                            System.out.println("Slot "+obj.slotNumber+": "+(obj.isOccupied?"occupied":"empty"));

                        }
                        break;
                    case 4:
                        System.out.println("Enter Vehicle Number To Search: ");
                        sc.nextLine();
                        String search= sc.nextLine();
                        boolean found = false;
                        for(slot slot:slots){
                            if(slot.isOccupied && slot.VehicleNumber.equalsIgnoreCase(search)){
                                System.out.println("Vehicle Found In This Slot: "+slot.slotNumber);
                                found = true;
                                break;

                            };
                        }
                        if (!found){
                            System.out.println("Vehicle Not Found.");
                            

                        }break;

                        case 5:
                            System.out.println("Exited System...");
                            break;

                        default:
                            System.out.println("INVALID CHOICE !");
            }
        }while(choice !=5);
    }
    
}
