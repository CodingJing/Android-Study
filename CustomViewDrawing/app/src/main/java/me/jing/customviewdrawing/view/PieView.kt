package me.jing.customviewdrawing.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

private val RADIUS = 150f.px
private val ANGLES = floatArrayOf(60f, 90f, 150f, 60f)
private val COLORS = listOf(
    Color.parseColor("#FF1493"), Color.parseColor("#6A5ACD"),
    Color.parseColor("#00BFFF"), Color.parseColor("#3CB371"))
private val OFFSET_LENGTH=20f.px


class PieView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {


    }

    override fun onDraw(canvas: Canvas) {
        //画弧
        var startAngle=0f
        for ((index, angle) in ANGLES.withIndex()) {
            paint.color= COLORS[index]
            if (index==1){
                canvas.save()
                canvas.translate(
                    (OFFSET_LENGTH* cos(Math.toRadians((startAngle+angle/2f).toDouble()))).toFloat(),
                    (OFFSET_LENGTH* sin(Math.toRadians((startAngle+angle/2f).toDouble()))).toFloat()
                )
            }


            canvas.drawArc(
                width / 2f - 150f.px, height / 2f - 150f.px,
                width / 2f + 150f.px, height / 2f + 150f.px,
                startAngle, angle, true, paint)
            startAngle+=angle
            if (index==1){
                canvas.restore()
            }

        }


    }

}