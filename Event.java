package EVENT_BOOKING_SYSTEM;

public class Event {
private String title;
private int availableTickets;
public Event(String title, int availableTickets)
{
	this.title=title;
	this.availableTickets=availableTickets;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public int getAvailableTickets() {
	return availableTickets;
}

public void setAvailableTickets(int availableTickets) {
	this.availableTickets = availableTickets;
}

boolean isAvailable()
{
	if (availableTickets<=0)
		return false;
	else
		return true;
}
}
