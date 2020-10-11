package me.nurio.microkernel.countermodule;

import lombok.Getter;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import me.nurio.microkernel.modules.KernelModule;

public class CounterModule extends KernelModule {

    @Getter private String name = "CounterModule";
    @Getter private String author = "Nurio";

    private final Timer timer = new Timer();
    private final AtomicInteger loopCount = new AtomicInteger(0);

    @Override
    public void onEnable() {
        System.out.println("The counting module was started!");

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.printf("Looped %d times.%n", loopCount.incrementAndGet());
            }
        };

        timer.schedule(task, 1000L, 1000L);
    }

    @Override
    public void onDisable() {
        timer.cancel();
        System.out.println("The counting module was stopped!");
    }

}