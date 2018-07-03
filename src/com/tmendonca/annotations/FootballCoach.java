package com.tmendonca.annotations;

import org.springframework.stereotype.Component;
// Coach service impl
@Component
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Juggle the ball 20 times";
    }

    @Override
    public String getBalls() {
        return "You get 2 balls for the football coaching session";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

    @Override
    public String getSalary() {
        return null;
    }
}
