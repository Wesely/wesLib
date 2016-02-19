package tw.wesely.weslib.ui.recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Wesely on 2016/2/1.
 */
public class HideHeaderWhenScrollHelper {

	protected int oldDy = 0 ,screenBottom;
	final RecyclerView mRecyclerView;
	final View header;

	public HideHeaderWhenScrollHelper(RecyclerView mRecyclerView, RelativeLayout header) {
		this.mRecyclerView = mRecyclerView;
		this.header = header;
		screenBottom = mRecyclerView.getBottom();
	}

	public void enable(){
			mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
				@Override
				public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//					Log.d("onScroll", "dy=" + dy  + ", oldDy=" + oldDy+ ", y=" + header.getY()
//							 + " (HideHeaderWhenScrollHelper.java)");
					if ((oldDy + dy <= 1 && oldDy + dy >= -1)
					||(oldDy * dy<-5)){
						oldDy = dy;
						return;
					}
					oldDy = dy;
					header.setY(header.getY() - dy);
					float y = header.getY();
					float h = header.getHeight();
					if (y > 0)
						header.setY(0);
					else if (y + h < 0)
						header.setY(-h);
					recyclerView.setTop((int) (header.getY() + h));
				}
			});

	}
}
