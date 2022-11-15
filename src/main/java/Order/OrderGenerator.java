package Order;

import Order.Order;
import com.github.javafaker.Faker;

import java.util.List;

public class OrderGenerator {
     static Faker faker = new Faker();
    public static String setFirstNameOrder(){
        return faker.address().firstName();
    }
    public static String setLastNameOrder(){
        return faker.address().lastName();
    }
    public static String setAddressOrder(){
        return faker.address().fullAddress();
    }
    public static String setMetroStationOrder(){
        return faker.address().streetAddress();
    }
    public static int setRentalTimeOrder(){
        return faker.number().randomDigit();
    }
    public static String setDeliveryDateOrder(){
        return faker.bothify("##-##-####");
    }
    public static String setCommentOrder(){
        return faker.letterify("??????????????????????? ???????? ??????");
    }
    public static String setPhoneOrder(){
        return faker.bothify("###########");
    }
    public static Order colourBlackAndGray (){
        return new Order(setFirstNameOrder(), setLastNameOrder(), setAddressOrder(), setMetroStationOrder(), setPhoneOrder(), setRentalTimeOrder(), setDeliveryDateOrder(), setCommentOrder(), List.of("BLACK", "GRAY"));
    }
    public static Order colourBlack(){
        return new Order(setFirstNameOrder(), setLastNameOrder(), setAddressOrder(), setMetroStationOrder(), setPhoneOrder(), setRentalTimeOrder(), setDeliveryDateOrder(), setCommentOrder(),List.of("BLACK"));
    }
    public static Order colourGray(){
        return new Order(setFirstNameOrder(), setLastNameOrder(), setAddressOrder(), setMetroStationOrder(), setPhoneOrder(), setRentalTimeOrder(), setDeliveryDateOrder(), setCommentOrder(),List.of("GRAY"));
    }
    public static Order colourNull(){
        return new Order(setFirstNameOrder(), setLastNameOrder(), setAddressOrder(), setMetroStationOrder(), setPhoneOrder(), setRentalTimeOrder(), setDeliveryDateOrder(), setCommentOrder(),null);
    }
    public static Order colourEmpty(){
        return new Order(setFirstNameOrder(), setLastNameOrder(), setAddressOrder(), setMetroStationOrder(), setPhoneOrder(), setRentalTimeOrder(), setDeliveryDateOrder(), setCommentOrder(),List.of(""));
    }


}

