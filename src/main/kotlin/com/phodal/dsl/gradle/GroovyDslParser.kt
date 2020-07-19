package com.phodal.dsl.gradle

import com.intellij.openapi.application.ApplicationManager
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.phodal.dsl.gradle.GradleNameElement.from
import org.jetbrains.plugins.groovy.lang.psi.GroovyElementVisitor
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile
import org.jetbrains.plugins.groovy.lang.psi.GroovyPsiElement
import org.jetbrains.plugins.groovy.lang.psi.GroovyPsiElementVisitor
import org.jetbrains.plugins.groovy.lang.psi.api.statements.GrVariableDeclaration
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrApplicationStatement
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrAssignmentExpression
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrReferenceExpression
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.path.GrMethodCallExpression

class GroovyDslParser(val myPsiFile: GroovyFile, val dslFile: GradleBuildFile) : GradleDslNameConverter {
    private val INCOMPLETE_PARSING = "INCOMPLETE_PARSING"
    fun parse() {
        ApplicationManager.getApplication().assertReadAccessAllowed()
        myPsiFile.acceptChildren(GroovyPsiElementVisitor(object : GroovyElementVisitor() {
            override fun visitMethodCallExpression(e: GrMethodCallExpression) {
                process(e)
            }

            override fun visitAssignmentExpression(e: GrAssignmentExpression) {
                process(e)
            }

            override fun visitReferenceExpression(e: GrReferenceExpression) {
                process(e)
            }

            override fun visitApplicationStatement(e: GrApplicationStatement) {
                process(e)
            }

            override fun visitVariableDeclaration(e: GrVariableDeclaration) {
                process(e)
            }

            fun process(e: GroovyPsiElement) {
                parsePsi(e, dslFile)
            }
        }))
    }

    private fun parsePsi(psiElement: PsiElement, gradleDslFile: GradleDslFile) {
        var success = false
        if (psiElement is GrMethodCallExpression) {
            success = parseGrMethodCall(psiElement, gradleDslFile)
        } else if (psiElement is GrAssignmentExpression) {
            success = parseGrAssignment(psiElement, gradleDslFile)
        } else if (psiElement is GrApplicationStatement) {
            success = parseGrApplication(psiElement, gradleDslFile)
        } else if (psiElement is GrVariableDeclaration) {
            success = parseGrVariableDeclaration(psiElement, gradleDslFile)
        } else if (psiElement is GrReferenceExpression) {
            success = parseGrReference(psiElement, gradleDslFile)
        }
        if (!success) {
            gradleDslFile.notification(INCOMPLETE_PARSING).addUnknownElement(psiElement)
        }
    }

    private fun parseGrAssignment(psiElement: GrAssignmentExpression, gradleDslFile: GradleDslFile): Boolean {
        return true
    }

    private fun parseGrReference(psiElement: GrReferenceExpression, gradleDslFile: GradleDslFile): Boolean {
        return true
    }

    private fun parseGrVariableDeclaration(psiElement: GrVariableDeclaration, gradleDslFile: GradleDslFile): Boolean {
        return true
    }

    private fun parseGrApplication(statement: GrApplicationStatement, gradleDslFile: GradleDslFile): Boolean {
        val referenceExpression = PsiTreeUtil.getChildOfType(statement, GrReferenceExpression::class.java)
        val name = from(referenceExpression, this)

        return true
    }

    private fun parseGrMethodCall(psiElement: GrMethodCallExpression, gradleDslFile: GradleDslFile): Boolean {
        return true
    }

}
