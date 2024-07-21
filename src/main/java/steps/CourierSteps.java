package steps;

import io.restassured.response.ValidatableResponse;
import model.Courier;

import static config.EndPoints.*;
import static io.restassured.RestAssured.given;

public class CourierSteps {
    public ValidatableResponse createCourier(Courier courier){
        return given()
                .body(courier)
                .when()
                .post(COURIER)
                .then();
    }
    public ValidatableResponse login(Courier courier) {
        return given()
                .body(courier)
                .when()
                .post(LOGIN)
                .then();
    }
    public ValidatableResponse delete(Courier courier) {
        return given()
                .pathParam("id", courier.getId())
                .when()
                .post(COURIER_DELETE)
                .then();
    }
}
