package org.booking.application.services;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookingServiceEndToEndTest {

    @Test
    public void testCreateBooking() {
        RestAssured.given()
                .contentType("application/json")
                .body("{\"clientName\":\"client\",\"carType\":\"carType\"}")
                .when().post("/bookings")
                .then()
                .statusCode(201)
                .body("clientName", is("client"),
                        "carType", is("carType"));
    }

    @Test
    public void testReadBookings() {
        RestAssured.given()
                .when().get("/bookings")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetBooking() {
        RestAssured.given()
                .when().get("/bookings/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void testUpdateBooking() {
        RestAssured.given()
                .contentType("application/json")
                .body("{\"clientName\":\"updatedClient\",\"carType\":\"updatedCarType\"}")
                .when().put("/bookings/1")
                .then()
                .statusCode(200)
                .body("clientName", is("updatedClient"),
                        "carType", is("updatedCarType"));
    }

    @Test
    public void testDeleteBooking() {
        RestAssured.given()
                .when().delete("/bookings/1")
                .then()
                .statusCode(204);
    }
}