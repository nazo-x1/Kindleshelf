package com.kunfei.bookshelf.hack

import android.os.Build
import com.kunfei.bookshelf.help.AndroidPlatform9
import okhttp3.internal.platform.Platform;

object hack {
    
    @JvmStatic
    fun hack() {
        if (Build.VERSION.SDK_INT < 21) {
            initLowVersionPlatform()
        }
    }

    private fun initLowVersionPlatform() {
        try {
            val jvm = System.getProperty("java.vm.name", "Dalvik")
            System.getProperties()["java.vm.name"] = "jvm"
            println(Platform.get())
            System.getProperties()["java.vm.name"] = jvm
            Platform.resetForTests(AndroidPlatform9.buildIfSupported())
            println(Platform.get())
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

}