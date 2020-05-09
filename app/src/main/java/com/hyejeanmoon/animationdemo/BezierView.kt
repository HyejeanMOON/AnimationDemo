package com.hyejeanmoon.animationdemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

class BezierView : View {

    private var path: Path = Path()

    private lateinit var paint: Paint

    private var h: Int = 0
    private var w: Int = 0

    private var controlPoint1: PointF = PointF()
    private var controlPoint2: PointF = PointF()

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        // 设置当前view的高和宽
        this.h = h
        this.w = w

        controlPoint1 = PointF(this.w.toFloat() / 4, 0F)
        controlPoint2 = PointF(this.w.toFloat() / 4 * 3, this.h.toFloat())
    }

    fun setValue(degree: Float) {
        val controlY = degree / 5000 * h

        controlPoint1 = PointF(this.w.toFloat() / 4, controlY)
        controlPoint2 = PointF(this.w.toFloat() / 4 * 3, this.h.toFloat() - controlY)

        invalidate()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint = Paint()

        // 重置path， 为的是防止重复绘制贝塞尔曲线，使画布上残留多条曲线
        path.reset()

        // 配置画笔paint
        paint.color = context.getColor(R.color.colorAccent)
        paint.strokeWidth = 2F
        paint.style = Paint.Style.STROKE

        // 设置左右两个基准点
        val pointLeft = PointF(0F, h / 2.toFloat())
        val pointRight = PointF(w.toFloat(), h / 2.toFloat())

        // 绘制左右基准点
        canvas?.drawPoint(pointLeft.x, pointLeft.y, paint)
        canvas?.drawPoint(pointRight.x, pointRight.y, paint)


        paint.color = context.getColor(R.color.colorPrimaryDark)

        // 为了绘制贝塞尔曲线，需要移动到其中一个基准点
        path.moveTo(pointLeft.x, pointLeft.y)

        // 根据基准点和控制点，绘制贝塞尔曲线
        path.cubicTo(
            controlPoint1.x,
            controlPoint1.y,
            controlPoint2.x,
            controlPoint2.y,
            pointRight.x,
            pointRight.y
        )

        // 在画布上画path
        canvas?.drawPath(path, paint)
    }

}
