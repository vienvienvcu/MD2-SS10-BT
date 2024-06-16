package TH3;

public class Cylinder {
    public static double getVolume(double radius, double height) {
        double baseArea = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius * radius;
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }
}
