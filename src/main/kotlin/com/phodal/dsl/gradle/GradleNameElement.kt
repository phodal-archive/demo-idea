package com.phodal.dsl.gradle

import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrReferenceExpression

object GradleNameElement {
    @JvmStatic
    fun from(referenceExpression: GrReferenceExpression?, groovyDslParser: GroovyDslParser?): GradleNameElement? {
        return null
    }
}
