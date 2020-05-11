package math;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Calculation {

    private Calculation(){};

    public static double distance(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2 ){

        double centerX1 = x1 + (width1/2.0);
        double centerY1 = y1 + (height1/2.0);
        double centerX2 = x2 + (width2/2.0);
        double centerY2 = y2 + (height2/2.0);

        double distance = sqrt(pow(centerX2 - centerX1,2) + pow(centerY2 - centerY1,2));

        return distance;
    }

    public static boolean isCursorOver(int cursorX, int cursorY, int objectX, int objectY, int width, int height ){

        if(cursorX >= objectX && cursorX <= objectX + width && cursorY >= objectY && cursorY <= objectY + height){
            return true;
        }
        else {
            return false;
        }
    }
}
