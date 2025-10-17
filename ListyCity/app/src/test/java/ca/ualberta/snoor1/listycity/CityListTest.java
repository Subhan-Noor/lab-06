package ca.ualberta.snoor1.listycity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for the CityList class.
 * Tests adding cities, getting sorted cities, and exception handling for duplicates.
 */
public class CityListTest {
    private CityList cityList;
    private City edmonton;
    private City calgary;
    private City vancouver;

    @Before
    public void setUp() {
        // Arrange - create a fresh CityList and test cities before each test
        cityList = new CityList();
        edmonton = new City("Edmonton", "Alberta");
        calgary = new City("Calgary", "Alberta");
        vancouver = new City("Vancouver", "British Columbia");
    }

    @Test
    public void testAdd_singleCity_cityAdded() {
        // Act
        cityList.add(edmonton);
        List<City> cities = cityList.getCities();

        // Assert
        assertEquals(1, cities.size());
        assertTrue(cities.contains(edmonton));
    }

    @Test
    public void testAdd_multipleCities_allCitiesAdded() {
        // Act
        cityList.add(edmonton);
        cityList.add(calgary);
        cityList.add(vancouver);
        List<City> cities = cityList.getCities();

        // Assert
        assertEquals(3, cities.size());
        assertTrue(cities.contains(edmonton));
        assertTrue(cities.contains(calgary));
        assertTrue(cities.contains(vancouver));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_duplicateCity_throwsException() {
        // Arrange
        cityList.add(edmonton);

        // Act & Assert - should throw IllegalArgumentException
        cityList.add(edmonton);
    }

    @Test
    public void testGetCities_emptyCityList_returnsEmptyList() {
        // Act
        List<City> cities = cityList.getCities();

        // Assert
        assertNotNull(cities);
        assertEquals(0, cities.size());
    }

    @Test
    public void testGetCities_returnsSortedList() {
        // Arrange - add cities in non-alphabetical order
        cityList.add(vancouver);  // V
        cityList.add(edmonton);   // E
        cityList.add(calgary);    // C

        // Act
        List<City> cities = cityList.getCities();

        // Assert - should be sorted: Calgary, Edmonton, Vancouver
        assertEquals(3, cities.size());
        assertEquals("Calgary", cities.get(0).getCityName());
        assertEquals("Edmonton", cities.get(1).getCityName());
        assertEquals("Vancouver", cities.get(2).getCityName());
    }

    @Test
    public void testGetCities_alreadySorted_remainsSorted() {
        // Arrange - add cities in alphabetical order
        cityList.add(calgary);
        cityList.add(edmonton);
        cityList.add(vancouver);

        // Act
        List<City> cities = cityList.getCities();

        // Assert
        assertEquals(3, cities.size());
        assertEquals("Calgary", cities.get(0).getCityName());
        assertEquals("Edmonton", cities.get(1).getCityName());
        assertEquals("Vancouver", cities.get(2).getCityName());
    }

    @Test
    public void testAdd_afterException_canStillAddOtherCities() {
        // Arrange
        cityList.add(edmonton);

        try {
            // Act - try to add duplicate
            cityList.add(edmonton);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Act - add a different city
        cityList.add(calgary);
        List<City> cities = cityList.getCities();

        // Assert - should have 2 cities
        assertEquals(2, cities.size());
        assertTrue(cities.contains(edmonton));
        assertTrue(cities.contains(calgary));
    }

    @Test
    public void testGetCities_singleCity_returnsSortedList() {
        // Arrange
        cityList.add(edmonton);

        // Act
        List<City> cities = cityList.getCities();

        // Assert
        assertEquals(1, cities.size());
        assertEquals("Edmonton", cities.get(0).getCityName());
    }
}

