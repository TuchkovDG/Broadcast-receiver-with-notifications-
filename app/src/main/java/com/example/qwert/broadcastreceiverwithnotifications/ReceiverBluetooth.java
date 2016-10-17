package com.example.qwert.broadcastreceiverwithnotifications;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

/**
 * Created by Денис on 18.10.2016.
 */
public class ReceiverBluetooth extends BroadcastReceiver {

    private Context bluetoothContext;
    private Intent bluetoothIntent;

    @Override
    public void onReceive(Context wifiContext, Intent wifiIntent) {
        this.bluetoothContext = wifiContext;
        this.bluetoothIntent = wifiIntent;
        statusCheck();
    }

    private void statusCheck() {
        BluetoothAdapter bluetoothAdapter;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter.isEnabled()) {
            MainActivity.setBluetoothStatus("ON");
            SingletonForBroadcast.getInstance().addValue("bluetooth", 1);
        } else {
            MainActivity.setBluetoothStatus("OFF");
            SingletonForBroadcast.getInstance().addValue("bluetooth", 0);
        }
    }
}
