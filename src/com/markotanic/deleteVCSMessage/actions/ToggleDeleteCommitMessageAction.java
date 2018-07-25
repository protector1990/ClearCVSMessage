package com.markotanic.deleteVCSMessage.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;
import com.markotanic.deleteVCSMessage.components.DeleteMessageSettingsComponent;

public class ToggleDeleteCommitMessageAction extends ToggleAction {

    private boolean selected;

    public ToggleDeleteCommitMessageAction() {
        getTemplatePresentation().setEnabled(true);
        init();
    }

    private void init() {
        DeleteMessageSettingsComponent component = DeleteMessageSettingsComponent.getInstance();
        component.subscribeToStateChangeEvents(newState -> selected = newState);
        selected = component.getDeleteMessageEnabled();
    }

    @Override
    public boolean isSelected(AnActionEvent e) {
        return selected;
    }

    @Override
    public void setSelected(AnActionEvent e, boolean state) {
        DeleteMessageSettingsComponent component = DeleteMessageSettingsComponent.getInstance();
        component.setShouldDeleteMessage(state);
        selected = state;
    }
}
