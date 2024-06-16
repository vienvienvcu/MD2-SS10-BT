package BT2;

import java.util.Comparator;

public class SortCalculateBonus implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.calculateBonus() - o2.calculateBonus());
    }
}
