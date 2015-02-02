package com.labellson.frontflashcamera;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findMethodBestMatch;

public class Main implements IXposedHookLoadPackage{
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equals("com.google.android.GoogleCamera")) return;
//        Log.i("Xposed", loadPackageParam.packageName);
//        Log.i("Xposed", loadPackageParam.processName);
        Log.i("Xposed", loadPackageParam.appInfo.className);
        findAndHookMethod("com.android.camera.PhotoModule", loadPackageParam.classLoader, "onShutterButtonClick", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log.i("Xposed", "Conseguido!!!!");
            }

            /*@Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.i("Xposed", "Conseguido!!!!");
                super.afterHookedMethod(param);
            }*/
        });
        /*findAndHookMethod("com.android.camera.CaptureModule", loadPackageParam.classLoader, "takePictureNow", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log.i("Xposed", "Conseguido!!!!");
            }
        });*/
    }
}
