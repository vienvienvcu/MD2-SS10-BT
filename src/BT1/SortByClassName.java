package BT1;

import java.util.Comparator;

public class SortByClassName implements Comparator<BKapStudent> {

    @Override
    public int compare(BKapStudent o1, BKapStudent o2) {
        return o1.getClassName().compareTo(o2.getClassName());
    }
}
