package landz.fdy.com.p1_landz.landz.UI.welcome.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import landz.fdy.com.p1_landz.landz.UI.welcome.fragment.GuideFragment;

/**
 * Created by fudiyang on 2016/7/14.
 * Author fudiyang
 * Description :
 */
public class GuideAdapter extends FragmentPagerAdapter {

    public GuideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return GuideFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
