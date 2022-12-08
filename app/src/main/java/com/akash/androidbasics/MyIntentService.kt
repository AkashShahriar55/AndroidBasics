package com.akash.androidbasics

import android.app.IntentService
import android.content.Intent


// Not recommented
/**
 * With Android 8.0, there is a complication;
 * the system doesn't allow a background app to create a background service.
 * For this reason, Android 8.0 introduces the new method startForegroundService()
 * to start a new service in the foreground. After the system has created the service,
 * the app has five seconds to call the service's startForeground() method
 * to show the new service's user-visible notification.
 * If the app does not call startForeground() within the time limit,
 * the system stops the service and declares the app to be ANR.
 *
 */


//As a result, many apps that rely on IntentService do not work properly when targeting Android 8.0 or higher.
// For this reason, Android Support Library 26.0.0 introduces a new JobIntentService class,
// which provides the same functionality as IntentService but uses jobs instead of
// services when running on Android 8.0 or higher.

//Moreover, it's deprecated starting with Android 11.
class MyIntentService(name:String): IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        TODO("Not yet implemented")
    }
}