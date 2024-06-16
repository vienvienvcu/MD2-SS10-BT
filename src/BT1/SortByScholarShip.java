package BT1;

import java.util.Comparator;

public class SortByScholarShip implements Comparator<BKapStudent> {


    @Override
    public int compare(BKapStudent o1, BKapStudent o2) {
        return (int) (o1.getScholarShip()-o2.getScholarShip());
    }
}
