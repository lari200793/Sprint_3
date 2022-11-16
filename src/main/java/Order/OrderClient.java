package Order;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import Client.Client;
import static io.restassured.RestAssured.given;

public class OrderClient extends Client {
    private final String ORDER_CREATING = "/api/v1/orders";
    private final String ORDER_DELETE = "/api/v1/orders/cancel?track={jsonTrack}";
    private final String ORDER_LIST = "/api/v1/orders";
    @Step("Creation order")
    public Response orderCreation(Order order ){
               Response response =
                given()
                        .spec(getSpec())
                        .body(order)
                        .when()
                        .post(ORDER_CREATING);
        return response;
    }
    @ Step(" Delete order")
    public void endOrder(Order order, int track){
                Response response =
                given()
                        .spec(getSpec())
                        .body(order)
                        .when()
                        .put(ORDER_DELETE,track);
        response. then().statusCode(200);

    }
    @ Step(" order list ")
    public Response orderList(){
       return given()
                .spec(getSpec())
                .when()
                .get(ORDER_LIST);

    }
}
