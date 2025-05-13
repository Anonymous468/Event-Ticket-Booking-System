package event_booking;

import java.util.List;
import java.util.Iterator;

@RoleRequired(role = "Admin")
public class Admin extends User {
    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("Admin Details : ");
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Role: Admin");
    }

    public void removeEvent(List<Event> events, String title) throws IllegalAccessException {
        Class<?> c = this.getClass();
        if (c.isAnnotationPresent(RoleRequired.class)) {
            RoleRequired annotation = c.getAnnotation(RoleRequired.class);
            if ("Admin".equals(annotation.role())) {
                Iterator<Event> iterator = events.iterator();
                boolean found = false;
                while (iterator.hasNext()) {
                    Event e = iterator.next();
                    if (e.getTitle().equals(title)) {
                        iterator.remove();
                        System.out.println("Event removed: " + title);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Event not found: " + title);
                }
            } else {
                throw new IllegalAccessException("User role '" + annotation.role() + "' is not authorized to remove events.");
            }
        } else {
            throw new IllegalAccessException("No RoleRequired annotation present. Access denied.");
        }
    }
}

