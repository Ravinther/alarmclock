package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.k */
public class C0830k {

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.f */
    public interface C0813f {
        String m3849a();

        C0821i m3850b();

        C0827o m3851c();
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.a */
    public enum C0814a implements C0813f {
        Screen("Screen", C0821i.Open),
        RateUs("Rate_Us", C0821i.Tap),
        ShareApp("Share_App", C0821i.Tap),
        MoreAvgApps("More_AVG_Apps", C0821i.Tap);
        
        private final String f2142e;
        private final C0821i f2143f;

        private C0814a(String id, C0821i action) {
            this.f2142e = id;
            this.f2143f = action;
        }

        public String m3852a() {
            return this.f2142e;
        }

        public C0821i m3853b() {
            return this.f2143f;
        }

        public C0827o m3854c() {
            return C0827o.About;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.b */
    public enum C0815b implements C0813f {
        Screen("Screen", C0821i.Open),
        DeleteSwipe("Swipe_Delete", C0821i.None),
        MultiSelection("Bulk_Edit", C0821i.LongTap),
        MultiSelectionDelete("Delete", C0821i.Tap, C0827o.Bulk),
        MultiSelectionEdit("Edit", C0821i.Tap, C0827o.Bulk),
        Edit("Edit", C0821i.Tap),
        Snoozed("Snoozed", C0821i.Tap),
        SwitchOn("Switch", C0821i.On),
        SwitchOff("Switch", C0821i.Off),
        Add("Add_Alarm", C0821i.Tap),
        Undo("Undo_Delete", C0821i.Tap);
        
        private final String f2156l;
        private final C0821i f2157m;

        private C0815b(String id, C0821i action) {
            this.f2156l = id;
            this.f2157m = action;
        }

        private C0815b(String id, C0821i action, C0827o subject) {
            this.f2156l = id;
            this.f2157m = action;
        }

        public String m3855a() {
            return this.f2156l;
        }

        public C0821i m3856b() {
            return this.f2157m;
        }

        public C0827o m3857c() {
            return C0827o.Alarm;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.c */
    public enum C0816c implements C0813f {
        Screen(C0827o.AlarmAlert.m3889a(), C0821i.Open);
        
        private final String f2160b;
        private final C0821i f2161c;
        private final C0827o f2162d;

        private C0816c(String id, C0821i action) {
            this.f2160b = id;
            this.f2161c = action;
            this.f2162d = C0827o.AlarmAlert;
        }

        public String m3858a() {
            return this.f2160b;
        }

        public C0821i m3859b() {
            return this.f2161c;
        }

        public C0827o m3860c() {
            return this.f2162d;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.d */
    public enum C0817d implements C0813f {
        NextAlarmWidget("Launch\u200b_App", C0821i.Tap, C0827o.WidgetNextAlarm),
        ClockWidget("Launch\u200b_App", C0821i.Tap, C0827o.WidgetClock),
        OfferWall("Offer_Wall", C0821i.Tap, C0827o.Main),
        DirectToMarket("Direct_To_Market", C0821i.Tap, C0827o.Main),
        Upgrade("Upgrade", C0821i.Tap, C0827o.Menu),
        Settings("Settings", C0821i.Tap, C0827o.Menu),
        About("About", C0821i.Tap, C0827o.Menu),
        Help("Help", C0821i.Tap, C0827o.Menu);
        
        private final String f2172i;
        private final C0821i f2173j;
        private final C0827o f2174k;

        private C0817d(String id, C0821i action, C0827o subject) {
            this.f2172i = id;
            this.f2173j = action;
            this.f2174k = subject;
        }

        public String m3861a() {
            return this.f2172i;
        }

        public C0821i m3862b() {
            return this.f2173j;
        }

        public C0827o m3863c() {
            return this.f2174k;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.e */
    public enum C0818e implements C0813f {
        ARTIST(C0827o.ChooseArtist.m3889a(), C0821i.Open),
        APPLICATION(C0827o.ChooseApplication.m3889a(), C0821i.Open),
        SONG(C0827o.ChooseMusic.m3889a(), C0821i.Open),
        PLAYLIST(C0827o.ChoosePlaylist.m3889a(), C0821i.Open),
        RINGTONE(C0827o.ChooseRingtone.m3889a(), C0821i.Open),
        EDIT_PLAYLIST(C0827o.EditPlaylist.m3889a(), C0821i.Open);
        
        private final String f2182g;
        private final C0821i f2183h;

        private C0818e(String id, C0821i action) {
            this.f2182g = id;
            this.f2183h = action;
        }

        public String m3864a() {
            return this.f2182g;
        }

        public C0821i m3865b() {
            return this.f2183h;
        }

        public C0827o m3866c() {
            return C0827o.ChooseRingtone;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.g */
    public enum C0819g implements C0813f {
        SetGoogleVoiceSetAlarmValue("Set_Alarm_Time", C0821i.VoiceCommand),
        SetGoogleVoiceSetAlarm("Set_Alarm", C0821i.VoiceCommand),
        SetGoogleVoiceShowAlarms("Show_Alarm", C0821i.VoiceCommand),
        SetGoogleVoiceSetTimer("Set_Timer", C0821i.VoiceCommand),
        SetGoogleVoiceSetTimerValue("Set_Timer_Value", C0821i.VoiceCommand);
        
        private final String f2190f;
        private final C0821i f2191g;

        private C0819g(String id, C0821i action) {
            this.f2190f = id;
            this.f2191g = action;
        }

        public String m3867a() {
            return this.f2190f;
        }

        public C0821i m3868b() {
            return this.f2191g;
        }

        public C0827o m3869c() {
            return C0827o.GoogleNow;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.h */
    public enum C0820h implements C0813f {
        Screen("Screen", C0821i.Open),
        Online("Online_Help", C0821i.Tap),
        ContactUs("Contact_Us", C0821i.Tap);
        
        private final String f2196d;
        private final C0821i f2197e;

        private C0820h(String id, C0821i action) {
            this.f2196d = id;
            this.f2197e = action;
        }

        public String m3870a() {
            return this.f2196d;
        }

        public C0821i m3871b() {
            return this.f2197e;
        }

        public C0827o m3872c() {
            return C0827o.Help;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.i */
    private enum C0821i {
        Open("Open"),
        Swipe("None"),
        Tap("Tap"),
        LongTap("LongTap"),
        On("On"),
        Off("Off"),
        None("None"),
        Options("Options"),
        OpenDialog("OpenDialog"),
        VoiceCommand("VoiceCommand");
        
        private final String f2209k;

        private C0821i(String id) {
            this.f2209k = id;
        }

        public String m3873a() {
            return this.f2209k;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.j */
    public enum C0822j implements C0813f {
        Stopwatch("Stopwatch"),
        StopwatchLap("SW_Lap"),
        StopwatchStop("SW_Stop"),
        StopwatchReset("SW_Reset"),
        StopwatchStart("SW_Start"),
        Alarm("Alarm"),
        AlarmHide("Alarm_Remove"),
        Timer("Timer"),
        TimerHide("Timer_Remove");
        
        private final String f2220j;

        private C0822j(String id) {
            this.f2220j = id;
        }

        public String m3874a() {
            return this.f2220j;
        }

        public C0821i m3875b() {
            return C0821i.Tap;
        }

        public C0827o m3876c() {
            return C0827o.Notification;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.k */
    public enum C0823k implements C0813f {
        Screen(C0827o.QuestionPage.m3889a(), C0821i.Open);
        
        private final String f2223b;
        private final C0821i f2224c;

        private C0823k(String id, C0821i action) {
            this.f2223b = id;
            this.f2224c = action;
        }

        public String m3877a() {
            return this.f2223b;
        }

        public C0821i m3878b() {
            return this.f2224c;
        }

        public C0827o m3879c() {
            return C0827o.QuestionPage;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.l */
    public enum C0824l implements C0813f {
        BaseAlarmSettingScreen("Screen", C0821i.Open, C0827o.BaseAlarmSettings),
        DefaultAlarmSettingScreen("Screen", C0821i.Open, C0827o.DefaultAlarmSettings),
        Done("Alarm_Done", C0821i.None, C0827o.BaseAlarmSettings),
        Cancel("Alarm_Cancel", C0821i.Tap, C0827o.BaseAlarmSettings),
        SetTime("Alarm_Time", C0821i.Tap, C0827o.BaseAlarmSettings),
        SetDays("Alarm_Time", C0821i.Tap, C0827o.BaseAlarmSettings),
        Label("Alarm_Name", C0821i.Tap, C0827o.BaseAlarmSettings),
        SoundType("Sound_Type", C0821i.Options, C0827o.BaseAlarmSettings),
        SelectSoundAtSelectedType("Sound_Type_2nd", C0821i.Options, C0827o.BaseAlarmSettings),
        Dismiss("Dismiss_Alarm", C0821i.Options, C0827o.BaseAlarmSettings),
        AutoDismiss("Auto_dismiss_alarm", C0821i.Options, C0827o.BaseAlarmSettings),
        Advanced("Alarm_Advanced", C0821i.Tap, C0827o.BaseAlarmSettings),
        Preview("Preview", C0821i.Tap, C0827o.BaseAlarmSettings),
        MathLevel("Math_Diff_Level", C0821i.Tap, C0827o.BaseAlarmSettings),
        MathToDismiss("Num_Of_Problems_Dismiss", C0821i.Tap, C0827o.BaseAlarmSettings),
        MathToSnooze("Num_Of_Problems_Snooze", C0821i.Tap, C0827o.BaseAlarmSettings),
        AdvancedAlarmSettingScreen("Screen", C0821i.Open, C0827o.AlarmAdvanced),
        ActionBarBack("Back", C0821i.Tap, C0827o.AlarmAdvanced),
        Snooze("Snooze_Alarms", C0821i.Options, C0827o.AlarmAdvanced),
        SnoozeDuration("Snooze_Duration", C0821i.Tap, C0827o.AlarmAdvanced),
        SnoozeDecreaseDuration("Decrease_Duration", C0821i.Tap, C0827o.AlarmAdvanced),
        SnoozeMax("Allow_Snoozing", C0821i.Tap, C0827o.AlarmAdvanced),
        SnoozeButtonSizeOn("Use_Large_Button", C0821i.On, C0827o.AlarmAdvanced),
        SnoozeButtonSizeOff("Use_Large_Button", C0821i.Off, C0827o.AlarmAdvanced),
        AutoSnooze("Auto_Snooze_Alarm", C0821i.Options, C0827o.BaseAlarmSettings),
        VibrateOn("Vibrate", C0821i.On, C0827o.AlarmAdvanced),
        VibrateOff("Vibrate", C0821i.Off, C0827o.AlarmAdvanced),
        VolumeCrescendoOn("Volume_Crescendo", C0821i.On, C0827o.AlarmAdvanced),
        VolumeCrescendoOff("Volume_Crescendo", C0821i.Off, C0827o.AlarmAdvanced),
        MaxVolume("Max_Alarm_Volume", C0821i.Tap, C0827o.AlarmAdvanced),
        TimeToMaxVolume("Time_To_Max_Volume", C0821i.Tap, C0827o.AlarmAdvanced),
        SilentModeOn("Alarm_Plays_Silent", C0821i.On, C0827o.AlarmAdvanced),
        SilentModeOff("Alarm_Plays_Silent", C0821i.Off, C0827o.AlarmAdvanced),
        PassingQuestionOn("Alarm_Pass_Question", C0821i.On, C0827o.BaseAlarmSettings),
        PassingQuestionOff("Alarm_Pass_Question", C0821i.Off, C0827o.BaseAlarmSettings),
        SoundTypeDialog("Screen", C0821i.Open, C0827o.SettingSoundType),
        SoundTypeDialogSilent("Silent", C0821i.Tap, C0827o.SettingSoundType),
        SoundTypeDialogRingtone("Ringtone", C0821i.Tap, C0827o.SettingSoundType),
        SoundTypeDialogMusic("Music", C0821i.Tap, C0827o.SettingSoundType),
        SoundTypeDialogArtist("By_Artist", C0821i.Tap, C0827o.SettingSoundType),
        SoundTypeDialogPlaylist("By_Playlist", C0821i.Tap, C0827o.SettingSoundType),
        SoundTypeDialogLaunchApp("Launch_App", C0821i.Tap, C0827o.SettingSoundType),
        DismissDialog("Screen", C0821i.Open, C0827o.DismissDialog),
        DismissDialogMath("Solve_Math_Questions", C0821i.Tap, C0827o.DismissDialog),
        DismissDialogMathMax("Solve_Math_Questions", C0821i.Tap, C0827o.DismissDialog),
        DismissDialogCaptcha("TypeCaptchaQues", C0821i.Tap, C0827o.DismissDialog),
        DismissDialogShake("Shake_Device", C0821i.Tap, C0827o.DismissDialog),
        DismissDialogOnButton("On_Screen_Button", C0821i.Tap, C0827o.DismissDialog),
        TimerSettingScreen("Screen", C0821i.Open, C0827o.TimerEdit),
        KeepScreenOn("Keep_Screen_On", C0821i.On, C0827o.TimerEdit),
        KeepScreenOff("Keep_Screen_On", C0821i.Off, C0827o.TimerEdit);
        
        private final String f2276Z;
        private final C0821i aa;
        private final C0827o ab;

        private C0824l(String id, C0821i action, C0827o subject) {
            this.f2276Z = id;
            this.aa = action;
            this.ab = subject;
        }

        public String m3880a() {
            return this.f2276Z;
        }

        public C0821i m3881b() {
            return this.aa;
        }

        public C0827o m3882c() {
            return this.ab;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.m */
    public enum C0825m implements C0813f {
        MainSettingsScreen("Screen", C0821i.Open, C0827o.MainSetting),
        MainSettingsGeneral("General_Settings", C0821i.Tap, C0827o.MainSetting),
        MainSettingsAlarm("Alarm_Settings", C0821i.Tap, C0827o.MainSetting),
        MainSettingsTimer("Timer_Settings", C0821i.Tap, C0827o.MainSetting),
        MainSettingsStopwatch("Stopwatch_Settings", C0821i.Tap, C0827o.MainSetting),
        GeneralSettingsScreen("Screen", C0821i.Open, C0827o.GeneralSetting),
        GeneralSettings24hOn("Clock_Format", C0821i.On, C0827o.GeneralSetting),
        GeneralSettings24hOff("Clock_Format", C0821i.Off, C0827o.GeneralSetting),
        GeneralSettingsFirstDay("Day_Of_Week", C0821i.Options, C0827o.GeneralSetting),
        GeneralSettingsSpeakerOn("Phone_Speakers", C0821i.On, C0827o.GeneralSetting),
        GeneralSettingsSpeakerOff("Phone_Speakers", C0821i.Off, C0827o.GeneralSetting),
        GeneralSettingsBg("Background", C0821i.Tap, C0827o.GeneralSetting),
        GeneralSettingsShowNotifDialog("Notification_Dialog_Open", C0821i.OpenDialog, C0827o.GeneralSetting),
        GeneralSettingsShowAlarmNotifOn("Alarm_Notification", C0821i.On, C0827o.GeneralSetting),
        GeneralSettingsShowAlarmNotifOff("Alarm_Notification", C0821i.Off, C0827o.GeneralSetting),
        GeneralSettingsShowTimerNotifOn("Timer_Notification", C0821i.On, C0827o.GeneralSetting),
        GeneralSettingsShowTimerNotifOff("Timer_Notification", C0821i.Off, C0827o.GeneralSetting),
        GeneralSettingsShowSWNotifOn("SW_Notification", C0821i.On, C0827o.GeneralSetting),
        GeneralSettingsShowSWNotifOff("SW_Notification", C0821i.Off, C0827o.GeneralSetting),
        GeneralSettingsUnlockOn("Unlock_In_Alarm", C0821i.On, C0827o.GeneralSetting),
        GeneralSettingsUnlockOff("Unlock_In_Alarm", C0821i.Off, C0827o.GeneralSetting),
        GeneralSettingsLang("Language", C0821i.Tap, C0827o.GeneralSetting),
        GeneralSettingsVacationModeOn("Vacation_Mode", C0821i.On, C0827o.GeneralSetting),
        GeneralSettingsVacationModeOff("Vacation_Mode", C0821i.Off, C0827o.GeneralSetting),
        GeneralSettingsVacationModeOffAlarmsFragment("Vacation_Mode_Off_Alarms_Fragments", C0821i.Off, C0827o.GeneralSetting),
        BgScreen("Screen", C0821i.Open, C0827o.Background),
        BgScreenCanceled("Canceled", C0821i.Tap, C0827o.Background),
        BgScreenSaved("Saved", C0821i.Tap, C0827o.Background),
        BgScreenSelected("Selected", C0821i.Tap, C0827o.Background),
        StopwatchScreen("Screen", C0821i.Open, C0827o.StopwatchSettings),
        StopWatchVolumeOn("Volume_Control", C0821i.On, C0827o.StopwatchSettings),
        StopWatchVolumeOff("Volume_Control", C0821i.Off, C0827o.StopwatchSettings),
        StopWatchKeepAwakeOn("Keep_Awake", C0821i.On, C0827o.StopwatchSettings),
        StopWatchKeepAwakeOff("Keep_Awake", C0821i.Off, C0827o.StopwatchSettings),
        StopwatchEmail("Email_Times", C0821i.Tap, C0827o.StopwatchSettings);
        
        private final String f2313J;
        private final C0821i f2314K;
        private final C0827o f2315L;

        private C0825m(String id, C0821i action, C0827o subject) {
            this.f2313J = id;
            this.f2314K = action;
            this.f2315L = subject;
        }

        public String m3883a() {
            return this.f2313J;
        }

        public C0821i m3884b() {
            return this.f2314K;
        }

        public C0827o m3885c() {
            return this.f2315L;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.n */
    public enum C0826n implements C0813f {
        Screen("Screen", C0821i.Open),
        Start("SW_Start", C0821i.Tap),
        Lap("SW_Lap", C0821i.Tap),
        Stop("SW_Stop", C0821i.Tap),
        Reset("SW_Reset", C0821i.Tap);
        
        private final String f2322f;
        private final C0821i f2323g;

        private C0826n(String id, C0821i action) {
            this.f2322f = id;
            this.f2323g = action;
        }

        public String m3886a() {
            return this.f2322f;
        }

        public C0821i m3887b() {
            return this.f2323g;
        }

        public C0827o m3888c() {
            return C0827o.Stopwatch;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.o */
    public enum C0827o {
        Alarm("Alarm"),
        Timer("Timer"),
        Stopwatch("Stopwatch"),
        AlarmAlert("Alarm_Alert"),
        QuestionPage("Question_Page"),
        ChooseArtist("Choose_Artist"),
        ChoosePlaylist("Choose_Playlist"),
        ChooseRingtone("Choose_Ringtone"),
        ChooseApplication("Choose_Application"),
        ChooseMusic("Choose_Music"),
        EditPlaylist("Edit_Play_List"),
        Bulk("Bulk_Edit"),
        TOU("Term_Of_Use"),
        RateUs("Rate_Us"),
        Notification("Notification"),
        About("About"),
        Help("Help"),
        Main("Main"),
        Menu("Menu"),
        MainSetting("Settings"),
        GeneralSetting("General_Setting"),
        Background("Background"),
        StopwatchSettings("Stopwatch_Settings"),
        TimerEdit("Timer_Edit"),
        BaseAlarmSettings("Alarm_Edit"),
        DefaultAlarmSettings("Alarm_Settings"),
        AlarmAdvanced("Alarm_Advanced"),
        DismissDialog("Dismiss_Alarm_Dialog"),
        ExpiredAlarm("Expired_Alarm"),
        SettingSoundType("Sound_Type_dialog"),
        GoogleNow("GoogleNow"),
        WidgetClock("ClockWidget"),
        WidgetNextAlarm("NextAlarmWidget");
        
        private final String f2358H;

        private C0827o(String id) {
            this.f2358H = id;
        }

        public String m3889a() {
            return this.f2358H;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.p */
    public enum C0828p implements C0813f {
        Screen("Screen", C0821i.Open),
        Accept("OK", C0821i.Tap),
        Cancel("Cancel", C0821i.Tap);
        
        private final String f2363d;
        private final C0821i f2364e;

        private C0828p(String id, C0821i action) {
            this.f2363d = id;
            this.f2364e = action;
        }

        public String m3890a() {
            return this.f2363d;
        }

        public C0821i m3891b() {
            return this.f2364e;
        }

        public C0827o m3892c() {
            return C0827o.TOU;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.k.q */
    public enum C0829q implements C0813f {
        Screen(C0827o.Timer.m3889a(), C0821i.Open),
        Start("Start_Timer", C0821i.Tap),
        Undo("Undo_Delete", C0821i.Tap),
        Label("Timer_Label", C0821i.Tap),
        Reset("Reset_Timer", C0821i.Tap),
        Delete("Delete_Timer", C0821i.Tap),
        Play("Play_Timer", C0821i.Tap),
        Stop("Stop_Timer", C0821i.Tap),
        Plus1("Plus1_Timer", C0821i.Tap),
        Add("Add_Timer_While_Running", C0821i.Tap),
        Edit("Edit", C0821i.Tap),
        MultiSelection("Bulk_Edit_Timer", C0821i.LongTap, C0827o.Bulk),
        MultiSelectionDelete("Delete_Timer", C0821i.Tap, C0827o.Bulk);
        
        private final String f2379n;
        private final C0821i f2380o;
        private final C0827o f2381p;

        private C0829q(String id, C0821i action) {
            this.f2379n = id;
            this.f2380o = action;
            this.f2381p = C0827o.Timer;
        }

        private C0829q(String id, C0821i action, C0827o subject) {
            this.f2379n = id;
            this.f2380o = action;
            this.f2381p = subject;
        }

        public String m3893a() {
            return this.f2379n;
        }

        public C0821i m3894b() {
            return this.f2380o;
        }

        public C0827o m3895c() {
            return this.f2381p;
        }
    }

    public static void m3897a(Context context, C0813f googleAnalyticAction, C0827o subject) {
        C0830k.m3898a(context, subject, googleAnalyticAction.m3850b(), googleAnalyticAction.m3849a());
    }

    public static void m3896a(Context context, C0813f googleAnalyticAction) {
        C0830k.m3898a(context, googleAnalyticAction.m3851c(), googleAnalyticAction.m3850b(), googleAnalyticAction.m3849a());
    }

    public static void m3898a(Context context, C0827o subject, C0821i action, String id) {
        GoogleAnalyticsWrapper.trackEvent(context, subject.m3889a(), id, action.m3873a(), 0);
        if (action.equals(C0821i.Open)) {
            C0830k.m3899a(context, subject.m3889a());
        }
    }

    public static void m3899a(Context context, String screen) {
        GoogleAnalyticsWrapper.trackPageView(context, screen);
    }
}
