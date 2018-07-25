package com.markotanic.deleteCVSMessage.components;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "delete-commit-messages-endabled", storages = {
        @Storage("deleteCommitMessage.xml")
})
public class DeleteMessageSettingsComponent implements PersistentStateComponent<DeleteMessageState> {
    private DeleteMessageState state;

    private static DeleteMessageSettingsComponent instance;
    public static DeleteMessageSettingsComponent getInstance() {
        return instance;
    }

    public DeleteMessageSettingsComponent() {
        instance = this;
    }

    public void toggleDeleteMessage() {
        state.shouldDelete = !state.shouldDelete;
    }

    public boolean getDeleteMessageEnabled() {
        return state.shouldDelete;
    }

    @Nullable
    @Override
    public DeleteMessageState getState() {
        return state;
    }

    @Override
    public void loadState(@NotNull DeleteMessageState state) {
        this.state = state;
    }

    @Override
    public void noStateLoaded() {
        if (state == null) {
            state = new DeleteMessageState();
        }
    }
}
