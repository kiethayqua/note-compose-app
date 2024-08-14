package com.example.notecompose

import android.app.Application
import co.vulcanlabs.library.managers.BillingClientManager
import co.vulcanlabs.library.managers.ReferrerManager
import co.vulcanlabs.library.objects.MyPair
import co.vulcanlabs.library.views.BaseApplication
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp

// NOTE: Template for creating new application
@HiltAndroidApp
class NoteApp: BaseApplication() {

    override fun allowLoggingEventTracking(): Boolean {
        return false
    }

    override fun getBillingManager(): BillingClientManager {
        return BillingClientManager(this)
    }

    override fun getRemoteConfigList(): List<MyPair<String, Any>> {
        return emptyList()
    }

    override fun applyTestVersion(): Boolean {
        return false
    }

    override fun getIapItemJsonConfig(): String {
        return ""
    }

    override fun getDirectStoreJsonConfig(): String {
        return ""
    }

    override fun getReferrerManager(): ReferrerManager {
        return ReferrerManager(this, Firebase.analytics)
    }

    override fun getRemoteConfigDefault(): Int? {
        return null
    }

    override fun getPublicKeyOfGoogle(): String {
        return ""
    }

    override fun getJsonVerifyPurchase(): Int {
        return 0
    }

    override fun remoteConfigFetched(
        loadFromPreviousVersion: Boolean,
        configUpdated: Boolean,
        fetchSuccess: Boolean
    ) {

    }

}
//@HiltAndroidApp
//class NoteApp: Application()