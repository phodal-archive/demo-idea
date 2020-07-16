package com.phodal.plugins.template.services

import com.intellij.openapi.project.Project
import com.phodal.plugins.template.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
