package com.markotanic.deleteCVSMessage.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.markotanic.deleteCVSMessage.components.DeleteMessageSettingsComponent;

public class ToggleDeleteCommitMessageAction extends AnAction {
    public ToggleDeleteCommitMessageAction() {
        super ("ToggleDeleteCommitMessageAction");
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        DeleteMessageSettingsComponent.getInstance().toggleDeleteMessage();
    }

    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setEnabled(true);
    }
}
