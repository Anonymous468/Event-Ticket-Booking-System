import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventBookingSystem {
    int choice;
    private int no_of_avail_ticks;
    List<Attendee> attendee;
    List<Organizer> organizer;
    List<Event> event;
    List<Ticket> ticket;

    EventBookingSystem(){
    }

    EventBookingSystem(int choice){
        this.choice=choice;
    }

    void init_no_of_avail_ticks(){  //Setter
        Scanner sc=new Scanner(System.in);
        this.no_of_avail_ticks=sc.nextInt();
        sc.close();
    }

    void registerUser(){
        Scanner sc=new Scanner(System.in);
        String id,name;
        switch(choice){
            case 1:
                System.out.print("Enter id: ");
                id=sc.next();
                sc.nextLine();
                System.out.print("\nEnter name: ");
                name=sc.nextLine();
                sc.nextLine();
                System.out.println();
                sc.close();
                Attendee attend=new Attendee(id,name);
                attendee.add(attend);
                break;
            case 2:
                System.out.print("Enter id: ");
                id=sc.next();
                sc.nextLine();
                System.out.print("\nEnter name: ");
                name=sc.nextLine();
                sc.nextLine();
                System.out.println();
                sc.close();
                Organizer org=new Organizer(id,name);
                organizer.add(org);
                break;
            default:
                System.out.println("Wrong choice");

        }
    }

    void addEvent(){
        Scanner sc=new Scanner(System.in);
        String title;
        System.out.print("Event Title: ");
        title=sc.nextLine();
        sc.nextLine();
        System.out.print("\nNumber of Tickets: ");
        init_no_of_avail_ticks();
        sc.close();
        Event ev = new Event(title, this.no_of_avail_ticks);
        event.add(ev);
    }

    void bookTicket(){
        int attd_size=attendee.size();
        int ev_size=event.size();
        if(this.no_of_avail_ticks>0){
            Attendee attd1=attendee.get(attd_size-1);
            Event ev1=event.get(ev_size-1);
            Ticket ticket=new Ticket(attd1, ev1);
            this.no_of_avail_ticks -= 1;
        }
        else{
            System.out.println("No more tickets");
        }
    }

    void saveEvents(String filepath) {
        try (FileOutputStream fileOut = new FileOutputStream(filepath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            for (Event ev : event) {
                objectOut.writeObject(ev);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    /*List<Event> loadEvents(String filepath){
        try (FileInputStream fileIn = new FileInputStream(filepath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Event deserializedData1 = (Event) objectIn.readObject();
            MyData deserializedData2 = (MyData) objectIn.readObject();
            AnotherData deserializedMoreData = (AnotherData) objectIn.readObject();

            System.out.println("\nDeserialized objects:");
            System.out.println("Data 1: " + deserializedData1);
            System.out.println("Data 2: " + deserializedData2);
            System.out.println("More Data: " + deserializedMoreData);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        List<Events> loaded_event_list=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("events.txt"))) {
            String event_obj;
            while ((event_obj = reader.readLine()) != null) {
                Event event = event_obj;
                if (event != null) {
                    loaded_event_list.add(event);
                }
            }
            System.out.println("Events loaded successfully from: " + filePath);
        } catch (IOException e) {
            System.err.println("Error loading events from file: " + e.getMessage());
        }
        return events;
    }*/
}
