package com.phodal.plugins.actions

import com.intellij.openapi.actionSystem.ActionPlaces
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.util.Computable
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiManager

class RunGradleAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project!!
        val projectPath = project.basePath!!
        val myFile = LocalFileSystem.getInstance().findFileByPath("$projectPath/build.gradle")!!
//        val gradleFile = File(rootDir, "build.gradle")
//        val gradleDocument = FileDocumentManager.getInstance().getDocument(gradleFile.toVirtualFile()!!)!!

        val application = ApplicationManager.getApplication()
        val psiFile = application.runReadAction(Computable {
            PsiManager.getInstance(project).findFile(myFile)
        })
        println(psiFile!!.originalFile);
    }
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
