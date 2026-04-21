package com.roundclock.app

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import java.util.*
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class CustomClockView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val calendar = Calendar.getInstance()
    
    // 颜色配置
    private var dialColor = Color.WHITE
    private var hourHandColor = Color.WHITE
    private var minuteHandColor = Color.WHITE
    private var secondHandColor = Color.parseColor("#FF5252")
    private var scaleColor = Color.parseColor("#CCCCCC")
    private var backgroundColor = Color.BLACK
    
    // 尺寸配置
    private var dialWidth = 4f
    private var hourHandWidth = 8f
    private var minuteHandWidth = 6f
    private var secondHandWidth = 2f
    
    private val updateRunnable = object : Runnable {
        override fun run() {
            invalidate()
            postDelayed(this, 1000)
        }
    }

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        post(updateRunnable)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeCallbacks(updateRunnable)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        val width = width.toFloat()
        val height = height.toFloat()
        val centerX = width / 2
        val centerY = height / 2
        val radius = min(width, height) / 2 - 20
        
        // 绘制背景
        canvas.drawColor(backgroundColor)
        
        // 绘制表盘外圈
        paint.color = dialColor
        paint.strokeWidth = dialWidth
        paint.style = Paint.Style.STROKE
        canvas.drawCircle(centerX, centerY, radius, paint)
        
        // 绘制刻度
        drawScale(canvas, centerX, centerY, radius)
        
        // 获取当前时间
        calendar.timeInMillis = System.currentTimeMillis()
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)
        
        // 绘制时针
        drawHourHand(canvas, centerX, centerY, radius, hour, minute)
        
        // 绘制分针
        drawMinuteHand(canvas, centerX, centerY, radius, minute)
        
        // 绘制秒针
        drawSecondHand(canvas, centerX, centerY, radius, second)
        
        // 绘制中心圆点
        paint.style = Paint.Style.FILL
        paint.color = dialColor
        canvas.drawCircle(centerX, centerY, 12f, paint)
    }
    
    private fun drawScale(canvas: Canvas, centerX: Float, centerY: Float, radius: Float) {
        paint.style = Paint.Style.STROKE
        
        for (i in 0 until 60) {
            val angle = Math.toRadians((i * 6 - 90).toDouble())
            val startRadius = if (i % 5 == 0) radius - 40 else radius - 20
            val endRadius = radius - 10
            
            paint.color = scaleColor
            paint.strokeWidth = if (i % 5 == 0) 4f else 2f
            
            val startX = centerX + startRadius * cos(angle).toFloat()
            val startY = centerY + startRadius * sin(angle).toFloat()
            val endX = centerX + endRadius * cos(angle).toFloat()
            val endY = centerY + endRadius * sin(angle).toFloat()
            
            canvas.drawLine(startX, startY, endX, endY, paint)
        }
    }
    
    private fun drawHourHand(canvas: Canvas, centerX: Float, centerY: Float, radius: Float, hour: Int, minute: Int) {
        val angle = Math.toRadians(((hour + minute / 60.0) * 30 - 90).toDouble())
        val handLength = radius * 0.5f
        
        paint.color = hourHandColor
        paint.strokeWidth = hourHandWidth
        paint.style = Paint.Style.STROKE
        
        val endX = centerX + handLength * cos(angle).toFloat()
        val endY = centerY + handLength * sin(angle).toFloat()
        
        canvas.drawLine(centerX, centerY, endX, endY, paint)
    }
    
    private fun drawMinuteHand(canvas: Canvas, centerX: Float, centerY: Float, radius: Float, minute: Int) {
        val angle = Math.toRadians((minute * 6 - 90).toDouble())
        val handLength = radius * 0.7f
        
        paint.color = minuteHandColor
        paint.strokeWidth = minuteHandWidth
        paint.style = Paint.Style.STROKE
        
        val endX = centerX + handLength * cos(angle).toFloat()
        val endY = centerY + handLength * sin(angle).toFloat()
        
        canvas.drawLine(centerX, centerY, endX, endY, paint)
    }
    
    private fun drawSecondHand(canvas: Canvas, centerX: Float, centerY: Float, radius: Float, second: Int) {
        val angle = Math.toRadians((second * 6 - 90).toDouble())
        val handLength = radius * 0.85f
        
        paint.color = secondHandColor
        paint.strokeWidth = secondHandWidth
        paint.style = Paint.Style.STROKE
        
        val endX = centerX + handLength * cos(angle).toFloat()
        val endY = centerY + handLength * sin(angle).toFloat()
        
        canvas.drawLine(centerX, centerY, endX, endY, paint)
    }
}
