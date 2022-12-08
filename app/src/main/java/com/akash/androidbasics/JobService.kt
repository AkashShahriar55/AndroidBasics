package com.akash.androidbasics

import android.content.Intent
import androidx.core.app.JobIntentService


//As a result, many apps that rely on IntentService do not work properly when targeting Android 8.0 or higher.
// For this reason, Android Support Library 26.0.0 introduces a new JobIntentService class,
// which provides the same functionality as IntentService but uses jobs instead of
// services when running on Android 8.0 or higher.

/**
 * You can use JobIntentService as a replacement for IntentService that is compatible with newer versions of Android.
 */
class JobService: JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        TODO("Not yet implemented")
    }
}