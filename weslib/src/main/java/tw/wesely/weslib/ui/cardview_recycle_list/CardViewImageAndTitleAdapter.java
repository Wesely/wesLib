package tw.wesely.weslib.ui.cardview_recycle_list;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tw.wesely.weslib.R;


/**
 * Created by Wesely on 2015/12/30.
 */

public class CardViewImageAndTitleAdapter extends RecyclerView.Adapter<CardViewImageAndTitleAdapter.ViewHolder> {
	private String[] mDataset;
	private Context ctx;
	private ViewGroup parent;
	private boolean animate = true;

	// Provide a suitable constructor (depends on the kind of dataset)
    public CardViewImageAndTitleAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CardViewImageAndTitleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
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
                .inflate(R.layout.item_title_below_image, parent, false);
        TextView tv = (TextView) v.findViewById(R.id.tvCardViewTitle);
        tv.setText(mDataset[position]);
        holder.mCardView.removeAllViews();
        holder.mCardView.addView(v);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;

        public ViewHolder(CardView v) {
            super(v);
            mCardView = v;
        }
    }
}