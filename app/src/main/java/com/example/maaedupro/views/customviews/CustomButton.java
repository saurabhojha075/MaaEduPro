package com.example.maaedupro.views.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import com.example.maaedupro.R;


/**
 * Created by Grappus on 01/06/18.
 */

public class CustomButton extends AppCompatButton {

    private Context context;

    public CustomButton(Context context) {
        super(context);
        this.context = context;
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray tarr = getContext().getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomButton, 0, 0);
        final int N = tarr.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = tarr.getIndex(i);
            if (attr == R.styleable.CustomButton_customFont) {
                String fontName = tarr.getString(R.styleable.CustomButton_customFont);
                setFont(fontName);
            }
        }
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray tarr = getContext().getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomButton, 0, 0);
        final int N = tarr.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = tarr.getIndex(i);
            if (attr == R.styleable.CustomButton_customFont) {
                String fontName = tarr.getString(R.styleable.CustomButton_customFont);
                setFont(fontName);
            }
        }
    }

    public void setFont(String fontName) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName);
        setTypeface(font);
    }
}
