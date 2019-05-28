package com.example.maaedupro.views.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.example.maaedupro.R;





public class CustomTextView extends AppCompatTextView {

    private Context context;

    public CustomTextView(Context context) {
        super(context);
        this.context = context;
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray tarr = getContext().getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomTextView, 0, 0);
        final int N = tarr.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = tarr.getIndex(i);
            if (attr == R.styleable.CustomTextView_customFont) {
                String fontName = tarr.getString(R.styleable.CustomTextView_customFont);
                setFont(fontName);
            }
        }
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray tarr = getContext().getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomTextView, 0, 0);
        final int N = tarr.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = tarr.getIndex(i);
            if (attr == R.styleable.CustomTextView_customFont) {
                String fontName = tarr.getString(R.styleable.CustomTextView_customFont);
                setFont(fontName);
            }
        }
    }

    public void setFont(String fontName) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName);
        setTypeface(font);
    }
}
