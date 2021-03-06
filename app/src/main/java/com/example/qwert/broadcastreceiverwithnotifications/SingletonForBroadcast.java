package com.example.qwert.broadcastreceiverwithnotifications;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by Денис on 17.10.2016.
 */
public class SingletonForBroadcast {

    private static SingletonForBroadcast singlInstance = new SingletonForBroadcast();
    private static NotificationHead notificationHead = new NotificationHead();
    private Context globalContext;
    private HashMap<String, Integer> statesKeeper = new HashMap<String, Integer>();

    public static SingletonForBroadcast getInstance() {
        return singlInstance;
    }

    private SingletonForBroadcast() {
    }

    public Context getGlobalContext() {
        return globalContext;
    }

    public void setGlobalContext(Context globalContext) {
        this.globalContext = globalContext;
    }

    public void addValue(String key, int value){
        statesKeeper.put(key,value);
        notificationHead.outcomeOfSupply(statesKeeper);
    }

    public HashMap<String,Integer> getValue(){
        return statesKeeper;
    }
}
