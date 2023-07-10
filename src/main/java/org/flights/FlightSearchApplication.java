package org.flights;

import org.flights.util.DataLoaderUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class FlightSearchApplication {

    private final DataLoaderUtil dataLoaderUtil;

    public FlightSearchApplication(DataLoaderUtil dataLoaderUtil) {
        this.dataLoaderUtil = dataLoaderUtil;
    }

    public static void main(String[] args) {
        SpringApplication.run(FlightSearchApplication.class, args);
    }

    @PostConstruct
    public void init() {
        dataLoaderUtil.loadData();
    }
}
