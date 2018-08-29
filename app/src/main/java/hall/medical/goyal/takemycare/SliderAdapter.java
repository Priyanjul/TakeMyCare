package hall.medical.goyal.takemycare;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ImageView slideImage;
    TextView slideTitle, slideContent;


    public SliderAdapter(Context context){
        this.context = context;
    }

    //Arrays
    public int[] slideImages = {
            R.drawable.ic_wswipe1,
            R.drawable.ic_wswipe2,
            R.drawable.ic_wswipe3
    };

    public String[] slideTitles = {
            "Home Delivery, 24X7",
            "Get Your Medicines",
            "Get Your Test Reports"
    };

    public String[] slideContents = {
            "Something regarding home delivery of medicines which is relevant and amazing",
            "Something regarding uploading medicine & prescription which is relevant and amazing",
            "Something regarding blood test report which is relevant and amazing"

    };

    @Override
    public int getCount() {
        return slideTitles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        slideImage = view.findViewById(R.id.imageView);
        slideTitle = view.findViewById(R.id.txt_title);
        slideContent = view.findViewById(R.id.txt_content  );

        slideImage.setImageResource(slideImages[position]);
        slideTitle.setText(slideTitles[position]);
        slideContent.setText(slideContents[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }


}
