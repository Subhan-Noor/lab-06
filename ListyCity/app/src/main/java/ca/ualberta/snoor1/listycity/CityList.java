package ca.ualberta.snoor1.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 * It provides methods to add cities and retrieve a sorted list of cities.
 */
public class CityList {
    /**
     * The list of cities
     */
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist.
     *
     * @param city This is a candidate city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities.
     * The cities are sorted alphabetically by their city names.
     *
     * @return Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
}

