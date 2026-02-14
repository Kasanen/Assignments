
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {
    // Fahrenheit To Celsius
    @Test 
    void canConvertToCelsiusPositive() {
        TemperatureConverter tc = new TemperatureConverter();
        double value = 32.0; 
        assertEquals(0.0, tc.fahrenheitToCelsius(value));
    }

    @Test 
    void canConvertToCelsiusNegative() {
        TemperatureConverter tc = new TemperatureConverter();
        double value = -40.0; 
        assertEquals(-40.0, tc.fahrenheitToCelsius(value));
    }

    // Celsius To Fahrenheit
    @Test 
    void canConvertToFahrenheitPositive() {
        TemperatureConverter tc = new TemperatureConverter();
        double value = 100.0; 
        assertEquals(212.0, tc.celsiusToFahrenheit(value));
    }

    @Test 
    void canConvertToFahrenheitNegative() {
        TemperatureConverter tc = new TemperatureConverter();
        double value = -40.0; 
        assertEquals(-40.0, tc.celsiusToFahrenheit(value));
    }

    // Kelvin To Celsius
    @Test 
    void canConvertToCelsiusFromKelvinPositive() {
        TemperatureConverter tc = new TemperatureConverter();
        double value = 273.15; 
        assertEquals(0.0, tc.kelvinToCelsius(value));
    }

    @Test 
    void canConvertToCelsiusFromKelvinNegative() {
        TemperatureConverter tc = new TemperatureConverter();
        double value = 0.0; 
        assertEquals(-273.15, tc.kelvinToCelsius(value));
    }

    // Is Extreme Temperature
    @Test
    void isIsExtremeTemperaturePositive(){
        TemperatureConverter tc = new TemperatureConverter();
        double value = 60.4563;
        assertEquals(true, tc.isExtremeTemperature(value));
    }

    @Test
    void isIsExtremeTemperatureNegative(){
        TemperatureConverter tc = new TemperatureConverter();
        double value = -40.00;
        assertEquals(true, tc.isExtremeTemperature(value));
    }

    @Test
    void isNotIsExtremeTemperaturePositive(){
        TemperatureConverter tc = new TemperatureConverter();
        double value = 49.99;
        assertEquals(false, tc.isExtremeTemperature(value));
    }

    @Test
    void isNotIsExtremeTemperatureNegative(){
        TemperatureConverter tc = new TemperatureConverter();
        double value = -39.999;
        assertEquals(false, tc.isExtremeTemperature(value));
    }
}