package com.example.foodieapp.SendNotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.example.foodieapp.ChefBNavigation;
import com.example.foodieapp.CustBNavigation;
import com.example.foodieapp.DelBNavigation;
import com.example.foodieapp.MainActivity;
import com.example.foodieapp.R;
import com.example.foodieapp.chefFoodPanel.ChefPreparedOrderView;
import com.example.foodieapp.customerFoodPanel.PayableOrders;

import java.util.Random;

public class ShowNotification {

    public static void ShowNotif(Context context, String title, String message, String page) {
        String CHANNEL_ID = "NOTICE";
        String CHANNEL_NAME = "NOTICE";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.enableVibration(true);
            channel.setLockscreenVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        Intent acIntent = new Intent(context, MainActivity.class);
        acIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        if (page.trim().equalsIgnoreCase("Order")) {
            acIntent = new Intent(context, ChefBNavigation.class).putExtra("PAGE", "Orderpage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("Payment")) {
            acIntent = new Intent(context, PayableOrders.class);
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("Home")) {
            acIntent = new Intent(context, CustBNavigation.class).putExtra("PAGE", "Homepage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("Confirm")) {
            acIntent = new Intent(context, ChefBNavigation.class).putExtra("PAGE", "Confirmpage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("Preparing")) {
            acIntent = new Intent(context, CustBNavigation.class).putExtra("PAGE", "Preparingpage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("Prepared")) {
            acIntent = new Intent(context, CustBNavigation.class).putExtra("PAGE", "Preparedpage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("DeliveryOrder")) {
            acIntent = new Intent(context, DelBNavigation.class).putExtra("PAGE", "DeliveryOrderpage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("DeliverOrder")) {
            acIntent = new Intent(context, CustBNavigation.class).putExtra("PAGE", "DeliverOrderpage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("AcceptOrder")) {
            acIntent = new Intent(context, ChefBNavigation.class).putExtra("PAGE", "AcceptOrderpage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("RejectOrder")) {
            acIntent = new Intent(context, ChefPreparedOrderView.class).putExtra("PAGE", "RejectOrderpage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("ThankYou")) {
            acIntent = new Intent(context, CustBNavigation.class).putExtra("PAGE", "ThankYoupage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }
        if (page.trim().equalsIgnoreCase("Delivered")) {
            acIntent = new Intent(context, ChefBNavigation.class).putExtra("PAGE", "Deliveredpage");
            pendingIntent = PendingIntent.getActivity(context, 0, acIntent, PendingIntent.FLAG_ONE_SHOT);
        }


        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(R.drawable.ic_pending_orders_24)
                .setColor(ContextCompat.getColor(context, R.color.Red))
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        int random = new Random().nextInt(9999 - 1) + 1;
        notificationManagerCompat.notify(random, nBuilder.build());
    }
}