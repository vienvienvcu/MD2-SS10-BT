package TH2;

import org.junit.jupiter.api.Test;



public class FizzBuzzTest {
    @Test
    public void testFizz3() {
       int number = 3;
       String expected = "Fizz";
       String result = FizzBuzz.fizzBuzz(number);
       assert (result.equals(expected));
    }
    @Test
    public void testFizz6() {
        int number = 6;
        String expected = "Fizz";
        String result = FizzBuzz.fizzBuzz(number);
        assert (result.equals(expected));
    }
    @Test
    public void testBuzz4() {
        int number = 4;
        String expected = "Buzz";
        String result = FizzBuzz.fizzBuzz(number);
        assert (result.equals(expected));
    }
    @Test
    public void testFizzBuzz15() {
        int number = 15;
        String expected = "FizzBuzz";
        String result = FizzBuzz.fizzBuzz(number);
        assert (result.equals(expected));
    }
    @Test
    public void testFizzBuzz30() {
        int number = 30;
        String expected = "FizzBuzz";
        String result = FizzBuzz.fizzBuzz(number);
        assert (result.equals(expected));
    }
}
