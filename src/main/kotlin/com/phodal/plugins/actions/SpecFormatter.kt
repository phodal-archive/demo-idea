package com.phodal.plugins.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.ui.Messages

class SpecFormatter : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        LOG.info("start")
        Messages.showErrorDialog("Error on formatting spec", "Format Error")
        WriteCommandAction.runWriteCommandAction(e.project) {

        }
    }

    companion object {
        private val LOG = Logger.getInstance("#com.phodal.SpecFormatter")
    }
}
