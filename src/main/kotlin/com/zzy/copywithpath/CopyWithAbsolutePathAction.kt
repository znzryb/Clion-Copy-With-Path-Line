package com.zzy.copywithpath

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ide.CopyPasteManager
import java.awt.datatransfer.StringSelection

class CopyWithAbsolutePathAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val psiFile = e.getData(CommonDataKeys.PSI_FILE) ?: return
        val virtualFile = psiFile.virtualFile ?: return

        val selection = editor.selectionModel
        val selectedText = selection.selectedText ?: return

        val doc = editor.document
        val startLine = doc.getLineNumber(selection.selectionStart) + 1
        val endLine = doc.getLineNumber(selection.selectionEnd) + 1
        val range = if (startLine == endLine) "$startLine" else "$startLine-$endLine"

        val header = "// ${virtualFile.path}:$range"
        val payload = "$header\n$selectedText"

        CopyPasteManager.getInstance().setContents(StringSelection(payload))
    }

    override fun update(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        e.presentation.isEnabledAndVisible = editor?.selectionModel?.hasSelection() == true
    }
}
