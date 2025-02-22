package com.hw.ycshareelement;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangwei on 2018/9/18 0018.
 */
public class TransitionHelper {
    public static final boolean ENABLE = Build.VERSION.SDK_INT >= 21;

    public static void enableTransition(Activity activity) {
        if (ENABLE) {
            activity.getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
    }

    public static ActivityOptionsCompat getTransitionBundle(Activity activity, View... shareViews) {
        if (!ENABLE || shareViews == null) {
            return null;
        }
        List<Pair<View, String>> pairs = new ArrayList<>();
        //添加ShareElements
        for (int i = 0; i < shareViews.length; i++) {
            View view = shareViews[i];
            pairs.add(Pair.create(view, view.getTransitionName()));
        }
        Pair<View, String>[] pairsArray = new Pair[pairs.size()];
        pairs.toArray(pairsArray);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairsArray);
        return options;
    }
}
