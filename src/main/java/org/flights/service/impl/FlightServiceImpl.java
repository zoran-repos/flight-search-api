package org.flights.service.impl;

import org.flights.model.Flight;
import org.flights.repository.FlightRepository;
import org.flights.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> searchFlights(String origin, String destination, String sort) {
        List<Flight> filteredFlights = flightRepository.findAllByOriginAndDestination(origin, destination);

        if (sort != null) {
            if (sort.equalsIgnoreCase("price")) {
                filteredFlights.sort(Comparator.comparingDouble(Flight::getPrice));
            } else if (sort.equalsIgnoreCase("duration")) {
                filteredFlights.sort(Comparator.comparing(flight ->
                        Duration.between(flight.getDepartureTime(), flight.getArrivalTime())));
            }
        }

        return filteredFlights;
    }
}
