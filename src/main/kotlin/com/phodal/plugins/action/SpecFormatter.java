package com.phodal.plugins.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.ui.Messages;

public class SpecFormatter extends AnAction {
    private static final Logger LOG = Logger.getInstance("#com.phodal.SpecFormatter");
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        LOG.info("start");
        Messages.showErrorDialog("Error on formatting spec", "Format Error");
    }
}
