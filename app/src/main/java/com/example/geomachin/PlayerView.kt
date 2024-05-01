package com.example.geomachin
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class PlayerView(context: Context, private val player: Player) : View(context) {

    private val paint: Paint = Paint()
    var canvas: Canvas? = null // Expose Canvas

    init {
        paint.color = Color.RED // Set player color
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        this.canvas = canvas // Assign canvas to the property
        canvas.apply {
            // Draw the player square within the container
            drawRect(
                player.positionX,
                player.positionY,
                player.positionX + Player.WIDTH,
                player.positionY + Player.HEIGHT,
                paint
            )
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                player.jump() // Call jump method when screen is tapped
                invalidate() // Redraw player view
            }
        }
        return true
    }
}
