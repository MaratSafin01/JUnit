package test;

import dto.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    public void createCar() {
        car = new Car("Skoda", "ABC-1234", 2019 ,"Marat Safin");
    }

    @Test
    void getManufacturer() {
        assertEquals("Skoda", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("ABC-1234", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("CBA-4321");
        assertEquals("CBA-4321", car.getNumber());
    }

    @ParameterizedTest
    @CsvSource({"'ABC-123', 'ABC-123'", "'DEF-456','DEF-456'"})
    void testSetNumberMultipleValues(String number, String x) {
        car.setNumber(number);
        assertEquals(x, car.getNumber());
    }

    @Test
    void getYear() {
        assertEquals(2019, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Marat Safin", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Safin Marat");
        assertEquals("Safin Marat", car.getOwner());
    }

    @Test
    void getOwners() {
        assertArrayEquals(new String[]{"Marat Safin"}, car.getOwners().toArray());
    }

    @Test
    void getOwnersWithSet() {
        car.setOwner("Safin Marat");
        assertArrayEquals(new String[]{"Marat Safin", "Safin Marat"}, car.getOwners().toArray());
    }


    // Private Methods


    @Test
    public void testPrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = Car.class.getDeclaredMethod("testMethod", null);

        method.setAccessible(true);

        assertEquals("Abc", method.invoke(car).toString());
    }

    @Test
    public void testAnotherPrivateMethod() throws Exception {

        Method method = Car.class.getDeclaredMethod("anotherTestMethod", String.class);

        method.setAccessible(true);

        assertEquals("Set your args", method.invoke(car, "Set your args").toString());
    }

    @Test
    void getTestData() {
        Exception exception = assertThrows(Exception.class, () -> {
            car.getDataFromRemoteServer();
        });

        assertEquals("error!!!", exception.getMessage());
    }

}