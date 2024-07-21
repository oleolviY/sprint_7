import model.Courier;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;

import static config.Constants.*;
import static org.hamcrest.Matchers.*;

public class CreateCourierNegativeTests extends AbstractTest{
    private CourierSteps courierSteps = new CourierSteps();
    private Courier courier;

    @Before
    public void setUp(){
        courier = new Courier();
    }

    @Test
    public void shouldReturnDuplicateMessage(){
        courier.setLogin(DUPLICATE_LOGIN);
        courier.setPassword(RandomStringUtils.randomAlphabetic(10));
        courierSteps
                .createCourier(courier)
                .statusCode(409)
                .body("message", equalTo(DUPLICATE_LOGIN_MESSAGE));
    }
    @Test
    public void shouldReturnNotEnoughDataWithOutLogin(){
        courier.setLogin("");
        courier.setPassword(RandomStringUtils.randomAlphabetic(10));
        courierSteps
                .createCourier(courier)
                .statusCode(400)
                .body("message", equalTo(ACCOUNT_NOT_ENOUGH_DATA));
    }
    @Test
    public void shouldReturnNotEnoughDataWithOutPassword(){
        courier.setLogin(RandomStringUtils.randomAlphabetic(10));
        courier.setPassword("");
        courierSteps
                .createCourier(courier)
                .statusCode(400)
                .body("message", equalTo(ACCOUNT_NOT_ENOUGH_DATA));
    }
}
