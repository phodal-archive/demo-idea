package com.phodal.welcome

import com.intellij.openapi.wm.WelcomeScreen
import com.intellij.openapi.wm.WelcomeScreenProvider
import javax.swing.JRootPane

class CocaWelcomeScreenProvider : WelcomeScreenProvider {
    override fun createWelcomeScreen(rootPane: JRootPane): WelcomeScreen? {
        return null
    }

    override fun isAvailable(): Boolean {
        return false
    }
}
