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
public class DateCreator {
    public static LocalDate date(int day, int month, int year) {
        return LocalDate.of(year, month, day);
    }
}
