package ru.frank.springkafkaexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.frank.springkafkaexample.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public void addEvent(@RequestBody String message) {
        service.addEvent(message);
    }

    @GetMapping
    public List<String> getEvents() {
        return service.getEvents();
    }
}
