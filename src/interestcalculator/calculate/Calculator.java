/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interestcalculator.calculate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author vlado
 */
public class Calculator {

    private static Interest[] interests = new Interest[]{
         // 2000 - 2009
        new Interest(DateCreator.date(1, 1, 2000), DateCreator.date(1, 1, 2010), 6.00),
        
        // 2010
        new Interest(DateCreator.date(1, 1, 2010), DateCreator.date(1, 7, 2010), 8.00),
        new Interest(DateCreator.date(1, 7, 2010), DateCreator.date(1, 1, 2011), 8.00),
        
        // 2011
        new Interest(DateCreator.date(1, 1, 2011), DateCreator.date(1, 7, 2011), 8.00),
        new Interest(DateCreator.date(1, 7, 2011), DateCreator.date(1, 1, 2012), 8.25),
        
        // 2012
        new Interest(DateCreator.date(1, 1, 2012), DateCreator.date(1, 7, 2012), 8.00),
        new Interest(DateCreator.date(1, 7, 2012), DateCreator.date(1, 1, 2013), 8.00),
        
        // 2013
        new Interest(DateCreator.date(1, 1, 2013), DateCreator.date(1, 7, 2013), 7.75),
        new Interest(DateCreator.date(1, 7, 2013), DateCreator.date(1, 1, 2014), 7.50),
        
        // 2014
        new Interest(DateCreator.date(1, 1, 2014), DateCreator.date(1, 7, 2014), 7.25),
        new Interest(DateCreator.date(1, 7, 2014), DateCreator.date(1, 1, 2015), 7.15),
        
        // 2015
        new Interest(DateCreator.date(1, 1, 2015), DateCreator.date(1, 7, 2015), 7.05),
        new Interest(DateCreator.date(1, 7, 2015), DateCreator.date(1, 1, 2016), 7.05),
        
        // 2016 - 2018
        new Interest(DateCreator.date(1, 1, 2016), DateCreator.date(1, 7, 2016), 7.05),
        new Interest(DateCreator.date(1, 7, 2016), DateCreator.date(1, 1, 2019), 7.00),
        
        // 2019 - 2022
        new Interest(DateCreator.date(1, 1, 2019), DateCreator.date(1, 1, 2023), 8.00),
        
        // 2023
        new Interest(DateCreator.date(1, 1, 2023), DateCreator.date(1, 7, 2023), 10.50),
        new Interest(DateCreator.date(1, 7, 2023), DateCreator.date(1, 1, 2024), 12.00),
        
        // 2024
        new Interest(DateCreator.date(1, 1, 2024), DateCreator.date(1, 7, 2024), 12.50),
        new Interest(DateCreator.date(1, 7, 2024), DateCreator.date(1, 1, 2025), 12.25)
    };

    public CalculatorResult generate(LocalDate start, LocalDate end, double amount) {
        
        double result = 0;
        String description = "<html>";
        
        for (Interest interest: interests) {
            LocalDate interestStartDate = interest.getStartDate();
            LocalDate interestEndDate = interest.getEndDate();
            
            LocalDate minDate = interestStartDate.isAfter(start) ? interestStartDate : start;
            LocalDate maxDate = interestEndDate.isBefore(end) ? interestEndDate : end;
            
            if (minDate.isAfter(maxDate)) continue;
            
            double daysBetween = ChronoUnit.DAYS.between(minDate, maxDate);
            description += "" + ((int)daysBetween) + " days at rate of " + interest.getValue() + "%<br>";
            result += daysBetween * interest.getValue() * amount;
        }
        
        description += "</html>";
        return new CalculatorResult(description, "" + result / 36500);
    }
}
