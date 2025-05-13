public class Organizer extends User{
    boolean active=true;
    Organizer(String id, String name){
        super(id,name);
    }
    boolean isActive(){
        if(this.active){
            return true;
        }
        else{
            return false;
        }
    }
    void setActive(boolean bool_val){
        this.active=bool_val;
    }
    @Override
    void showProfile(){
        if(this.active){
            System.out.println("Status: Active");
        }
        else{
            System.out.println("Status: Inactive");
        }
    }
}
