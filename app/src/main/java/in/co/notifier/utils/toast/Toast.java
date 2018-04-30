package in.co.notifier.utils.toast;

import android.app.Activity;
import android.view.Gravity;

import in.co.notifier.R;
import in.co.notifier.utils.methods.AppMethods;

public class Toast {
    private int priority = ToastBuilder.PRIORITY_NORMAL;
    private int duration = ToastBuilder.LENGTH_SHORT;
    private int color = R.color.blue_500;


    private Toast priority(int activity_priority) {
        priority = activity_priority;
        return this;
    }

    private Toast duration(int activity_duration) {
        duration = activity_duration;
        return this;
    }

    private Toast color(int activity_color) {
        color = activity_color;
        return this;
    }

    public ToastBuilder message(Activity activity, String... messages) {
        try {
            if (messages != null) {
                StringBuilder builder = new StringBuilder();
                for (String message : messages) {
                    builder.append(message);
                    builder.append("\n");
                }
                String message = builder.substring(0, builder.lastIndexOf("\n"));
                ToastBuilder.Style style = new ToastBuilder.Style(duration, color);
                ToastBuilder toastBuilder = ToastBuilder.makeText(activity, message, style);
                toastBuilder.setLayoutGravity(Gravity.BOTTOM);
                toastBuilder.setPriority(priority);
                return toastBuilder;
            } else return null;
        } catch (Exception e) {
            AppMethods.showLog("Toast", "message()", e.getMessage());
        }
        return null;
    }

    public Toast priorityLow() {
        priority(ToastBuilder.PRIORITY_LOW);
        return this;
    }

    public Toast priorityNormal() {
        priority(ToastBuilder.PRIORITY_NORMAL);
        return this;
    }

    public Toast priorityHigh() {
        priority(ToastBuilder.PRIORITY_HIGH);
        return this;
    }

    public Toast colorBlue() {
        color(R.color.blue_500);
        return this;
    }

    public Toast colorRed() {
        color(R.color.red_500);
        return this;
    }

    public Toast colorGreen() {
        color(R.color.green_500);
        return this;
    }

    public Toast durationShort() {
        duration(ToastBuilder.LENGTH_SHORT);
        return this;
    }

    public Toast durationLong() {
        duration(ToastBuilder.LENGTH_LONG);
        return this;
    }

    public Toast durationSticky() {
        duration(ToastBuilder.LENGTH_STICKY);
        return this;
    }

    public Toast durationCustom(int duration) {
        duration(duration);
        return this;
    }
}
