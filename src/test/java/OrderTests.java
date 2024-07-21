import model.Order;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.OrderSteps;

import java.time.LocalDate;

import static config.Constants.PHONE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
@RunWith(Parameterized.class)
public class OrderTests extends AbstractTest{
    private OrderSteps orderSteps = new OrderSteps();
    private Order order;
    private String color;
    LocalDate currentDate = LocalDate.now();
    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"BLACK, GREY"},
                {"BLACK"},
                {"GREY"},
                {""},
        };
    }
    public OrderTests(String color){
       this.color = color;
    }

    @Test
    public void shouldReturnTrekNumber(){
        order = new Order();
        order.setFirstName(RandomStringUtils.randomAlphabetic(10));
        order.setLastName(RandomStringUtils.randomAlphabetic(10));
        order.setAddress(RandomStringUtils.randomAlphabetic(10));
        order.setMetroStation(RandomStringUtils.randomNumeric(1));
        order.setPhone(PHONE);
        order.setDeliveryDate(String.valueOf(currentDate));
        order.setComment(RandomStringUtils.randomAlphabetic(10));
        order.setColor(new String[]{color});
        orderSteps
                .createOrder(order)
                .statusCode(201)
                .body("track", notNullValue());
    }
}
