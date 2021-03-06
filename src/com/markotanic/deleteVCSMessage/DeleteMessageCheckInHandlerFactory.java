package com.markotanic.deleteVCSMessage;

import com.intellij.openapi.vcs.CheckinProjectPanel;
import com.intellij.openapi.vcs.VcsConfiguration;
import com.intellij.openapi.vcs.changes.CommitContext;
import com.intellij.openapi.vcs.checkin.CheckinHandler;
import com.intellij.openapi.vcs.checkin.CheckinHandlerFactory;
import com.markotanic.deleteVCSMessage.components.DeleteMessageSettingsComponent;
import org.jetbrains.annotations.NotNull;

public class DeleteMessageCheckInHandlerFactory extends CheckinHandlerFactory {
    @NotNull
    @Override
    public CheckinHandler createHandler(@NotNull CheckinProjectPanel checkinProjectPanel, @NotNull CommitContext commitContext) {
        if (DeleteMessageSettingsComponent.getInstance().getDeleteMessageEnabled()) {
            return new DeleteMessageCheckInHandler(VcsConfiguration.getInstance(checkinProjectPanel.getProject()));
        }
        else {
            return CheckinHandler.DUMMY;
        }
    }
}
