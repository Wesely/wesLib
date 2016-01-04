package tw.wesely.weslib.ui.cardview_recycle_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import tw.wesely.weslib.R;

public class RecycleCardViewStaggeredGridActivity extends AppCompatActivity {
	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);
		mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		mRecyclerView.setHasFixedSize(true);

		// use a linear layout manager
//		mLayoutManager = new LinearLayoutManager(this);
//		mLayoutManager = new GridLayoutManager(this, 2);
		mLayoutManager =new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
		mRecyclerView.setLayoutManager(mLayoutManager);

		// specify an adapter (see also next example)
		String[] sample = {"Sample 1","Sample\nSample 2","Sample 3","Sample 4","Sample 5","Sample 6",
				"Sample\nSample 7","Sample 8","Sample 9","SampleSample 0","Sample A","Sample B",
				"Sample C","Sample D","Sample\nSample E","Sample F","Sample G","Sample\nSample H"};
		mAdapter = new CardViewImageAndTitleAdapter(sample);
		mRecyclerView.setAdapter(mAdapter);

	}

}
