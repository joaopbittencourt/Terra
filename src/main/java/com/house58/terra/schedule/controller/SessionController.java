package com.house58.terra.schedule.controller;

import com.house58.terra.schedule.dao.SessionRepository;
import com.house58.terra.schedule.entity.Session;
import org.springframework.web.bind.annotation.*;

@RestController("session")
public class SessionController  {
    private final SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    @PostMapping
    private Session save(@RequestBody Session session){
        return this.sessionRepository.save(session);
    }

    @PutMapping
    private Session update(@RequestBody Session session){
        return this.sessionRepository.save(session);
    }

    @DeleteMapping
    private Session delete(@RequestBody Session session){
        session.setStatus(false);
        return this.sessionRepository.save(session);
    }
}
