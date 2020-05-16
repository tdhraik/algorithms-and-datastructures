package main.java.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class LoadBalancer {

    private static Map<String, Boolean> ipAddress = new ConcurrentHashMap<>();

    static {
        ipAddress = Map.of(
                "192.16.20.1", Boolean.TRUE,
                "192.19.12.2", Boolean.TRUE,
                "192.19.12.3", Boolean.TRUE,
                "192.19.12.4", Boolean.TRUE
        );
    }

    public static void main(String[] args) {
        System.out.println(getRandomIpAddress());
    }

    private static String getRandomIpAddress() {
        List<String> ipAddresses = new ArrayList<>();
        for( String ipAdd : ipAddress.keySet() ) {
            if( ipAddress.get(ipAdd) ) {
                ipAddresses.add(ipAdd);
            }
        }

        ipAddress.computeIfPresent("192.16.20.1", (k,v) -> ipAddress.put("192.16.20.5", Boolean.TRUE));
        int index = new Random().nextInt(ipAddresses.size() - 1);
        return ipAddresses.get(index);
    }
}
