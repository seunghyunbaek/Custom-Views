package bset.hyun.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.EditText

class LinedEditText(context: Context, attrs: AttributeSet) : EditText(context, attrs) {
    private var mRect: Rect? = null
    private var mPaint: Paint? = null

    init {
        mRect = Rect()
        mPaint = Paint()
        mPaint?.apply {
            // Paint객체에 색상과 스타일을 입힌다.
            style = Paint.Style.STROKE // 선
            strokeWidth = 2f // 2f 굵기
            color = Color.BLACK // 선 색상
        }
    }

    // onDraw에서는 개발자가 원하는대로 구현할 수 있는 canvas가 제공한다.
    // 단, 3D 그래픽에는 적용되지 않으며, View대신 SurfaceView를 상속하여 별도의 쓰레드에서 그려야 한다.
    override fun onDraw(canvas: Canvas?) {
        var count:Int = lineCount // View안의 텍스트의 라인수가 몇개인지 가져온다.
        val r = mRect
        val paint = mPaint

        // EditText의 모든 라인에 밑줄을 그린다.
        for(i in 0..count-1 step 1) {
            // 현재 텍스트 라인의 베이스라인 좌표를 가져온다.
            val baseline = getLineBounds(i, r) // getLineBounds

            // Paint객체를 이용하여 밑줄을 그린다.
            // 밑줄과 글이 가까이 붙어 Y값을 키워준다. (baseline+7)
            canvas!!.drawLine(r!!.left.toFloat(), (baseline+7).toFloat(), r.right.toFloat(), (baseline+7).toFloat(), paint!!)
        }

        // super.onDraw()를 호출하며 마무리를 짓는다.
        super.onDraw(canvas)
    }
}