package com.hoxfon.react.RNTwilioVoice;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

public class SoundPoolManager {

    private boolean playing = false;
    private static SoundPoolManager instance;
    private Ringtone ringtone = null;
    public static boolean disabled = true; 

    private SoundPoolManager(Context context) {
        Uri ringtoneSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        ringtone = RingtoneManager.getRingtone(context, ringtoneSound);
    }

    public static SoundPoolManager getInstance(Context context) {
        if (instance == null) {
            instance = new SoundPoolManager(context);
        }
        return instance;
    }

    public void playRinging() {
        if(disabled)
            return;
        if (!playing) {
            ringtone.play();
            playing = true;
        }
    }

    public void stopRinging() {
        if(disabled)
            return;

        if (playing) {
            ringtone.stop();
            playing = false;
        }
    }

    public void playDisconnect() {
        if(disabled)
            return;

        if (!playing) {
            ringtone.stop();
            playing = false;
        }
    }

}
