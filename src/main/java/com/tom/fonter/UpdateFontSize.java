package com.tom.fonter;

import com.intellij.ide.ui.LafManager;
import com.intellij.ide.ui.UISettings;
import com.intellij.ide.ui.UISettingsState;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.EditorColorsScheme;

public class UpdateFontSize {

    static void updateFontSize(int anIncrement) {
        // Update editor & console font sizes
        EditorColorsManager myEditorColorsManager = EditorColorsManager.getInstance();
        EditorColorsScheme myScheme = myEditorColorsManager.getSchemeForCurrentUITheme();
        myScheme.setEditorFontSize(myScheme.getEditorFontSize() + anIncrement);
        myScheme.setConsoleFontSize(myScheme.getConsoleFontSize() + anIncrement);

        // Update look & feel font size
        UISettings mySettingsManager = UISettings.getInstance();
        UISettingsState mySettings = mySettingsManager.getState();
        mySettingsManager.setFontSize(mySettingsManager.getFontSize() + anIncrement);
        if (!mySettings.getOverrideLafFonts()) {
            mySettings.setOverrideLafFonts(true);
        }

        // Trigger propagation of the font size changes
        UISettings.getInstance().fireUISettingsChanged();
        LafManager.getInstance().updateUI();
        EditorFactory.getInstance().refreshAllEditors();
    }

}
