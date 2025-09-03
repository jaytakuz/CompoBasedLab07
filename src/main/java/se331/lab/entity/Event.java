package se331.lab.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event {
    long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    String organizer;
}
