package ca.ualberta.snoor1.listycity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the City class.
 * Tests the getters and compareTo functionality.
 */
public class CityTest {
    private City city;

    @Before
    public void setUp() {
        // Arrange - create a test city before each test
        city = new City("Edmonton", "Alberta");
    }

    @Test
    public void testGetCityName() {
        // Act
        String cityName = city.getCityName();

        // Assert
        assertEquals("Edmonton", cityName);
    }

    @Test
    public void testGetProvinceName() {
        // Act
        String provinceName = city.getProvinceName();

        // Assert
        assertEquals("Alberta", provinceName);
    }

    @Test
    public void testCompareTo_sameCityName_returnsZero() {
        // Arrange
        City city1 = new City("Edmonton", "Alberta");
        City city2 = new City("Edmonton", "Alberta");

        // Act
        int result = city1.compareTo(city2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testCompareTo_firstCityBeforeSecond_returnsNegative() {
        // Arrange
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Edmonton", "Alberta");

        // Act
        int result = city1.compareTo(city2);

        // Assert
        assertTrue(result < 0);
    }

    @Test
    public void testCompareTo_firstCityAfterSecond_returnsPositive() {
        // Arrange
        City city1 = new City("Edmonton", "Alberta");
        City city2 = new City("Calgary", "Alberta");

        // Act
        int result = city1.compareTo(city2);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    public void testCompareTo_caseMatters() {
        // Arrange
        City city1 = new City("edmonton", "Alberta");
        City city2 = new City("Edmonton", "Alberta");

        // Act
        int result = city1.compareTo(city2);

        // Assert
        // lowercase 'e' comes after uppercase 'E' in ASCII/Unicode
        assertTrue(result > 0);
    }

    @Test
    public void testConstructor_storesValuesCorrectly() {
        // Arrange & Act
        City testCity = new City("Vancouver", "British Columbia");

        // Assert
        assertEquals("Vancouver", testCity.getCityName());
        assertEquals("British Columbia", testCity.getProvinceName());
    }
}

