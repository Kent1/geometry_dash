package com.example.geomachin

import android.view.View

// Player.kt
class Player(
    var positionX: Float,
    var positionY: Float,
    var speed: Float,
    var isJumping: Boolean = false,
    var isFalling: Boolean = false,
    var view: View? = null,
    ) {

    fun update() {
        // Update player position based on speed
//        positionX += speed
        // Add gravity if jumping
        if (isJumping) {
            positionY += JUMP_FORCE
            if (positionY >= JUMP_HEIGHT) {
                positionY = JUMP_HEIGHT
                isJumping = false
                isFalling = true
            }
        } else if (isFalling) {
            positionY -= GRAVITY
            if (positionY <= 0) {
                positionY = 0f
                isJumping = false
                isFalling = false
            }
        }
    }

    fun jump() {
        // Make the player jump
        if (!isJumping and !isFalling) {
            isJumping = true
            positionY += JUMP_FORCE
            view?.invalidate() // Redraw player view
        }
    }

    companion object {
        const val WIDTH = 150
        const val HEIGHT = 150
        const val GRAVITY = 10f
        const val JUMP_FORCE = 50f
        const val JUMP_HEIGHT = 200f
    }
}
