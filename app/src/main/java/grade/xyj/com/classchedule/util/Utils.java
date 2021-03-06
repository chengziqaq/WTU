package grade.xyj.com.classchedule.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

import java.util.Random;

public class Utils {
    private static int[] colorList = new int[]{
            0xFF8AD297,
            0xFFF9A883,
            0xFF88CFCC,
            0xFFF19C99,
            0xFFF7C56B,
            0xFFD2A596,
            0xFF67BDDE,
            0xFF9CCF5A,
            0xFF9AB4CF,
            0xFFE593AD,
            0xFFE2C38A,
            0xFFB29FD2,
            0xFFE2C490,
            0xFFE2C490,
    };

    public static GradientDrawable
    getDrawable(Context context, int rgb,
                float radius, int stroke, int strokeColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(rgb);
        gradientDrawable.setCornerRadius(dip2px(context, radius));
        gradientDrawable.setStroke(dip2px(context, stroke), strokeColor);
        return gradientDrawable;
    }

    public static StateListDrawable
    getPressedSelector(Context context, int color, int pressedColor, float radius) {
        GradientDrawable normalD = getDrawable(context, color, radius, 0, 0);
        GradientDrawable pressedD = getDrawable(context, pressedColor, radius, 0, 0);

        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_pressed}, pressedD);
        drawable.addState(new int[]{}, normalD);
        return drawable;
    }

    private static Random random = new Random();

    public static int getRandomColor() {
        return colorList[random.nextInt(20) % colorList.length];
    }


    public static int dip2px(Context context, float dpValue) {
        return (int) (0.5f + dpValue * context.getResources().getDisplayMetrics().density);
    }

}


