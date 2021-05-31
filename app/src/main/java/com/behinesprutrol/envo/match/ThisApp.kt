package com.behinesprutrol.envo.match

import android.app.Application
import android.content.Intent
import android.os.CountDownTimer
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "c8fca6ce-e779-466f-8952-35cbbdeae637"
const val LOG_TAG = "AppsFlyer"
const val devKey = "Zq4cd7LZhQYtUp2YBNgPRn"

class ThisApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

//        val conversionDataListener = object : AppsFlyerConversionListener{
//            override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
//                data?.let { cvData ->
//                    cvData.map {
//                        Log.i(LOG_TAG, "conversion_attribute: ${it.key} = ${it.value}")
//                    }
//                }
//            }
//            override fun onConversionDataFail(error: String?) {
//                Log.e(LOG_TAG, "error onAttributionFailure : $error")
//            }
//            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
//                data?.map {
//                    Log.d(LOG_TAG, "onAppOpen_attribute: ${it.key} = ${it.value}")
//                }
//            }
//            override fun onAttributionFailure(error: String?) {
//                Log.e(LOG_TAG, "error onAttributionFailure : $error")
//            }
//        }
//        AppsFlyerLib.getInstance().init(devKey, conversionDataListener, this)
//        AppsFlyerLib.getInstance().start(this)
//
//        var uid = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
//        Log.i("ApsflyerId",uid)
//    }


    val conversionDataListener  = object : AppsFlyerConversionListener{

            override fun onInstallConversionDataLoaded(data: MutableMap<String, String>?) {
                data?.let { cvData ->
                    cvData.map {
                        Log.i(LOG_TAG, "conversion_attribute:  ${it.key} = ${it.value}")
                    }
                }
            }

            override fun onInstallConversionFailure(error: String?) {
                Log.e(LOG_TAG, "error onAttributionFailure :  $error")
            }

            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
                data?.map {
                    Log.d(LOG_TAG, "onAppOpen_attribute: ${it.key} = ${it.value}")
                }
            }

            override fun onAttributionFailure(error: String?) {
                Log.e(LOG_TAG, "error onAttributionFailure :  $error")
            }
        }

        AppsFlyerLib.getInstance().init(devKey, conversionDataListener, this)
        AppsFlyerLib.getInstance().startTracking(this)

    }
}