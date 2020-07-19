package com.phodal.dsl.gradle

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class GradleBuildFile(
        file: VirtualFile,
        project: Project,
        moduleName: String,
        context: BuildModelContext) : GradleDslFile(file, project, moduleName, context) {

}
