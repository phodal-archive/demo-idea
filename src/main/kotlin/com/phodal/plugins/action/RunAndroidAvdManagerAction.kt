package com.phodal.plugins.action

import com.intellij.openapi.actionSystem.ActionPlaces
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class RunAndroidAvdManagerAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {}
    override fun update(event: AnActionEvent) {
        val presentation = event.presentation
        when (event.place) {
            ActionPlaces.TOOLBAR -> {
                // Layout editor device menu
                presentation.text = "Add Device Definition..."
                presentation.icon = null
            }
            ActionPlaces.UNKNOWN ->                 // run target menu
                presentation.text = "Open AVD Manager"
            else -> presentation.text = "AVD Manager"
        }
        presentation.isEnabled = true
    }
}
