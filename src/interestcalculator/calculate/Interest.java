/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interestcalculator.calculate;

import java.time.LocalDate;

/**
 *
 * @author vlado
 */
public class Interest {

    private LocalDate startDate;
    private LocalDate endDate;
    private double value;

    public Interest(LocalDate startDate, LocalDate endDate, double value) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.value = value;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getValue() {
        return value;
    }
}
