import model.Courier;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;

import static config.Constants.*;
import static org.hamcrest.Matchers.equalTo;

public class LoginCourierNegativeTests extends AbstractTest{
    private CourierSteps courierSteps = new CourierSteps();
    private Courier courier;

    @Before
    public void setUp(){
        courier = new Courier();
    }

    @Test
    public void loginWithOutLogin(){
        courier.setLogin("");
        courier.setPassword(RandomStringUtils.randomAlphabetic(10));
        courierSteps
                .login(courier)
                .statusCode(400)
                .body("message", equalTo(LOGIN_NOT_ENOUGH_DATA));
    }
    @Test
    public void loginWithOutPassword(){
        courier.setLogin(RandomStringUtils.randomAlphabetic(10));
        courier.setPassword("");
        courierSteps
                .login(courier)
                .statusCode(400)
                .body("message", equalTo(LOGIN_NOT_ENOUGH_DATA));
    }
    @Test
    public void loginWithIncorrectLogin(){
        courier.setLogin(INCORRECT_LOGIN);
        courier.setPassword(RandomStringUtils.randomAlphabetic(10));
        courierSteps
                .login(courier)
                .statusCode(404)
                .body("message", equalTo(LOGIN_INCORRECT_DATA));
    }
    @Test
    public void loginWithIncorrectPassword(){
        courier.setLogin(RandomStringUtils.randomAlphabetic(10));
        courier.setPassword(INCORRECT_PASSWORD);
        courierSteps
                .login(courier)
                .statusCode(404)
                .body("message", equalTo(LOGIN_INCORRECT_DATA));
    }
}
