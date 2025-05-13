public class Ticket {
    private Attendee attendee;
    private Event event;
    private String status;
    public Ticket(Attendee attendee, Event event)
    {
        this.attendee=attendee;
        this.event=event;
        this.status="Booked";
    }
    public Attendee getAttendee() {
        return attendee;
    }
    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    void cancel()
    {
        status="cancelled";
    }
    String ticketDetails()
    {
        return "Ticket for the event "+ event.getTitle()+" Attendee is- "+attendee.name+" Their status is- "+status;
    }
}