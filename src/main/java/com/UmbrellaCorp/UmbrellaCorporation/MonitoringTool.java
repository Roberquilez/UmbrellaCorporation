package com.UmbrellaCorp.UmbrellaCorporation;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class MonitoringTool {
    private static final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public static void printThreadInfo() {
        int threadCount = threadMXBean.getThreadCount();
        long[] threadIds = threadMXBean.getAllThreadIds();
        System.out.println("Número de hilos: " + threadCount);
        for (long id : threadIds) {
            System.out.println("Hilo ID: " + id + " - " + threadMXBean.getThreadInfo(id).getThreadName());
        }
    }
}

