package com.markotanic.deleteVCSMessage.components;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@State(name = "delete-commit-messages-endabled", storages = {
        @Storage("deleteCommitMessage.xml")
})
public class DeleteMessageSettingsComponent implements PersistentStateComponent<DeleteMessageState> {
    private DeleteMessageState state;
    private List<Consumer<Boolean>> stateChangeObservers = new ArrayList<>(1);

    private static DeleteMessageSettingsComponent instance;
    public static DeleteMessageSettingsComponent getInstance() {
        return instance;
    }

    public DeleteMessageSettingsComponent() {
        instance = this;
    }

    public synchronized void toggleDeleteMessage() {
        state.shouldDelete = !state.shouldDelete;
        notifyObservers();
    }

    public synchronized void setShouldDeleteMessage(boolean shouldDeleteMessage) {
        state.shouldDelete = shouldDeleteMessage;
        notifyObservers();
    }

    public boolean getDeleteMessageEnabled() {
        return state.shouldDelete;
    }

    public void subscribeToStateChangeEvents(Consumer<Boolean> observer) {
        stateChangeObservers.add(observer);
    }

    private void notifyObservers() {
        for (Consumer<Boolean> observer : stateChangeObservers) {
            observer.accept(state.shouldDelete);
        }
    }

    @Nullable
    @Override
    public synchronized DeleteMessageState getState() {
        return state;
    }

    @Override
    public synchronized void loadState(@NotNull DeleteMessageState state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public synchronized void noStateLoaded() {
        if (state == null) {
            state = new DeleteMessageState();
            notifyObservers();
        }
    }
}
