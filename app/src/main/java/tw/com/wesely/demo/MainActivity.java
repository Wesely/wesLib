package tw.com.wesely.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import tw.wesely.weslib.ui.cardview_recycle_list.AnimGridViewActivity;
import tw.wesely.weslib.ui.cardview_recycle_list.CardViewTitleAndTextAdapter;
import tw.wesely.weslib.ui.cardview_recycle_list.RecycleCardViewDoubleColumnActivity;
import tw.wesely.weslib.ui.cardview_recycle_list.RecycleCardViewSingleColumnActivity;
import tw.wesely.weslib.ui.cardview_recycle_list.RecycleCardViewStaggeredGridActivity;
import tw.wesely.weslib.ui.scrollview_fab.ScrollingActivity;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {
	private RecyclerView rv;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	ArrayList<String> titles;
	ArrayList<String> texts;
	ArrayList<Intent> intents;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);

		Log.d("MainPage", "test");
		rv = (RecyclerView) findViewById(R.id.main_recycler);
		rv.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(this);
		rv.setLayoutManager(mLayoutManager);
		titles = new ArrayList<>();
		texts = new ArrayList<>();
		intents = new ArrayList<>();
		/** SET CONTENT OF MAIN **/
		setContent();
		mAdapter = new CardViewTitleAndTextAdapter(titles, texts, intents);
		rv.setAdapter(mAdapter);
		rv.setClickable(true);
		rv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("Recycler View", "onClick id=" + v.getId());
			}
		});
	}

	private void setContent() {
		titles.add(getString(R.string.demo_cardView_recycler));
		texts.add(getString(R.string.detail_cardView_recycler));
		intents.add(new Intent(getApplicationContext(),RecycleCardViewSingleColumnActivity.class));

		titles.add(getString(R.string.demo_scrollView_fab));
		texts.add(getString(R.string.detail_scrollView_fab));
		intents.add(new Intent(getApplicationContext(),ScrollingActivity.class));

		titles.add(getString(R.string.demo_recycler_grid));
		texts.add(getString(R.string.detail_recycler_grid));
		intents.add(new Intent(getApplicationContext(),RecycleCardViewDoubleColumnActivity.class));

		titles.add(getString(R.string.demo_recycler_staggered_grid));
		texts.add(getString(R.string.detail_recycler_staggered_grid));
		intents.add(new Intent(getApplicationContext(),RecycleCardViewStaggeredGridActivity.class));

		titles.add(getString(R.string.demo_anim_grid_view));
		texts.add(getString(R.string.detail_anim_grid_view));
		intents.add(new Intent(getApplicationContext(),AnimGridViewActivity.class));
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_camera) {
			// Handle the camera action
		} else if (id == R.id.nav_gallery) {

		} else if (id == R.id.nav_slideshow) {

		} else if (id == R.id.nav_manage) {

		} else if (id == R.id.nav_share) {

		} else if (id == R.id.nav_send) {

		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
