package Courier;
import Client.Client;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ClientCourier extends Client {
    private  final String CREATING_LOGIN = "/api/v1/courier";
    private final String LOGIN_COURIER = "/api/v1/courier/login";
    private final String DELETE_COURIER = "api/v1/courier/{jsonID}";
    @Step("creating courier ")
    public Response creatingCourier(Courier courier) {
      return given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post(CREATING_LOGIN);
        }
        @Step(" login courier")
    public Response loginCourier(Credentials courier) {
        return given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post(LOGIN_COURIER);
            }
        @Step( "delete courier")
    public void deleteCourier(int id){
        given()
                .spec(getSpec())
                .when()
                .delete(DELETE_COURIER, id)
                .then().statusCode(200);
    }

}
