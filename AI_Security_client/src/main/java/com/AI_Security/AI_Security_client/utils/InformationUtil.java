package com.AI_Security.AI_Security_client.utils;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.NetworkIF;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Persolute
 * @version 1.0
 * @description 获取主机信息工具类
 * @email 1538520381@qq.com
 * @date 2024/05/05 17:12
 */
public class InformationUtil {
    public static Object get() throws IOException {
        Map<String, Object> information = new HashMap<>();

        InetAddress inetAddress = InetAddress.getLocalHost();
        SystemInfo systemInfo = new SystemInfo();

        information.put("hostName", inetAddress.getHostName()); // 主机名称
        information.put("ipAddress", inetAddress.getHostAddress()); // ip地址
        information.put("systemName", System.getProperty("os.name")); // 系统名称版本号
        information.put("port", new ServerSocket(0).getLocalPort()); // 端口

        // 进程
        List<Map<String, Object>> osProcessList = new ArrayList<>();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        OSProcess[] osProcesses = operatingSystem.getProcesses(operatingSystem.getProcessCount(), OperatingSystem.ProcessSort.CPU);
        for (OSProcess osProcess : osProcesses) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", osProcess.getName()); // 进程名称
            map.put("processID", osProcess.getProcessID()); // 进程ID
            map.put("commandLine", osProcess.getCommandLine()); // 进程命令行
            map.put("residentSetSize", osProcess.getResidentSetSize()); // 内存占用大小（KB）
            osProcessList.add(map);
        }
        information.put("osProcesses", osProcessList);

        // CPU占用率
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        information.put("cpuUsageRate", 1.0 - (idle * 1.0 / totalCpu));

        // 内存占用率
        GlobalMemory memory = systemInfo.getHardware().getMemory();
        long totalByte = memory.getTotal();
        long acaliableByte = memory.getAvailable();
        information.put("memoryUsageRate", (totalByte - acaliableByte) * 1.0 / totalByte);

        // 网速
        List<Map<String, Object>> networkIFList = new ArrayList<>();
        NetworkIF[] networkIFs = systemInfo.getHardware().getNetworkIFs();
        for (NetworkIF networkIF : networkIFs) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", networkIF.getName()); // 接口名称
            map.put("packetsRecv", networkIF.getPacketsRecv()); // 接收速度（packets/s）
            map.put("packetsSent", networkIF.getPacketsSent()); // 发送速度（packets/s）
            networkIFList.add(map);
        }
        information.put("networkIFs", networkIFList);

        return information;
    }
}
