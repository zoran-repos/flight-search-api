package org.trendoLand;

import org.flights.controller.FlightSearchController;
import org.flights.model.Flight;
import org.flights.service.FlightService;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FlightSearchControllerTest {

    private FlightService flightService = mock(FlightService.class);
    private FlightSearchController flightSearchController = new FlightSearchController(flightService);

    @Test
    void testSearchFlights_WithoutSort() {

        Flight flight1 = createFlight("A101", "AMS", "DEL", LocalTime.parse("11:00"), LocalTime.parse("17:00"), 850.0);
        Flight flight2 = createFlight("B101", "AMS", "BOM", LocalTime.parse("12:00"), LocalTime.parse("19:30"), 750.0);
        List<Flight> flights = Arrays.asList(flight1, flight2);


        when(flightService.searchFlights("AMS", "DEL", null)).thenReturn(flights);


        List<Flight> result = flightSearchController.searchFlights("AMS", "DEL", null);


        assertEquals(2, result.size());
        assertEquals("A101", result.get(0).getFlightNumber());
        assertEquals("AMS", result.get(0).getOrigin());
        assertEquals("DEL", result.get(0).getDestination());
        assertEquals(850.0, result.get(0).getPrice());
        assertEquals("B101", result.get(1).getFlightNumber());
        assertEquals("AMS", result.get(1).getOrigin());
        assertEquals("BOM", result.get(1).getDestination());
        assertEquals(750.0, result.get(1).getPrice());


        verify(flightService, times(1)).searchFlights("AMS", "DEL", null);
    }

    @Test
    void testSearchFlights_SortByPrice() {

        Flight flight1 = createFlight("A101", "AMS", "DEL", LocalTime.parse("11:00"), LocalTime.parse("17:00"), 850.0);
        Flight flight2 = createFlight("B101", "AMS", "BOM", LocalTime.parse("12:00"), LocalTime.parse("19:30"), 750.0);
        List<Flight> flights = Arrays.asList(flight2, flight1);  // Flights sorted by price


        when(flightService.searchFlights("AMS", "DEL", "price")).thenReturn(flights);


        List<Flight> result = flightSearchController.searchFlights("AMS", "DEL", "price");


        assertEquals(2, result.size());
        assertEquals("B101", result.get(0).getFlightNumber());
        assertEquals("AMS", result.get(0).getOrigin());
        assertEquals("BOM", result.get(0).getDestination());
        assertEquals(750.0, result.get(0).getPrice());
        assertEquals("A101", result.get(1).getFlightNumber());
        assertEquals("AMS", result.get(1).getOrigin());
        assertEquals("DEL", result.get(1).getDestination());
        assertEquals(850.0, result.get(1).getPrice());


        verify(flightService, times(1)).searchFlights("AMS", "DEL", "price");
    }

    private Flight createFlight(String flightNumber, String origin, String destination,
                                LocalTime departureTime, LocalTime arrivalTime, double price) {
        return new Flight() {
            @Override
            public String getFlightNumber() {
                return flightNumber;
            }

            @Override
            public String getOrigin() {
                return origin;
            }

            @Override
            public String getDestination() {
                return destination;
            }

            @Override
            public LocalTime getDepartureTime() {
                return departureTime;
            }

            @Override
            public LocalTime getArrivalTime() {
                return arrivalTime;
            }

            @Override
            public double getPrice() {
                return price;
            }
        };
    }
}
