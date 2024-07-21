package steps;

import io.restassured.response.ValidatableResponse;
import model.Courier;
import model.Order;

import static config.EndPoints.*;
import static io.restassured.RestAssured.given;

public class OrderSteps {
    public ValidatableResponse createOrder(Order order){
        return given()
                .body(order)
                .when()
                .post(ORDER)
                .then();
    }
    public ValidatableResponse getOrderList(){
        return given()
                .when()
                .get(ORDER)
                .then();
    }

}
