package com.example.geomachin

// Game.kt
import android.graphics.RectF
import java.util.*

class Game(private val screenWidth: Int, private val screenHeight: Int) {
    private val player: Player = Player(50f, screenHeight.toFloat(), 3f) // Initial player position
    private val obstacles: MutableList<Obstacle> = mutableListOf()

    init {
        generateObstacles()
    }

    fun update() {
        player.update()
        for (obstacle in obstacles) {
            // Update obstacle position
            // Implement logic according to your game mechanics
            obstacle.update(player.speed)
        }
        checkCollisions(player)
    }

    private fun generateObstacles() {
        // Generate obstacles randomly
        val random = Random()
        for (i in 0 until NUM_OBSTACLES) {
//            val obstacleX = screenWidth + i * 300f + random.nextInt(200)
//            val obstacleY = screenHeight - 50f - random.nextInt(200)
            val obstacleX = random.nextInt(screenWidth).toFloat()
            val obstacleY = random.nextInt(screenHeight).toFloat()

            val obstacle = if (random.nextBoolean()) {
                SquareObstacle(obstacleX, obstacleY)
            } else {
                TriangleObstacle(obstacleX, obstacleY)
            }
            obstacles.add(obstacle)
        }
    }

    fun checkCollisions(player: Player) {
//        val playerRect = RectF(player.positionX, player.positionY, player.positionX + Player.WIDTH, player.positionY + Player.HEIGHT)

        for (obstacle in obstacles) {
            val collides = obstacle.checkCollision(player)
            if (collides) {
                // Collision detected
                // Implement collision handling logic
            }
        }
    }


    fun getPlayer(): Player {
        return player
    }

    fun getObstacles(): List<Obstacle> {
        return obstacles
    }

    companion object {
        const val NUM_OBSTACLES = 100
    }
}
