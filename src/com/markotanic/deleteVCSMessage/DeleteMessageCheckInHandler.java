package com.markotanic.deleteVCSMessage;

import com.intellij.openapi.vcs.VcsConfiguration;
import com.intellij.openapi.vcs.checkin.CheckinHandler;

public class DeleteMessageCheckInHandler extends CheckinHandler {

    private VcsConfiguration configuration;

    DeleteMessageCheckInHandler(VcsConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void checkinSuccessful() {
       configuration.LAST_COMMIT_MESSAGE = "";
    }
}
