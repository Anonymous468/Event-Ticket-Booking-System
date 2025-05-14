import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        EventBookingSystem system= new EventBookingSystem();
        try {
            system.loadEvents();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        boolean exit=false;
        while (!exit) {
            System.out.println(" Ride Booking Menu ");
            System.out.println("1. Register Attendee");
            System.out.println("2. add event");
            System.out.println("3. book ticket");
            System.out.println("4. Show events");
            System.out.println("5. EXIT");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    EventBookingSystem.registerUser();
                    break;
                case 2:
                    System.out.println("enter event title");
                    String title=sc.nextLine();
                    System.out.println("enter available tick. ");
                    int tickets=sc.nextInt();
                    system.addEvent(new Event(title,tickets));
                    break;
                case 3:
                    System.out.println("enter attendee id");
                    String id2=sc.nextLine();
                    System.out.println("enter event title");
                    String title2=sc.nextLine();
                    try {
                        system.bookTicket(id2,title2);
                        System.out.println("booked");
                    }
                    catch(InvalidBookingException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    system.showEvents();
                    break;
                case 5:
                    System.exit(0);

            }
        }
    }
}