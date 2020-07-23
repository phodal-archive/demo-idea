package com.phodal.plugins.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.phodal.plugins.gradle.GradleProjectInfo

class GetGradleAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project!!
        val projectPath = project.basePath!!

        val isBuildWithGradle = GradleProjectInfo.getInstance(project).isBuildWithGradle(project)
        if (project != null && isBuildWithGradle) {

        }
    }
}
