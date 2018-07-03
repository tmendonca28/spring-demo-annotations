package com.tmendonca.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call method on bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getBalls());

        //call method to get daily fortune
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getSalary());

        // close context
        context.close();
    }
}
