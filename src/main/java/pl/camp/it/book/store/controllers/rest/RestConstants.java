package pl.camp.it.book.store.controllers.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestConstants {
    public static String API_LOCATION;

    @Value("${api.location}")
    public void setApiLocation(String apiLocation) {
        RestConstants.API_LOCATION = apiLocation;
    }
}
