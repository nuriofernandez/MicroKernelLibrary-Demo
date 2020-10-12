package me.nurio.microkernel.consolemodule.events;

import lombok.*;
import me.nurio.events.handler.Event;
import me.nurio.events.handler.EventCancellable;
import me.nurio.microkernel.consolemodule.cli.MessageType;

@Data
@RequiredArgsConstructor
public class ConsoleMessageOutputEvent extends Event implements EventCancellable {

    @Getter @Setter private boolean cancelled;

    @NonNull private MessageType type;
    @NonNull private String message;

}