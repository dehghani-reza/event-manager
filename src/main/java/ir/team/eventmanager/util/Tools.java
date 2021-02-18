package ir.team.eventmanager.util;

public class Tools {

    public static <T> T nvl(T actual,T reserve){
        if(actual==null) return reserve;
        return actual;
    }
}
