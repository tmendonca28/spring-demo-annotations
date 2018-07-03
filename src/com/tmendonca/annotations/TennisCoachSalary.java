package com.tmendonca.annotations;

import org.springframework.stereotype.Component;

@Component
public class TennisCoachSalary implements SalaryService{

    @Override
    public String getSalary() {
        return "You will be paid 300 pounds";
    }
}
