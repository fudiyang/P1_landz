package landz.fdy.com.p1_landz.landz;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by fudiyang on 2016/7/13.
 * Author fudiyang
 * Description :
 */
public class Myservice extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");

    }
}
