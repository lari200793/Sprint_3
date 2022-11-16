import Order.OrderClient;
import Order.Order;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import Order.OrderGenerator;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderCreationTest {
    private Response response;
    private OrderClient orderClient;
 private Order order;
 private int expectedStatusCode;
    public OrderCreationTest(Order order, int expectedStatusCode) {
        this.order = order;
        this.expectedStatusCode = expectedStatusCode;
    }
    @Parameterized.Parameters
    public static Object[][] getOrderData() {

        return new Object[][]{
                {OrderGenerator.colourBlackAndGray(),201},
                {OrderGenerator.colourBlack(),201},
                {OrderGenerator.colourGray(),201},
                {OrderGenerator.colourNull(),201},
                {OrderGenerator.colourEmpty(),201}
               };
    }
    @Before
    public void setUp() {
        orderClient = new OrderClient();
        order =OrderGenerator.colourBlackAndGray();
    }
    @Test
    @DisplayName(" Creation order")
    public void orderCreation() {
       response = orderClient.orderCreation(order);
       System.out.println(OrderGenerator.setDeliveryDateOrder());
       response.then().statusCode(expectedStatusCode).and().body("track", notNullValue());
         }
    @After
    public void end (){
        Integer track = response.then().extract().path("track");
        orderClient.endOrder(order,track);
    }
}