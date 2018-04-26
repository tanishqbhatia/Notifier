package in.co.notifier.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import in.co.notifier.R;

public class IntroductionViewPagerAdapter extends PagerAdapter {

    LayoutInflater inflater;
    int[] backgroundColors = new int[]{R.color.white, R.color.blue_500, R.color.green_500, R.color.red_500, R.color.black};
    int[] appNameColors = new int[]{R.color.black, R.color.white, R.color.white, R.color.white, R.color.white};
    int[] buttonBackgroundColors = new int[]{R.color.grey_500, R.color.blue_700, R.color.green_700, R.color.red_700, R.color.white};
    int[] buttonTextColors = new int[]{R.color.black, R.color.white, R.color.white, R.color.white, R.color.black};
    int[] introImages = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,};

    public IntroductionViewPagerAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View v = inflater.inflate(R.layout.introduction_vp_item, null);

        FrameLayout introductionFl = v.findViewById(R.id.introductionFl);
        ImageView introImageIv = v.findViewById(R.id.introImageIv);
        TextView appNameTv = v.findViewById(R.id.appNameTv);
        Button continueLoginBtn = v.findViewById(R.id.continueLoginBtn);

        int pos = position % 5;
        introductionFl.setBackgroundColor(backgroundColors[pos]);
        appNameTv.setTextColor(appNameColors[pos]);
        introImageIv.setImageResource(introImages[pos]);
        continueLoginBtn.setBackgroundColor(buttonBackgroundColors[pos]);
        continueLoginBtn.setTextColor(buttonTextColors[pos]);

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}