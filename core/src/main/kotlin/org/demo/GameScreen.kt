package org.demo

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.ScreenUtils


class GameScreen(private val game: TicTacToe) : Screen {

    private val camera: OrthographicCamera = OrthographicCamera()
    private val shapeRenderer: ShapeRenderer = ShapeRenderer()

    // game screen size
    private val vWidth = 800f
    private val vHeight = 640f

    // grid points
    private val vWidthGridPadding = 70f
    private val vHeightGridPadding = 60f
    private val ticTacToeSpaceWidth = (vWidth - vWidthGridPadding*2) / 3
    private val ticTacToeSpaceHeight = (vHeight - vHeightGridPadding*2) / 3
    // vertical points
    private val topLeftVerticalGrid: Vector2 = Vector2(vWidthGridPadding + ticTacToeSpaceWidth, vHeight - vHeightGridPadding)
    private val bottomLeftVerticalGrid: Vector2 = Vector2(vWidthGridPadding + ticTacToeSpaceWidth, vHeightGridPadding)
    private val topRightVerticalGrid: Vector2 = Vector2(vWidth - vWidthGridPadding - ticTacToeSpaceWidth, vHeight - vHeightGridPadding)
    private val bottomRightVerticalGrid: Vector2 = Vector2(vWidth - vWidthGridPadding - ticTacToeSpaceWidth, vHeightGridPadding)
    // horizontal points
    private val topLeftHorizontalGrid: Vector2 = Vector2(vWidthGridPadding, vHeight - vHeightGridPadding - ticTacToeSpaceHeight)
    private val topRightHorizontalGrid: Vector2 = Vector2(vWidth - vWidthGridPadding, vHeight - vHeightGridPadding - ticTacToeSpaceHeight)
    private val bottomLeftHorizontalGrid: Vector2 = Vector2(vWidthGridPadding, vHeightGridPadding + ticTacToeSpaceHeight)
    private val bottomRightHorizontalGrid: Vector2 = Vector2(vWidth - vWidthGridPadding, vHeightGridPadding + ticTacToeSpaceHeight)


    init {
        camera.setToOrtho(false, vWidth, vHeight)
    }

    override fun show() {
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(0f, 0f, 0f, 1f)

        camera.update()

        // draw grid lines
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
        shapeRenderer.setColor(1f,1f,1f,1f)
        shapeRenderer.line(topLeftVerticalGrid, bottomLeftVerticalGrid)
        shapeRenderer.line(topRightVerticalGrid, bottomRightVerticalGrid)
        shapeRenderer.line(topLeftHorizontalGrid, topRightHorizontalGrid)
        shapeRenderer.line(bottomLeftHorizontalGrid, bottomRightHorizontalGrid)
        shapeRenderer.end()

    }

    override fun resize(width: Int, height: Int) {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
        shapeRenderer.dispose()
        game.dispose()
    }
}
