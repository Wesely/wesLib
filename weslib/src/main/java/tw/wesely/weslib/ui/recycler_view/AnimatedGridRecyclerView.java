package tw.wesely.weslib.ui.recycler_view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.GridLayoutAnimationController;

/**
 * Created by Wesely on 2016/1/4.
 *
 * in onCreate():
 * if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
 *	setRecyclerAdapter(recyclerView);
 *
 * In Lollipop and newer, onEnterAnimationComplete will be called.
 * @Override public void onEnterAnimationComplete() {
 * 		super.onEnterAnimationComplete();
 * 		setRecyclerAdapter(recyclerView);
 * 		recyclerView.scheduleLayoutAnimation();
 * 		}
 *  }
 */
public class AnimatedGridRecyclerView  extends RecyclerView {
	public AnimatedGridRecyclerView(Context context) {
		super(context);
	}

	public AnimatedGridRecyclerView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AnimatedGridRecyclerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void setLayoutManager(LayoutManager layout) {
		if (layout instanceof GridLayoutManager){
			super.setLayoutManager(layout);
		} else {
			throw new ClassCastException("You should only use a GridLayoutManager with AnimatedGridRecyclerView.");
		}
	}

	@Override
	protected void attachLayoutAnimationParameters(View child, ViewGroup.LayoutParams params, int index, int count) {

		if (getAdapter() != null && getLayoutManager() instanceof GridLayoutManager){

			GridLayoutAnimationController.AnimationParameters animationParams =
					(GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;

			if (animationParams == null) {
				animationParams = new GridLayoutAnimationController.AnimationParameters();
				params.layoutAnimationParameters = animationParams;
			}

			int columns = ((GridLayoutManager) getLayoutManager()).getSpanCount();

			animationParams.count = count;
			animationParams.index = index;
			animationParams.columnsCount = columns;
			animationParams.rowsCount = count / columns;

			final int invertedIndex = count - 1 - index;
			animationParams.column = columns - 1 - (invertedIndex % columns);
			animationParams.row = animationParams.rowsCount - 1 - invertedIndex / columns;

		} else {
			super.attachLayoutAnimationParameters(child, params, index, count);
		}
	}
}
