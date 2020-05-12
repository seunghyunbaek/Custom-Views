package bset.hyun.customviews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View


class CustomView : ConstraintLayout {

    private var boolKey: Boolean = false
    private var intKey: Int = 0
    private var stringKey: String? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)

        val a:TypedArray = context.getTheme().obtainStyledAttributes(
            attrs,
            R.styleable.CustomView,
            0, 0
        )

        try {
            boolKey = a.getBoolean(R.styleable.CustomView_boolKey, false)
            intKey = a.getInt(R.styleable.CustomView_intKey, 0)
            stringKey = a.getString(R.styleable.CustomView_stringKey);
        } finally {
            // release the TypedArray so that it can be reused.
            a.recycle()
        }

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
//        View.inflate(context, R.layout.cus)
        val view = View.inflate(context, R.layout.custom_layout, this)
        // ...
    }
}