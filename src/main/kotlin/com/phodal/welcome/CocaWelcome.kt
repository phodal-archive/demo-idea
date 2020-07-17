package com.phodal.welcome

import com.intellij.openapi.wm.WelcomeScreen
import javax.swing.JComponent
import javax.swing.JFrame

class CocaWelcome : WelcomeScreen {
    override fun setupFrame(frame: JFrame?) {
        frame!!.title = "Hello, World"
        frame.isVisible = true
    }

    override fun getWelcomePanel(): JComponent {
        TODO("Not yet implemented")
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }
}
