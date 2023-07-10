package org.flights.service;

import org.flights.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> searchFlights(String origin, String destination, String sort);
}
