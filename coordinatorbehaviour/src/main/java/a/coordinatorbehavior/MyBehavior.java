package a.coordinatorbehavior;

import android.support.design.widget.CoordinatorLayout;
import android.view.View;

/**
 * Created by chw on 30.08.16.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<MyView> {

	@Override
	public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, MyView child, View directTargetChild, View target, int
			nestedScrollAxes) {
		return true;
	}

	@Override
	public void onNestedScroll(CoordinatorLayout coordinatorLayout, MyView child, View target, int dxConsumed, int dyConsumed, int
			dxUnconsumed, int dyUnconsumed) {
		child.moveBackToOrigin();
	}
}
