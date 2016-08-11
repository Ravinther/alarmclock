package com.anglelabs.alarmclock.redesign.alarm.p028a;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings.System;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.utils.ac;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.a */
public class C0613a {

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.a.a */
    public interface C0604a {
        void m2797e();
    }

    public static void m2829a(MediaPlayer mediaPlayer, int volume) {
        if (mediaPlayer != null && volume >= 0) {
            if (volume >= 100) {
                mediaPlayer.setVolume(1.0f, 1.0f);
                return;
            }
            float v = (float) (1.0d - (Math.log((double) (100 - volume)) / Math.log(100.0d)));
            mediaPlayer.setVolume(v, v);
        }
    }

    public static int m2826a(Context context, C0604a callback, MediaPlayer mediaPlayer, RedesignAlarm alarm, boolean isInTelephoneCall) {
        int i = 4;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (isInTelephoneCall) {
            mediaPlayer.setVolume(0.125f, 0.125f);
            mediaPlayer.setAudioStreamType(4);
        } else {
            i = C0613a.m2825a(context, callback, audioManager, alarm, C0613a.m2830a(context, audioManager));
            if (alarm.f2016q) {
                mediaPlayer.setAudioStreamType(i);
                audioManager.setStreamVolume(i, audioManager.getStreamMaxVolume(i), 0);
                audioManager.setMode(0);
            } else {
                mediaPlayer.setVolume((float) i, (float) i);
            }
        }
        return i;
    }

    private static boolean m2830a(Context context, AudioManager audioManager) {
        try {
            boolean checkForExternalSpeakers = !C0860w.m4039b(ac.m3774b(context));
            boolean isExternalDeviceConnected;
            if (audioManager.isBluetoothA2dpOn() || audioManager.isBluetoothScoOn() || audioManager.isWiredHeadsetOn()) {
                isExternalDeviceConnected = true;
            } else {
                isExternalDeviceConnected = false;
            }
            if (checkForExternalSpeakers && isExternalDeviceConnected) {
                return true;
            }
            return false;
        } catch (Exception e) {
            C0850q.m3985a(e, "while checking for external speakers");
            return false;
        }
    }

    private static int m2825a(Context context, C0604a callback, AudioManager audioManager, RedesignAlarm alarm, boolean useExternalSpeakers) {
        int volumeStream = 0;
        boolean isNotSilent = audioManager.getStreamVolume(2) > 0 || alarm.f2016q;
        if (isNotSilent) {
            if (useExternalSpeakers) {
                C0850q.m3986a("using external speakers");
            }
            volumeStream = useExternalSpeakers ? 3 : 4;
            C0613a.m2828a(context, callback, audioManager, volumeStream);
        }
        return volumeStream;
    }

    private static int m2827a(AudioManager audioManager) {
        return audioManager.getStreamVolume(2);
    }

    public static void m2828a(Context context, C0604a callback, AudioManager audioManager, int volumeStram) {
        boolean hasRingerModeChanged = false;
        if (C0613a.m2827a(audioManager) == 0) {
            if (!Build.BRAND.equals("DOCOMO") && !Build.BRAND.equals("KDDI")) {
                C0850q.m3986a("AlarmService ringer is silent, checking that volume stream is not muted.");
                int currentRingerMuteStreams = System.getInt(context.getContentResolver(), "mode_ringer_streams_affected", -1);
                if (currentRingerMuteStreams != -1 && ((1 << volumeStram) | currentRingerMuteStreams) == currentRingerMuteStreams) {
                    C0850q.m3986a("AlarmService UnMuting the volume stream " + volumeStram);
                    if (System.putInt(context.getContentResolver(), "mode_ringer_streams_affected", ((1 << volumeStram) ^ -1) & currentRingerMuteStreams)) {
                        hasRingerModeChanged = true;
                    } else {
                        C0850q.m3986a("AlarmService failed to unMute the volume stream. Setting ringer mode to normal instead.");
                        audioManager.setRingerMode(2);
                        hasRingerModeChanged = true;
                    }
                }
            } else if (audioManager.getRingerMode() != 2) {
                C0850q.m3986a("AlarmService ringer is silent. Setting to normal mode. " + Build.BRAND);
                audioManager.setRingerMode(2);
                hasRingerModeChanged = true;
            }
        } else if (audioManager.getRingerMode() != 2 && (Build.BRAND.equals("DOCOMO") || Build.BRAND.equals("KDDI"))) {
            C0850q.m3986a("AlarmService ringer is silent. Setting ringer to normal mode. " + Build.BRAND);
            audioManager.setRingerMode(2);
            hasRingerModeChanged = true;
        }
        if (hasRingerModeChanged && callback != null) {
            callback.m2797e();
        }
    }
}
