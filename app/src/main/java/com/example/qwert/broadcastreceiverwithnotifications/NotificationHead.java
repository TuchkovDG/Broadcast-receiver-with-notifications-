package com.example.qwert.broadcastreceiverwithnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.NotificationCompat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Денис on 18.10.2016.
 */
public class NotificationHead extends Notification {

    private HashMap<String, Integer> statesKeeper;
    private byte valueOfCounter;

    public void outcomeOfSupply(HashMap<String, Integer> statesKeeper) {
        this.statesKeeper = statesKeeper;
        checkKeeper();
    }

    private void checkKeeper() {
        valueOfCounter = 0;
        for (Map.Entry entry : statesKeeper.entrySet()) {
            int intialValue = (int) entry.getValue();
            if (intialValue == 1) {
                valueOfCounter++;
            } else {
                setContentTextInNotification(valueOfCounter);
            }
        }
    }

    private void setContentTextInNotification(int sumOn) {
        switch (sumOn) {
            case 1:
                notificationBuild("Ты вызвал интерес");
                break;
            case 2:
                notificationBuild("Они хотят с тобой поговорить");
                break;
            case 3:
                notificationBuild("За тобой уже выехали");
                break;
        }
    }

    private void notificationBuild(String contentText) {

        NotificationManager manager;
        NotificationCompat.Builder builder;
        builder = new NotificationCompat.Builder(SingletonForBroadcast.getInstance().getGlobalContext());
        builder.setContentTitle("Будь осторожен!");
        builder.setContentText(contentText);
        builder.setDefaults(DEFAULT_VIBRATE);
        builder.setSmallIcon(R.mipmap.ic_all_seeing_eye);
        Notification notification = builder.build();
        manager = (NotificationManager) SingletonForBroadcast.getInstance().
                getGlobalContext().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, notification);
    }
}
