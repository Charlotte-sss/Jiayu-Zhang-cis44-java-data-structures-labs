public class ItineraryTest {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        // Add some destinations
        Position<String> paris = itinerary.addLast("Eiffel Tower");
        Position<String> london = itinerary.addLast("Italy");
        itinerary.addLast("New York");

        // Insert a stop after Eiffel Tower
        itinerary.addAfter(paris, "Museum");

        // Insert a stop before Big Ben
        itinerary.addBefore(london, "London");

        System.out.println("Final Itinerary (using for-each loop):");
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }
    }
}
