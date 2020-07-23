package com.phodal.plugins.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.util.ArrayUtil
import com.intellij.util.SystemProperties
import com.phodal.plugins.gradle.GradleProjectInfo
import org.gradle.tooling.BuildActionExecuter
import org.gradle.tooling.GradleConnector
import org.gradle.tooling.LongRunningOperation
import org.gradle.tooling.ProjectConnection
import java.io.File


class GetGradleAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project!!
        val projectPath = project.basePath!!

        val isBuildWithGradle = GradleProjectInfo.isBuildWithGradle(project)

        val connector = GradleConnector.newConnector();
        connector.forProjectDirectory(File(projectPath));
        val connection: ProjectConnection = connector.connect()
        val operation: LongRunningOperation = connection.newBuild()

        val javaHome: String = SystemProperties.getJavaHome();
        operation.setJavaHome(File(javaHome))

        if (isBuildWithGradle) {
            val gradleTasks = arrayOf("assemble", "build").toList()
            (operation as BuildActionExecuter<*>).forTasks(*ArrayUtil.toStringArray(gradleTasks))

            connection.use {
                operation.run();
            }
        }
    }
}
