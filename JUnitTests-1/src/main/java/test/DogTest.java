package test;

import dto.Dog;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    Dog dog;

    @BeforeEach
    void prepareData() {
        dog = new Dog("Alex", 5);
    }

    @Test
    void testGetDogName() {
        assertEquals("Alex", dog.getName());
    }

    @Test
    void testSetDogName() {
        dog.setName("Jack");
        assertEquals("Alex", dog.getName());
    }

    @Test
    void testSetDogNameIfEmpty() {
        Dog noNameDog = new Dog("", 5);
        noNameDog.setName("Jack");
        assertEquals("Jack", noNameDog.getName());
    }

    @Test
    void testGetDogAge() {
        assertEquals(5, dog.getAge());
    }

    @Test
    void testSetDogAge() {
        dog.setAge(10);
        assertEquals(10, dog.getAge());
    }


}