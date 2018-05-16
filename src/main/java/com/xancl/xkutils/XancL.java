package com.xancl.xkutils;

public class XancL {
    public static final String ACTION_START_SERVICE = "xancl.intent.action.START_SERVICE";
    /*
        adb -s $device shell am startservice -a "xancl.intent.action.share" com.xancl.sf.srv/.SFService
        adb -s $device logcat -v threadtime -s SFService:V SFReceiver:V *:S
         */
    public static final String ACTION_SHARE = "xancl.intent.action.SHARE";
}
