package se331.lab.service;

import se331.lab.entity.Event;

import java.util.List;

import org.springframework.data.domain.Page;

public interface EventService {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);
    Event save(Event event);
}
