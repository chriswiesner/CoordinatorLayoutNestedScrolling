package a.coordinatorbehavior;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by chw on 31.08.16.
 */
public class Utils {

	public static int getScreenHeight(Context c) {
		WindowManager windowManager = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();

		Point point = new Point();
		display.getSize(point);

		return point.y;
	}

}
