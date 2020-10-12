package me.nurio.microkernel.consolemodule.cli;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class CommandLineInterface extends Thread {

    private final Console console;

    @SneakyThrows
    public void run() {
        while (true) {
            Thread.sleep(1000);
            String message = console.answerString("Insert your message:");
            console.printLog("ECHO: %s", message); // Default behavior, this can be moved to a listener.
        }
    }

}