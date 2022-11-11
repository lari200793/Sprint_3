import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class CreatingACourierWithoutLoginOrPassword {
    private ClientCourier clientCourier;
    private Courier courier;
    private String expectedMessage;
    private int expectedStatusCode;

    public CreatingACourierWithoutLoginOrPassword(Courier courier, String expectedMessage, int expectedStatusCode) {
        this.courier = courier;
        this.expectedMessage = expectedMessage;
        this.expectedStatusCode = expectedStatusCode;
    }
    @Parameterized.Parameters
    public static Object[][] getCourierData(){
        return new Object[][]{
                {CourierGenerator.getWithoutLogin(),"Недостаточно данных для создания учетной записи",400,},
                {CourierGenerator.getWithoutPassword(),"Недостаточно данных для создания учетной записи",400,},
                {CourierGenerator.getEmptyLogin(),"Недостаточно данных для создания учетной записи",400,},
                {CourierGenerator.getEmptyPassword(),"Недостаточно данных для создания учетной записи",400,},
                {CourierGenerator.getEmptyLoginAndPassword(),"Недостаточно данных для создания учетной записи",400,}
                };
    }

    @Before
    public void setUp() {
        clientCourier= new ClientCourier();
    }

    @Test
    @DisplayName("check post creating without password or login")
    public void checkPostCreatingWithoutPasswordOrLogin(){
       Response response =clientCourier.creatingCourier(courier);
                  response.then().assertThat().statusCode(expectedStatusCode)
                          .and()
                          .body("message", equalTo (expectedMessage));

        }
}
