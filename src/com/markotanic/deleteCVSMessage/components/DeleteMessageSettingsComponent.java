package com.markotanic.deleteCVSMessage.components;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "delete-commit-messages-endabled", storages = {
        @Storage("DeleteCommitMessageSettings.xml")
})
public class DeleteMessageSettingsComponent implements PersistentStateComponent<DeleteMessageSettingsComponent> {
    public boolean deleteMessageOnCommit = true;


    public void toggleDeleteMessage() {
        deleteMessageOnCommit = !deleteMessageOnCommit;
    }


    public boolean getDeleteMessageEnabled() {
        return deleteMessageOnCommit;
    }

    @Nullable
    @Override
    public DeleteMessageSettingsComponent getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull DeleteMessageSettingsComponent var1) {
        this.deleteMessageOnCommit = var1.deleteMessageOnCommit;
    }
}
