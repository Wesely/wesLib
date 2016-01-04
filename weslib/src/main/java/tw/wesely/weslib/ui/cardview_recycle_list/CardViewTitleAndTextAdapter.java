package tw.wesely.weslib.ui.cardview_recycle_list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tw.wesely.weslib.R;


/**
 * Created by Wesely on 2015/12/30.
 */

public class CardViewTitleAndTextAdapter extends RecyclerView.Adapter<CardViewTitleAndTextAdapter.ViewHolder> {
	private static ArrayList<String> titles;
	private static ArrayList<String> texts;
	private static ArrayList<Intent> intents;
	private static Context ctx;
	private ViewGroup parent;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		// each data item is just a string in this case
		public CardView mCardView;

		public ViewHolder(CardView v) {
			super(v);
			mCardView = v;
			v.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			Log.d("ViewHolder", "title=" + titles.get(getAdapterPosition()));
			ctx.startActivity(intents.get(getAdapterPosition()));
		}
	}

	public CardViewTitleAndTextAdapter(ArrayList<String> titles, ArrayList<String> texts, ArrayList<Intent> intents) {
		this.intents = intents;
		this.titles = titles;
		this.texts = texts;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public CardViewTitleAndTextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
																	 int viewType) {
		this.ctx = parent.getContext();
		this.parent = parent;

		CardView v = (CardView) LayoutInflater.from(parent.getContext())
				.inflate(R.layout.cardview, parent, false);
//		v.setPreventCornerOverlap(false); // true: child view will overlap ON cards
//		v.setRadius(0);
//		v.setCardBackgroundColor(0xeeffee);
//		v.setCardElevation(20f);
//		v.setPadding(5,2,5,200);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_title_above_text, parent, false);
		TextView title = (TextView) v.findViewById(R.id.tvCVTitle);
		TextView text = (TextView) v.findViewById(R.id.tvCVText);
		title.setText(titles.get(position));
		text.setText(texts.get(position));
		holder.mCardView.addView(v);
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return titles.size();
	}
}