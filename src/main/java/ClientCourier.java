import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ClientCourier extends Client {
    @Step("creating courier ")
    public Response creatingCourier(Courier courier) {
      return given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post("/api/v1/courier");
        }
        @Step(" login courier")
    public Response loginCourier(Credentials courier) {
        return given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post("/api/v1/courier/login");
            }
        @Step( "delete courier")
    public void deleteCourier(int id){
        given()
                .spec(getSpec())
                .when()
                .delete("api/v1/courier/{jsonID}", id)
                .then().statusCode(200);
    }

}
