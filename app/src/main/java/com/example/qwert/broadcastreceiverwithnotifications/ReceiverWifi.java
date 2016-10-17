package com.example.qwert.broadcastreceiverwithnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

/**
 * Created by Денис on 18.10.2016.
 */
public class ReceiverWifi extends BroadcastReceiver {

    private Context wifiContext;
    private Intent wifiIntent;

    @Override
    public void onReceive(Context wifiContext, Intent wifiIntent) {
        this.wifiContext = wifiContext;
        this.wifiIntent = wifiIntent;
        statusCheck();
    }

    private void statusCheck() {
        int status = wifiIntent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
        switch (status) {
            case WifiManager.WIFI_STATE_DISABLED:
                MainActivity.setWifiStatus("OFF");
                SingletonForBroadcast.getInstance().addValue("wifi", 0);
                break;
            case WifiManager.WIFI_STATE_ENABLED:
                MainActivity.setWifiStatus("ON");
                SingletonForBroadcast.getInstance().addValue("wifi", 1);
                break;
        }
    }
}
