import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class CreatingACourierTest {
    private Courier courier;
    private ClientCourier clientCourier;

    public CreatingACourierTest(Courier courier, int expectedStatusCode, boolean expected) {
        this.courier = courier;
        this.expectedStatusCode = expectedStatusCode;
        this.expected = expected;
    }

    private int expectedStatusCode;
    private boolean expected;

    @Parameterized.Parameters
    public static Object[][] getCourierData(){
        return new Object[][]{
                {CourierGenerator.getDefault(),201,true},
                {CourierGenerator.getInUppercase(),201,true}
        };
    }

    @Before
    public void setUp() {
        clientCourier = new ClientCourier();

    }
    @Test
    @DisplayName("check post creating courier")
   public void checkPostCreatingCourier() {
        Response response = clientCourier.creatingCourier(courier);
                    response.then().assertThat().statusCode(expectedStatusCode)
                    .and().body("ok", equalTo(expected));

    }

    @Test
    @DisplayName("check post creating identical couriers")
    public void checkPostCreatingIdenticalCouriers (){

         clientCourier.creatingCourier(courier);
                       Response response1 =clientCourier.creatingCourier(courier);
                        response1.then().assertThat().statusCode(409)
                .and()
                .assertThat().body("message",equalTo( "Этот логин уже используется. Попробуйте другой."));
    }



      @After
      public void end(){

         Response response = clientCourier.loginCourier(Credentials.from(courier));
            Integer id = response.then().extract().path("id");
          if (id!=0){clientCourier.deleteCourier(id);}

    }

}
