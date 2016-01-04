package tw.wesely.weslib.ui.cardview_recycle_list;

/**
 * Created by Wesely on 2016/1/4.
 */
public class ViewModel {
	private String text;
	private String image;

	public ViewModel(String text, String image) {
		this. text = text;
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public String getImage() {
		return image;
	}
}