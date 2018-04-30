package in.co.notifier.utils.methods;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;

import in.co.notifier.modules.initial.activities.SplashActivity;
import in.co.notifier.utils.prefs.Prefs;

public class AppMethods {
    public static void showLog(String TAG, Object... messages) {
        StringBuilder builder = new StringBuilder();
        for (Object message : messages) {
            builder.append(String.valueOf(message));
            builder.append("\n");
        }
        String message = builder.substring(0, builder.lastIndexOf("\n"));
        Log.i(TAG, message);
    }

    public static void visible(View view) {
        if (view != null) {
            if (view.getVisibility() != View.VISIBLE) view.setVisibility(View.VISIBLE);
        }
    }

    public static void invisible(View view) {
        if (view != null) {
            if (view.getVisibility() != View.INVISIBLE) view.setVisibility(View.INVISIBLE);
        }
    }

    public static void gone(View view) {
        if (view != null) {
            if (view.getVisibility() != View.GONE) view.setVisibility(View.GONE);
        }
    }

    public static void enable(View view) {
        if (view != null) {
            if (!view.isEnabled()) view.setEnabled(true);
        }
    }

    public static void disable(View view) {
        if (view != null) {
            if (view.isEnabled()) view.setEnabled(false);
        }
    }

    public static void cleanSlateProtocol(Activity activity) {
        Prefs.clear();
        launchOnly(activity, SplashActivity.class);
    }

    public static void launch(Activity activity, Class targetClass) {
        activity.startActivity(new Intent(activity, targetClass));
    }

    public static void launchOnly(Activity activity, Class targetClass) {
        Intent intent = new Intent(activity, targetClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void changeBackgroundColor(final View view, int targetColor, int duration) {
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), ((ColorDrawable) view.getBackground()).getColor(), targetColor);
        colorAnimation.setDuration(duration);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                view.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }
}
