package com.example.qwert.broadcastreceiverwithnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

/**
 * Created by Денис on 18.10.2016.
 */
public class ReceiverAirplaneMode extends BroadcastReceiver {

    public Context airmodeContext;
    public Intent airmodeIntent;

    @Override
    public void onReceive(Context wifiContext, Intent wifiIntent) {
        this.airmodeContext = wifiContext;
        this.airmodeIntent = wifiIntent;
        statusCheck();
    }

    private void statusCheck() {
        boolean TrueOrFalse = Settings.System.getInt(
                SingletonForBroadcast.getInstance().getGlobalContext().getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) == 1;

        if (!TrueOrFalse) {
            MainActivity.setAirplaneModeStatus("ON");
            SingletonForBroadcast.getInstance().addValue("AirMode", 1);
        } else {
            MainActivity.setAirplaneModeStatus("OFF");
            SingletonForBroadcast.getInstance().addValue("AirMode", 0);
        }
    }
}
