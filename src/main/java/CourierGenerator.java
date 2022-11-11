public class CourierGenerator {
    public  static Courier getDefault(){
        return new Courier("Larisa1406", "123456", "LARISA");
    }
    public static Courier getInUppercase(){
        return new Courier( "LARI2E2E00793","122344785545","LARISA");
    }
    public static Courier getWithoutLogin(){
        return new Courier(null,"123456",null);
    }
    public static Courier getWithoutPassword(){
        return  new Courier("lari143503646",null,null);
    }
    public static Courier getEmptyPassword(){
        return new Courier("lari143503646","",null);
    }
    public static Courier getEmptyLogin(){
        return new Courier("","123456",null);
    }
    public static Courier getEmptyLoginAndPassword(){
        return new Courier("","",null);
    }
    public static Courier  authorization(){
        return new Courier("Larisa1406", "123456",null);
    }

    public static Courier authorizationWithInvalidPassword (){
        return new Courier("Larisa1406", "123456dfasd",null);
    }


}
