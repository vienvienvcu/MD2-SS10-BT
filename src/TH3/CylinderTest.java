package TH3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CylinderTest {
    @Test
    @DisplayName("testing getVolume(0,0)")
    public void testGetVolume0And0() {
        int radius = 0;
        int height = 0;
        double expected = 0;
        double result = Cylinder.getVolume(radius,height);
        assert (expected == result);
    }

    @Test
    @DisplayName("testing getVolume(1,2)")
    public void testGetVolume1And2() {
        int radius = 1;
        int height = 2;
        double expected = 18.84955592153876;
        double result = Cylinder.getVolume(radius,height);
        assert (expected == result);
    }
}
