package a.coordinatorbehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

/**
 * Created by chw on 30.08.16.
 */

@CoordinatorLayout.DefaultBehavior(MyBehavior.class)
public class MyView extends View {

	public MyView(Context context) {
		super(context);
		init();
	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
			@Override
			public boolean onPreDraw() {
				getViewTreeObserver().removeOnPreDrawListener(this);
				// Get view locations on screen
				final int[] cardioContainerLoc = new int[2];
				getLocationOnScreen(cardioContainerLoc);

				// Calculate how much of the cardioGoalContainer is not visible
				final int posDifference = cardioContainerLoc[1] + getHeight() - Utils.getScreenHeight(getContext());
				if (posDifference > 0) {
					// Move cardioGoalContainer up so it's fully visible to the user
					ViewCompat.animate(MyView.this).translationY(-posDifference)
							.translationZ(24)
							.setDuration(700).setStartDelay(500)
							.withStartAction(null)
							.withEndAction(() -> {
								ViewCompat.animate(MyView.this).setStartDelay(5000).translationY(0f).translationZ(0f);
							});

				} else {
					Toast.makeText(getContext(), "Container visible", Toast.LENGTH_SHORT).show();
				}

				return false;
			}
		});
	}

	public void moveBackToOrigin() {
		Log.d("CHW", "moveBack");
		ViewCompat.animate(this).cancel();
		ViewCompat.animate(MyView.this).setStartDelay(0).setDuration(50).translationY(0f).translationZ(0f);
	}
}
