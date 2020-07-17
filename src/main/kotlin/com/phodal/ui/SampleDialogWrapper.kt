package com.phodal.ui

import com.intellij.openapi.ui.DialogWrapper
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

class SampleDialogWrapper : DialogWrapper(true) {
    public override fun createCenterPanel(): JComponent? {
        val dialogPanel = JPanel(BorderLayout())
        val label = JLabel("testing")
        label.preferredSize = Dimension(100, 100)
        dialogPanel.add(label, BorderLayout.CENTER)
        return dialogPanel
    }

    init {
        init()
        title = "Test DialogWrapper"
    }
}
