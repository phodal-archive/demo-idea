package com.phodal.dsl.gradle

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement

abstract class GradleDslFile(file: VirtualFile, project: Project, moduleName: String, context: BuildModelContext) {
    fun notification(any: String): GradleDslFile {
        return this
    }

    fun addUnknownElement(psiElement: PsiElement): GradleDslFile {
        return this
    }

}
