package BT2;

import java.text.ParseException;

public interface IEmployee {
    public void input() throws ParseException;
    public void display();
    public double calculateBonus();
    public double calculateSalary();
    public static final int basicSalay = 1600000;
}
