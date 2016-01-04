package tw.wesely.weslib.ui.cardview_recycle_list;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import tw.wesely.weslib.R;


public class AnimGridViewActivity extends AppCompatActivity { //implements RecyclerViewAdapter.OnItemClickListener {

	public static final String AVATAR_URL = "http://lorempixel.com/200/200/people/1/";

	String[] sample = {"Sample 1","Sample 2","Sample 3","Sample 4","Sample 5","Sample 6",
			"Sample 7","Sample 8","Sample 9","Sample 0","Sample A","Sample B",
			"Sample C","Sample D","Sample E","Sample F","Sample G","Sample H"};

	private DrawerLayout drawerLayout;
	private View content;
	private RecyclerView recyclerView;
	private NavigationView navigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anim_grid_view);

		initRecyclerView();
		initFab();
		initToolbar();
//		setupDrawerLayout();

		content = findViewById(R.id.content);

		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
			setRecyclerAdapter(recyclerView);
		}
	}

	@Override public void onEnterAnimationComplete() {
		super.onEnterAnimationComplete();
		setRecyclerAdapter(recyclerView);
		recyclerView.scheduleLayoutAnimation();
	}

	private void initRecyclerView() {
		recyclerView = (RecyclerView) findViewById(R.id.recycler);
		recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
	}

	private void setRecyclerAdapter(RecyclerView recyclerView) {
		Log.d("AnimGridActivity", "set adapter");
		CardViewImageAndTitleAdapter adapter = new CardViewImageAndTitleAdapter(sample);
//		TODO: adapter.setOnItemClickListener(this);
		recyclerView.setAdapter(adapter);
	}

	private void initFab() {
		findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				Snackbar.make(content, "FAB Clicked", Snackbar.LENGTH_SHORT).show();
			}
		});
	}

	private void initToolbar() {
		final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		final ActionBar actionBar = getSupportActionBar();

		if (actionBar != null) {
			actionBar.setHomeAsUpIndicator(android.R.drawable.ic_input_add);
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

//	private void setupDrawerLayout() {
//		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//
//		navigationView = (NavigationView) findViewById(R.id.navigation_view);
//		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//			@Override public boolean onNavigationItemSelected(MenuItem menuItem) {
//				Snackbar.make(content, menuItem.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
//				menuItem.setChecked(true);
//				drawerLayout.closeDrawers();
//				return true;
//			}
//		});
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				drawerLayout.openDrawer(GravityCompat.START);
				return true;
		}

		return super.onOptionsItemSelected(item);
	}

//	@Override public void onItemClick(View view, ViewModel viewModel) {
//		DetailActivity.navigate(this, view.findViewById(R.id.image), viewModel);
//	}
}