public class Attendee extends User{
    Attendee(String id, String name){
        super(id, name);
    }
    @Override
    void showProfile(){
        System.out.println("Id: "+this.id+"\nName: "+this.name);
    }
}
