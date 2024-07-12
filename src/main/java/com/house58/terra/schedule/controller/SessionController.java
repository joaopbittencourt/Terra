package com.house58.terra.schedule.controller;

import com.house58.terra.schedule.dao.SessionRepository;
import com.house58.terra.schedule.entity.Session;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/session")
public class SessionController  {
    private final SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    @PostMapping
    private Session save(@RequestBody Session session){
        return this.sessionRepository.save(session);
    }


    @DeleteMapping("/delete-session")
    private Session delete(@RequestBody Session session){
        session.setStatus(false);
        return this.sessionRepository.save(session);
    }
}
