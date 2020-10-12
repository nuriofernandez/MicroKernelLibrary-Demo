package me.nurio.microkernel.consolemodule;

import lombok.Getter;

import me.nurio.microkernel.consolemodule.cli.Console;
import me.nurio.microkernel.consolemodule.cli.CommandLineInterface;
import me.nurio.microkernel.modules.KernelModule;

public class ConsoleModule extends KernelModule {

    @Getter private String name = "ConsoleModule";
    @Getter private String author = "Nurio";

    @Getter private Console console = new Console();
    @Getter private CommandLineInterface cmd = new CommandLineInterface(console);

    @Override
    public void onEnable() {
        // Start the command line interface thread.
        cmd.start();

        System.out.println("The console module was started!");
    }

    @Override
    public void onDisable() {
        if (cmd.isAlive()) cmd.interrupt();
        System.out.println("The console module was stopped!");
    }

}