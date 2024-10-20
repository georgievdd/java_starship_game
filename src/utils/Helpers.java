package utils;

import model.Living;
import model.unit.Unit;

import java.util.HashSet;

public class Helpers {


    public static boolean hasIntersect(Unit u1, Unit u2) {
        float left1 = (float) (u1.x - u1.modelWidth / 2.0);
        float right1 = (float) (u1.x + u1.modelWidth / 2.0);
        float top1 = (float) (u1.y - u1.modelHeight / 2.0);
        float bottom1 = (float) (u1.y + u1.modelHeight / 2.0);

        float left2 = (float) (u2.x - u2.modelWidth / 2.0);
        float right2 = (float) (u2.x + u2.modelWidth / 2.0);
        float top2 = (float) (u2.y - u2.modelHeight / 2.0);
        float bottom2 = (float) (u2.y + u2.modelHeight / 2.0);

        return right1 > left2 &&
                left1 < right2 &&
                bottom1 > top2 &&
                top1 < bottom2;
    }

    public static HashSet<Living> inHashSet(Living l) {
        HashSet<Living> hs = new HashSet<>();
        hs.add(l);
        return hs;
    }

}
