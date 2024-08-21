@file:JvmName("Lwjgl3Launcher")

package org.demo.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import org.demo.TicTacToe

/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
      return
    Lwjgl3Application(TicTacToe(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("libgdx-tic-tac-toe")
        setWindowedMode(800, 640)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
