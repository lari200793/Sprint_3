import java.util.List;

public class OrderGenerator {
    public static Order colourBlackAndGray (){
        return new Order("Timur", "Kormushev", "г.Москва, ул Красная площадь, д.1", " Сольники", "89999999999", 2, "2022-11-11", "Saske, come back to Konoha", List.of("BLACK", "GRAY"));
    }
    public static Order colourBlack(){
        return new Order("алексей","дементьев","Konoha, 142 apt.","площадь 1905", "89999999999", 2, "2022-11-11", "Saske, come back to Konoha",List.of("BLACK"));
    }
    public static Order colourGray(){
        return new Order("Timur", "Kormushev", "г.Москва, ул Красная площадь, д.1", " Сольники", "89999999999", 2, "2022-11-11", "Saske, come back to Konoha",List.of("GRAY"));
    }
    public static Order colourNull(){
        return new Order("Timur", "Kormushev", "г.Москва, ул Красная площадь, д.1", " Сольники", "89999999999", 2, "2022-11-11", "Saske, come back to Konoha",null);
    }
    public static Order colourEmpty(){
        return new Order("алексей","дементьев","Konoha, 142 apt.","площадь 1905", "89999999999", 2, "2022-11-11", "Saske, come back to Konoha",List.of(""));
    }


}

