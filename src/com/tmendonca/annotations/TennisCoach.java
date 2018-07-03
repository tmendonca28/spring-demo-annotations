package com.tmendonca.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// Coach service impl
@Component
// add @Scope("Prototype") for new objects to be created every time the bean is called
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    @Autowired
    private SalaryService salaryService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // define an init method
    @PostConstruct
    public void doStartupStuff() {
        System.out.println(">> TennisCoach: inside of doStartupStuff");
    }


    // define a destroy method
    @PreDestroy
    public void doCleanupStuff() {
        System.out.println(">> TennisCoach: inside of doCleanupStuff");
    }



    // define a setter method
//    @Autowired
//    public void doSomething(FortuneService theFortuneService) {
//        System.out.println(">> TennisCoach: inside doSomething() method");
//        fortuneService = theFortuneService;
//    }

//    @Autowired
//    public TennisCoach(FortuneService theFortuneService) {
//        this.fortuneService = theFortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley " + email;
    }

    @Override
    public String getBalls() {
        return "You get 10 tennis balls for the day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getSalary() {
        return salaryService.getSalary();
    }
}
