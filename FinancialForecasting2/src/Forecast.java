/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cmkav
 */
public class Forecast {

    public static void main(String[] args) {
        double currentValue = 10000;
        double growthRate = 0.10;
        int years = 5;
        double futureValue = forecastValue(currentValue, growthRate, years);

        System.out.println("Future Value = " + futureValue);
    }
    public static double forecastValue(double currentValue, double growthRate, int years) {

    if(years == 0)
        return currentValue;

    return forecastValue(currentValue * (1 + growthRate), growthRate, years - 1);

    }
    

}