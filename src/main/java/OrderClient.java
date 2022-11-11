import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.client.protocol.ResponseContentEncoding;

import static io.restassured.RestAssured.given;

public class OrderClient extends Client {
    @Step("Creation order")
    public Response orderCreation(Order order ){
               Response response =
                given()
                        .spec(getSpec())
                        .body(order)
                        .when()
                        .post("/api/v1/orders");
        return response;
    }
    @ Step(" Delete order")
    public void endOrder(Order order, int track){
                Response response =
                given()
                        .spec(getSpec())
                        .body(order)
                        .when()
                        .put("/api/v1/orders/cancel?track={jsonTrack}",track);
        response. then().statusCode(200);

    }
    @ Step(" order list ")
    public Response orderList(){
       return given()
                .spec(getSpec())
                .when()
                .get("/api/v1/orders");

    }
}
