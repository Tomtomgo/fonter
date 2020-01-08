package com.tom.fonter;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import static com.tom.fonter.UpdateFontSize.updateFontSize;

public class IncreaseFontSizeAction extends AnAction {
    public IncreaseFontSizeAction() {
        super("Increase Font Size");
    }

    public void actionPerformed(AnActionEvent anIgnoredEvent) {
        updateFontSize(2);
    }
}