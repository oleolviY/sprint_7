import model.Order;
import org.junit.Test;
import steps.OrderSteps;

import static org.hamcrest.Matchers.notNullValue;

public class OrderListTests extends AbstractTest{
    private OrderSteps orderSteps = new OrderSteps();
    private Order order;

    @Test
    public void shouldReturnOOrderList(){
        order = new Order();
        orderSteps
                .getOrderList()
                .statusCode(200)
                .body("orders", notNullValue());
    }
}
