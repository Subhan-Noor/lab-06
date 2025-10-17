package ca.ualberta.snoor1.listycity;

/**
 * This is a class that defines a City.
 * A City consists of a city name and a province name.
 * Cities can be compared to each other based on their city names for sorting purposes.
 */
public class City implements Comparable<City> {
    /**
     * The name of the city
     */
    private String city;
    
    /**
     * The name of the province
     */
    private String province;

    /**
     * Constructs a new City with the specified city and province names.
     *
     * @param city the name of the city
     * @param province the name of the province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of the city.
     *
     * @return the city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Returns the name of the province.
     *
     * @return the province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city with another city based on the city name.
     * The comparison is done lexicographically.
     *
     * @param o the city to be compared
     * @return a negative integer, zero, or a positive integer as this city's name
     *         is less than, equal to, or greater than the specified city's name
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }
}

