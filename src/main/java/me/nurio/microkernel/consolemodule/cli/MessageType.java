package me.nurio.microkernel.consolemodule.cli;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.PrintStream;

@AllArgsConstructor
public enum MessageType {

    LOG(System.out),
    ERROR(System.err),
    DEBUG(System.out);

    @Getter private PrintStream printer;

}