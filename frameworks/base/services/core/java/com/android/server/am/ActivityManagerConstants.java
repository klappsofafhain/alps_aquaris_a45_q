package com.android.server.am;

import android.app.ActivityThread;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.KeyValueListParser;
import android.util.Slog;
import com.android.server.backup.BackupAgentTimeoutParameters;
import java.io.PrintWriter;
import java.util.Iterator;

/* access modifiers changed from: package-private */
public final class ActivityManagerConstants extends ContentObserver {
    private static final Uri ACTIVITY_MANAGER_CONSTANTS_URI = Settings.Global.getUriFor("activity_manager_constants");
    private static final Uri ACTIVITY_STARTS_LOGGING_ENABLED_URI = Settings.Global.getUriFor("activity_starts_logging_enabled");
    private static final long DEFAULT_BACKGROUND_SETTLE_TIME = SystemProperties.getLong("ro.config.bgsettletime", 60000);
     private static final long DEFAULT_BG_START_TIMEOUT = SystemProperties.getLong("ro.config.bgstarttimeout", 15000);
    private static final int DEFAULT_BOUND_SERVICE_CRASH_MAX_RETRY = SystemProperties.getInt("ro.config.boundservicecrashmaxretry", 16);
    private static final long DEFAULT_BOUND_SERVICE_CRASH_RESTART_DURATION = SystemProperties.getLong("ro.config.boundservicecrashrestartduration", 1800000);
    private static final long DEFAULT_CONTENT_PROVIDER_RETAIN_TIME = SystemProperties.getLong("ro.config.providerretaintime", 20000);
    private static final long DEFAULT_FGSERVICE_MIN_REPORT_TIME = SystemProperties.getLong("ro.config.fgserviceminreporttime", (long) BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS);
    private static final long DEFAULT_FGSERVICE_MIN_SHOWN_TIME = SystemProperties.getLong("ro.config.fgserviceminshowntime", 2000);
    private static final long DEFAULT_FGSERVICE_SCREEN_ON_AFTER_TIME = SystemProperties.getLong("ro.config.fgservicescreenonaftertime", 5000);
    private static final long DEFAULT_FGSERVICE_SCREEN_ON_BEFORE_TIME = SystemProperties.getLong("ro.config.fgservicescreenonbeforetime", 1000);
    private static final long DEFAULT_FULL_PSS_LOWERED_INTERVAL = SystemProperties.getLong("ro.config.fullpssloweredinterval", 300000);
    private static final long DEFAULT_FULL_PSS_MIN_INTERVAL = SystemProperties.getLong("ro.config.fullpssmininterval", 1200000);
    private static final long DEFAULT_GC_MIN_INTERVAL = SystemProperties.getLong("ro.config.gcmininterval", 60000);
    private static final long DEFAULT_GC_TIMEOUT = SystemProperties.getLong("ro.config.gctimeout", 5000);
    private static final int DEFAULT_MAX_CACHED_PROCESSES = SystemProperties.getInt("ro.config.maxcachedprocess", 32);
    private static final long DEFAULT_MAX_SERVICE_INACTIVITY = SystemProperties.getLong("ro.config.maxserviceinactivity", 1800000);
    private static final long DEFAULT_MEMORY_INFO_THROTTLE_TIME = 300000;
    private static final long DEFAULT_POWER_CHECK_INTERVAL = ((long) (((ActivityManagerDebugConfig.DEBUG_POWER_QUICK ? 1 : SystemProperties.getInt("ro.config.powercheckinterval", 5)) * 60) * 1000));
    private static final int DEFAULT_POWER_CHECK_MAX_CPU_1 = 25;
    private static final int DEFAULT_POWER_CHECK_MAX_CPU_2 = 25;
    private static final int DEFAULT_POWER_CHECK_MAX_CPU_3 = 10;
    private static final int DEFAULT_POWER_CHECK_MAX_CPU_4 = 2;
    private static final boolean DEFAULT_PROCESS_START_ASYNC = true;
    private static final long DEFAULT_SERVICE_BG_ACTIVITY_START_TIMEOUT = 10000;
    private static final long DEFAULT_SERVICE_MIN_RESTART_TIME_BETWEEN = SystemProperties.getLong("ro.config.serviceminrestarttimebetween", 10000);
    private static final long DEFAULT_SERVICE_RESET_RUN_DURATION = SystemProperties.getLong("ro.config.serviceresetrunduration", 60000);
    private static final long DEFAULT_SERVICE_RESTART_DURATION = SystemProperties.getLong("ro.config.servicerestartduration", 1000);
    private static final int DEFAULT_SERVICE_RESTART_DURATION_FACTOR = 4;
    private static final long DEFAULT_SERVICE_USAGE_INTERACTION_TIME = SystemProperties.getLong("ro.config.serviceusageinteractiontime", 1800000);
    private static final long DEFAULT_TOP_TO_FGS_GRACE_DURATION = 15000;
    private static final long DEFAULT_USAGE_STATS_INTERACTION_INTERVAL = 7200000;
    private static final Uri ENABLE_AUTOMATIC_SYSTEM_SERVER_HEAP_DUMPS_URI = Settings.Global.getUriFor("enable_automatic_system_server_heap_dumps");
    private static final String KEY_BACKGROUND_SETTLE_TIME = "background_settle_time";
    static final String KEY_BG_START_TIMEOUT = "service_bg_start_timeout";
    static final String KEY_BOUND_SERVICE_CRASH_MAX_RETRY = "service_crash_max_retry";
    static final String KEY_BOUND_SERVICE_CRASH_RESTART_DURATION = "service_crash_restart_duration";
    private static final String KEY_CONTENT_PROVIDER_RETAIN_TIME = "content_provider_retain_time";
    private static final String KEY_DEFAULT_BACKGROUND_ACTIVITY_STARTS_ENABLED = "default_background_activity_starts_enabled";
    private static final String KEY_FGSERVICE_MIN_REPORT_TIME = "fgservice_min_report_time";
    private static final String KEY_FGSERVICE_MIN_SHOWN_TIME = "fgservice_min_shown_time";
    private static final String KEY_FGSERVICE_SCREEN_ON_AFTER_TIME = "fgservice_screen_on_after_time";
    private static final String KEY_FGSERVICE_SCREEN_ON_BEFORE_TIME = "fgservice_screen_on_before_time";
    private static final String KEY_FULL_PSS_LOWERED_INTERVAL = "full_pss_lowered_interval";
    private static final String KEY_FULL_PSS_MIN_INTERVAL = "full_pss_min_interval";
    private static final String KEY_GC_MIN_INTERVAL = "gc_min_interval";
    private static final String KEY_GC_TIMEOUT = "gc_timeout";
    private static final String KEY_MAX_CACHED_PROCESSES = "max_cached_processes";
    static final String KEY_MAX_SERVICE_INACTIVITY = "service_max_inactivity";
    static final String KEY_MEMORY_INFO_THROTTLE_TIME = "memory_info_throttle_time";
    private static final String KEY_POWER_CHECK_INTERVAL = "power_check_interval";
    private static final String KEY_POWER_CHECK_MAX_CPU_1 = "power_check_max_cpu_1";
    private static final String KEY_POWER_CHECK_MAX_CPU_2 = "power_check_max_cpu_2";
    private static final String KEY_POWER_CHECK_MAX_CPU_3 = "power_check_max_cpu_3";
    private static final String KEY_POWER_CHECK_MAX_CPU_4 = "power_check_max_cpu_4";
    static final String KEY_PROCESS_START_ASYNC = "process_start_async";
    static final String KEY_SERVICE_BG_ACTIVITY_START_TIMEOUT = "service_bg_activity_start_timeout";
    static final String KEY_SERVICE_MIN_RESTART_TIME_BETWEEN = "service_min_restart_time_between";
    static final String KEY_SERVICE_RESET_RUN_DURATION = "service_reset_run_duration";
    static final String KEY_SERVICE_RESTART_DURATION = "service_restart_duration";
    static final String KEY_SERVICE_RESTART_DURATION_FACTOR = "service_restart_duration_factor";
    private static final String KEY_SERVICE_USAGE_INTERACTION_TIME = "service_usage_interaction_time";
    static final String KEY_TOP_TO_FGS_GRACE_DURATION = "top_to_fgs_grace_duration";
    private static final String KEY_USAGE_STATS_INTERACTION_INTERVAL = "usage_stats_interaction_interval";
    private static final long MIN_AUTOMATIC_HEAP_DUMP_PSS_THRESHOLD_BYTES = 102400;
    private static final String TAG = "ActivityManagerConstants";
    public long BACKGROUND_SETTLE_TIME = DEFAULT_BACKGROUND_SETTLE_TIME;
    public long BG_START_TIMEOUT = DEFAULT_BG_START_TIMEOUT;
    public long BOUND_SERVICE_CRASH_RESTART_DURATION = DEFAULT_BOUND_SERVICE_CRASH_RESTART_DURATION;
    public long BOUND_SERVICE_MAX_CRASH_RETRY = ((long) DEFAULT_BOUND_SERVICE_CRASH_MAX_RETRY);
    long CONTENT_PROVIDER_RETAIN_TIME = DEFAULT_CONTENT_PROVIDER_RETAIN_TIME;
    public int CUR_MAX_CACHED_PROCESSES;
    public int CUR_MAX_EMPTY_PROCESSES;
    public int CUR_TRIM_CACHED_PROCESSES;
    public int CUR_TRIM_EMPTY_PROCESSES;
    public long FGSERVICE_MIN_REPORT_TIME = DEFAULT_FGSERVICE_MIN_REPORT_TIME;
    public long FGSERVICE_MIN_SHOWN_TIME = DEFAULT_FGSERVICE_MIN_SHOWN_TIME;
    public long FGSERVICE_SCREEN_ON_AFTER_TIME = DEFAULT_FGSERVICE_SCREEN_ON_AFTER_TIME;
    public long FGSERVICE_SCREEN_ON_BEFORE_TIME = DEFAULT_FGSERVICE_SCREEN_ON_BEFORE_TIME;
    public boolean FLAG_PROCESS_START_ASYNC;
    long FULL_PSS_LOWERED_INTERVAL = DEFAULT_FULL_PSS_LOWERED_INTERVAL;
    long FULL_PSS_MIN_INTERVAL = DEFAULT_FULL_PSS_MIN_INTERVAL;
    long GC_MIN_INTERVAL = DEFAULT_GC_MIN_INTERVAL;
    long GC_TIMEOUT = DEFAULT_GC_TIMEOUT;
    public int MAX_CACHED_PROCESSES = DEFAULT_MAX_CACHED_PROCESSES;
    public long MAX_SERVICE_INACTIVITY = DEFAULT_MAX_SERVICE_INACTIVITY;
    public long MEMORY_INFO_THROTTLE_TIME;
    long POWER_CHECK_INTERVAL = DEFAULT_POWER_CHECK_INTERVAL;
    int POWER_CHECK_MAX_CPU_1 = 25;
    int POWER_CHECK_MAX_CPU_2 = 25;
    int POWER_CHECK_MAX_CPU_3 = 10;
    int POWER_CHECK_MAX_CPU_4 = 2;
    public long SERVICE_BG_ACTIVITY_START_TIMEOUT = 10000;
    public long SERVICE_MIN_RESTART_TIME_BETWEEN = DEFAULT_SERVICE_MIN_RESTART_TIME_BETWEEN;
    public long SERVICE_RESET_RUN_DURATION = DEFAULT_SERVICE_RESET_RUN_DURATION;
    public long SERVICE_RESTART_DURATION = DEFAULT_SERVICE_RESTART_DURATION;
    public int SERVICE_RESTART_DURATION_FACTOR = 4;
    long SERVICE_USAGE_INTERACTION_TIME = DEFAULT_SERVICE_USAGE_INTERACTION_TIME;
    public long TOP_TO_FGS_GRACE_DURATION = DEFAULT_TOP_TO_FGS_GRACE_DURATION;
    long USAGE_STATS_INTERACTION_INTERVAL = 7200000;
    volatile boolean mFlagActivityStartsLoggingEnabled;
    volatile boolean mFlagBackgroundActivityStartsEnabled;
    private final DeviceConfig.OnPropertiesChangedListener mOnDeviceConfigChangedListener;
    private int mOverrideMaxCachedProcesses;
    private final KeyValueListParser mParser;
    private ContentResolver mResolver;
    private final ActivityManagerService mService;
    private final boolean mSystemServerAutomaticHeapDumpEnabled;
    private final String mSystemServerAutomaticHeapDumpPackageName;
    private long mSystemServerAutomaticHeapDumpPssThresholdBytes;

    ActivityManagerConstants(Context context, ActivityManagerService activityManagerService, Handler handler) {
        super(handler);
        boolean z = true;
        this.FLAG_PROCESS_START_ASYNC = true;
        this.MEMORY_INFO_THROTTLE_TIME = 300000;
        this.TOP_TO_FGS_GRACE_DURATION = DEFAULT_TOP_TO_FGS_GRACE_DURATION;
        this.mParser = new KeyValueListParser(',');
        this.mOverrideMaxCachedProcesses = -1;
        this.mOnDeviceConfigChangedListener = new DeviceConfig.OnPropertiesChangedListener() {
            /* class com.android.server.am.ActivityManagerConstants.AnonymousClass1 */

            public void onPropertiesChanged(DeviceConfig.Properties properties) {
                String str;
                Iterator it = properties.getKeyset().iterator();
                while (it.hasNext() && (str = (String) it.next()) != null) {
                    char c = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != -1782036688) {
                        if (hashCode == -1092962821 && str.equals(ActivityManagerConstants.KEY_MAX_CACHED_PROCESSES)) {
                            c = 0;
                        }
                    } else if (str.equals(ActivityManagerConstants.KEY_DEFAULT_BACKGROUND_ACTIVITY_STARTS_ENABLED)) {
                        c = 1;
                    }
                    if (c == 0) {
                        ActivityManagerConstants.this.updateMaxCachedProcesses();
                    } else if (c == 1) {
                        ActivityManagerConstants.this.updateBackgroundActivityStarts();
                    }
                }
            }
        };
        this.mService = activityManagerService;
        this.mSystemServerAutomaticHeapDumpEnabled = (!Build.IS_DEBUGGABLE || !context.getResources().getBoolean(17891400)) ? false : z;
        this.mSystemServerAutomaticHeapDumpPackageName = context.getPackageName();
        this.mSystemServerAutomaticHeapDumpPssThresholdBytes = Math.max((long) MIN_AUTOMATIC_HEAP_DUMP_PSS_THRESHOLD_BYTES, (long) context.getResources().getInteger(17694769));
    }

    public void start(ContentResolver contentResolver) {
        this.mResolver = contentResolver;
        this.mResolver.registerContentObserver(ACTIVITY_MANAGER_CONSTANTS_URI, false, this);
        this.mResolver.registerContentObserver(ACTIVITY_STARTS_LOGGING_ENABLED_URI, false, this);
        if (this.mSystemServerAutomaticHeapDumpEnabled) {
            this.mResolver.registerContentObserver(ENABLE_AUTOMATIC_SYSTEM_SERVER_HEAP_DUMPS_URI, false, this);
        }
        updateConstants();
        if (this.mSystemServerAutomaticHeapDumpEnabled) {
            updateEnableAutomaticSystemServerHeapDumps();
        }
        DeviceConfig.addOnPropertiesChangedListener("activity_manager", ActivityThread.currentApplication().getMainExecutor(), this.mOnDeviceConfigChangedListener);
        updateMaxCachedProcesses();
        updateActivityStartsLoggingEnabled();
        updateBackgroundActivityStarts();
    }

    public void setOverrideMaxCachedProcesses(int i) {
        this.mOverrideMaxCachedProcesses = i;
        updateMaxCachedProcesses();
    }

    public int getOverrideMaxCachedProcesses() {
        return this.mOverrideMaxCachedProcesses;
    }

    public static int computeEmptyProcessLimit(int i) {
        return i / 2;
    }

    public void onChange(boolean z, Uri uri) {
        if (uri != null) {
            if (ACTIVITY_MANAGER_CONSTANTS_URI.equals(uri)) {
                updateConstants();
            } else if (ACTIVITY_STARTS_LOGGING_ENABLED_URI.equals(uri)) {
                updateActivityStartsLoggingEnabled();
            } else if (ENABLE_AUTOMATIC_SYSTEM_SERVER_HEAP_DUMPS_URI.equals(uri)) {
                updateEnableAutomaticSystemServerHeapDumps();
            }
        }
    }

    private void updateConstants() {
        String string = Settings.Global.getString(this.mResolver, "activity_manager_constants");
        synchronized (this.mService) {
            try {
                ActivityManagerService.boostPriorityForLockedSection();
                this.mParser.setString(string);
            } catch (IllegalArgumentException e) {
                Slog.e(TAG, "Bad activity manager config settings", e);
            } catch (Throwable th) {
                ActivityManagerService.resetPriorityAfterLockedSection();
                throw th;
            }
            this.BACKGROUND_SETTLE_TIME = this.mParser.getLong(KEY_BACKGROUND_SETTLE_TIME, DEFAULT_BACKGROUND_SETTLE_TIME);
            this.FGSERVICE_MIN_SHOWN_TIME = this.mParser.getLong(KEY_FGSERVICE_MIN_SHOWN_TIME, DEFAULT_FGSERVICE_MIN_SHOWN_TIME);
            this.FGSERVICE_MIN_REPORT_TIME = this.mParser.getLong(KEY_FGSERVICE_MIN_REPORT_TIME, DEFAULT_FGSERVICE_MIN_REPORT_TIME);
            this.FGSERVICE_SCREEN_ON_BEFORE_TIME = this.mParser.getLong(KEY_FGSERVICE_SCREEN_ON_BEFORE_TIME, DEFAULT_FGSERVICE_SCREEN_ON_BEFORE_TIME);
            this.FGSERVICE_SCREEN_ON_AFTER_TIME = this.mParser.getLong(KEY_FGSERVICE_SCREEN_ON_AFTER_TIME, DEFAULT_FGSERVICE_SCREEN_ON_AFTER_TIME);
            this.CONTENT_PROVIDER_RETAIN_TIME = this.mParser.getLong(KEY_CONTENT_PROVIDER_RETAIN_TIME, DEFAULT_CONTENT_PROVIDER_RETAIN_TIME);
            this.GC_TIMEOUT = this.mParser.getLong(KEY_GC_TIMEOUT, DEFAULT_GC_TIMEOUT);
            this.GC_MIN_INTERVAL = this.mParser.getLong(KEY_GC_MIN_INTERVAL, DEFAULT_GC_MIN_INTERVAL);
            this.FULL_PSS_MIN_INTERVAL = this.mParser.getLong(KEY_FULL_PSS_MIN_INTERVAL, DEFAULT_FULL_PSS_MIN_INTERVAL);
            this.FULL_PSS_LOWERED_INTERVAL = this.mParser.getLong(KEY_FULL_PSS_LOWERED_INTERVAL, DEFAULT_FULL_PSS_LOWERED_INTERVAL);
            this.POWER_CHECK_INTERVAL = this.mParser.getLong(KEY_POWER_CHECK_INTERVAL, DEFAULT_POWER_CHECK_INTERVAL);
            this.POWER_CHECK_MAX_CPU_1 = this.mParser.getInt(KEY_POWER_CHECK_MAX_CPU_1, 25);
            this.POWER_CHECK_MAX_CPU_2 = this.mParser.getInt(KEY_POWER_CHECK_MAX_CPU_2, 25);
            this.POWER_CHECK_MAX_CPU_3 = this.mParser.getInt(KEY_POWER_CHECK_MAX_CPU_3, 10);
            this.POWER_CHECK_MAX_CPU_4 = this.mParser.getInt(KEY_POWER_CHECK_MAX_CPU_4, 2);
            this.SERVICE_USAGE_INTERACTION_TIME = this.mParser.getLong(KEY_SERVICE_USAGE_INTERACTION_TIME, DEFAULT_SERVICE_USAGE_INTERACTION_TIME);
            this.USAGE_STATS_INTERACTION_INTERVAL = this.mParser.getLong(KEY_USAGE_STATS_INTERACTION_INTERVAL, 7200000);
            this.SERVICE_RESTART_DURATION = this.mParser.getLong(KEY_SERVICE_RESTART_DURATION, DEFAULT_SERVICE_RESTART_DURATION);
            this.SERVICE_RESET_RUN_DURATION = this.mParser.getLong(KEY_SERVICE_RESET_RUN_DURATION, DEFAULT_SERVICE_RESET_RUN_DURATION);
            this.SERVICE_RESTART_DURATION_FACTOR = this.mParser.getInt(KEY_SERVICE_RESTART_DURATION_FACTOR, 4);
            this.SERVICE_MIN_RESTART_TIME_BETWEEN = this.mParser.getLong(KEY_SERVICE_MIN_RESTART_TIME_BETWEEN, DEFAULT_SERVICE_MIN_RESTART_TIME_BETWEEN);
            this.MAX_SERVICE_INACTIVITY = this.mParser.getLong(KEY_MAX_SERVICE_INACTIVITY, DEFAULT_MAX_SERVICE_INACTIVITY);
            this.BG_START_TIMEOUT = this.mParser.getLong(KEY_BG_START_TIMEOUT, DEFAULT_BG_START_TIMEOUT);
            this.SERVICE_BG_ACTIVITY_START_TIMEOUT = this.mParser.getLong(KEY_SERVICE_BG_ACTIVITY_START_TIMEOUT, 10000);
            this.BOUND_SERVICE_CRASH_RESTART_DURATION = this.mParser.getLong(KEY_BOUND_SERVICE_CRASH_RESTART_DURATION, DEFAULT_BOUND_SERVICE_CRASH_RESTART_DURATION);
            this.BOUND_SERVICE_MAX_CRASH_RETRY = (long) this.mParser.getInt(KEY_BOUND_SERVICE_CRASH_MAX_RETRY, DEFAULT_BOUND_SERVICE_CRASH_MAX_RETRY);
            this.FLAG_PROCESS_START_ASYNC = this.mParser.getBoolean(KEY_PROCESS_START_ASYNC, true);
            this.MEMORY_INFO_THROTTLE_TIME = this.mParser.getLong(KEY_MEMORY_INFO_THROTTLE_TIME, 300000);
            this.TOP_TO_FGS_GRACE_DURATION = this.mParser.getDurationMillis(KEY_TOP_TO_FGS_GRACE_DURATION, (long) DEFAULT_TOP_TO_FGS_GRACE_DURATION);
            updateMaxCachedProcesses();
        }
        ActivityManagerService.resetPriorityAfterLockedSection();
    }

    private void updateActivityStartsLoggingEnabled() {
        boolean z = true;
        if (Settings.Global.getInt(this.mResolver, "activity_starts_logging_enabled", 1) != 1) {
            z = false;
        }
        this.mFlagActivityStartsLoggingEnabled = z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateBackgroundActivityStarts() {
        this.mFlagBackgroundActivityStartsEnabled = DeviceConfig.getBoolean("activity_manager", KEY_DEFAULT_BACKGROUND_ACTIVITY_STARTS_ENABLED, false);
    }

    private void updateEnableAutomaticSystemServerHeapDumps() {
        if (!this.mSystemServerAutomaticHeapDumpEnabled) {
            Slog.wtf(TAG, "updateEnableAutomaticSystemServerHeapDumps called when leak detection disabled");
            return;
        }
        boolean z = true;
        if (Settings.Global.getInt(this.mResolver, "enable_automatic_system_server_heap_dumps", 1) != 1) {
            z = false;
        }
        this.mService.setDumpHeapDebugLimit(null, 0, z ? this.mSystemServerAutomaticHeapDumpPssThresholdBytes : 0, this.mSystemServerAutomaticHeapDumpPackageName);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateMaxCachedProcesses() {
        int i;
        String property = DeviceConfig.getProperty("activity_manager", KEY_MAX_CACHED_PROCESSES);
        try {
            if (this.mOverrideMaxCachedProcesses < 0) {
                i = TextUtils.isEmpty(property) ? DEFAULT_MAX_CACHED_PROCESSES : Integer.parseInt(property);
            } else {
                i = this.mOverrideMaxCachedProcesses;
            }
            this.CUR_MAX_CACHED_PROCESSES = i;
        } catch (NumberFormatException e) {
            Slog.e(TAG, "Unable to parse flag for max_cached_processes: " + property, e);
            this.CUR_MAX_CACHED_PROCESSES = DEFAULT_MAX_CACHED_PROCESSES;
        }
        this.CUR_MAX_EMPTY_PROCESSES = computeEmptyProcessLimit(this.CUR_MAX_CACHED_PROCESSES);
        int computeEmptyProcessLimit = computeEmptyProcessLimit(this.MAX_CACHED_PROCESSES);
        this.CUR_TRIM_EMPTY_PROCESSES = computeEmptyProcessLimit / 2;
        this.CUR_TRIM_CACHED_PROCESSES = (this.MAX_CACHED_PROCESSES - computeEmptyProcessLimit) / 3;
    }

    /* access modifiers changed from: package-private */
    public void dump(PrintWriter printWriter) {
        printWriter.println("ACTIVITY MANAGER SETTINGS (dumpsys activity settings) activity_manager_constants:");
        printWriter.print("  ");
        printWriter.print(KEY_MAX_CACHED_PROCESSES);
        printWriter.print("=");
        printWriter.println(this.MAX_CACHED_PROCESSES);
        printWriter.print("  ");
        printWriter.print(KEY_BACKGROUND_SETTLE_TIME);
        printWriter.print("=");
        printWriter.println(this.BACKGROUND_SETTLE_TIME);
        printWriter.print("  ");
        printWriter.print(KEY_FGSERVICE_MIN_SHOWN_TIME);
        printWriter.print("=");
        printWriter.println(this.FGSERVICE_MIN_SHOWN_TIME);
        printWriter.print("  ");
        printWriter.print(KEY_FGSERVICE_MIN_REPORT_TIME);
        printWriter.print("=");
        printWriter.println(this.FGSERVICE_MIN_REPORT_TIME);
        printWriter.print("  ");
        printWriter.print(KEY_FGSERVICE_SCREEN_ON_BEFORE_TIME);
        printWriter.print("=");
        printWriter.println(this.FGSERVICE_SCREEN_ON_BEFORE_TIME);
        printWriter.print("  ");
        printWriter.print(KEY_FGSERVICE_SCREEN_ON_AFTER_TIME);
        printWriter.print("=");
        printWriter.println(this.FGSERVICE_SCREEN_ON_AFTER_TIME);
        printWriter.print("  ");
        printWriter.print(KEY_CONTENT_PROVIDER_RETAIN_TIME);
        printWriter.print("=");
        printWriter.println(this.CONTENT_PROVIDER_RETAIN_TIME);
        printWriter.print("  ");
        printWriter.print(KEY_GC_TIMEOUT);
        printWriter.print("=");
        printWriter.println(this.GC_TIMEOUT);
        printWriter.print("  ");
        printWriter.print(KEY_GC_MIN_INTERVAL);
        printWriter.print("=");
        printWriter.println(this.GC_MIN_INTERVAL);
        printWriter.print("  ");
        printWriter.print(KEY_FULL_PSS_MIN_INTERVAL);
        printWriter.print("=");
        printWriter.println(this.FULL_PSS_MIN_INTERVAL);
        printWriter.print("  ");
        printWriter.print(KEY_FULL_PSS_LOWERED_INTERVAL);
        printWriter.print("=");
        printWriter.println(this.FULL_PSS_LOWERED_INTERVAL);
        printWriter.print("  ");
        printWriter.print(KEY_POWER_CHECK_INTERVAL);
        printWriter.print("=");
        printWriter.println(this.POWER_CHECK_INTERVAL);
        printWriter.print("  ");
        printWriter.print(KEY_POWER_CHECK_MAX_CPU_1);
        printWriter.print("=");
        printWriter.println(this.POWER_CHECK_MAX_CPU_1);
        printWriter.print("  ");
        printWriter.print(KEY_POWER_CHECK_MAX_CPU_2);
        printWriter.print("=");
        printWriter.println(this.POWER_CHECK_MAX_CPU_2);
        printWriter.print("  ");
        printWriter.print(KEY_POWER_CHECK_MAX_CPU_3);
        printWriter.print("=");
        printWriter.println(this.POWER_CHECK_MAX_CPU_3);
        printWriter.print("  ");
        printWriter.print(KEY_POWER_CHECK_MAX_CPU_4);
        printWriter.print("=");
        printWriter.println(this.POWER_CHECK_MAX_CPU_4);
        printWriter.print("  ");
        printWriter.print(KEY_SERVICE_USAGE_INTERACTION_TIME);
        printWriter.print("=");
        printWriter.println(this.SERVICE_USAGE_INTERACTION_TIME);
        printWriter.print("  ");
        printWriter.print(KEY_USAGE_STATS_INTERACTION_INTERVAL);
        printWriter.print("=");
        printWriter.println(this.USAGE_STATS_INTERACTION_INTERVAL);
        printWriter.print("  ");
        printWriter.print(KEY_SERVICE_RESTART_DURATION);
        printWriter.print("=");
        printWriter.println(this.SERVICE_RESTART_DURATION);
        printWriter.print("  ");
        printWriter.print(KEY_SERVICE_RESET_RUN_DURATION);
        printWriter.print("=");
        printWriter.println(this.SERVICE_RESET_RUN_DURATION);
        printWriter.print("  ");
        printWriter.print(KEY_SERVICE_RESTART_DURATION_FACTOR);
        printWriter.print("=");
        printWriter.println(this.SERVICE_RESTART_DURATION_FACTOR);
        printWriter.print("  ");
        printWriter.print(KEY_SERVICE_MIN_RESTART_TIME_BETWEEN);
        printWriter.print("=");
        printWriter.println(this.SERVICE_MIN_RESTART_TIME_BETWEEN);
        printWriter.print("  ");
        printWriter.print(KEY_MAX_SERVICE_INACTIVITY);
        printWriter.print("=");
        printWriter.println(this.MAX_SERVICE_INACTIVITY);
        printWriter.print("  ");
        printWriter.print(KEY_BG_START_TIMEOUT);
        printWriter.print("=");
        printWriter.println(this.BG_START_TIMEOUT);
        printWriter.print("  ");
        printWriter.print(KEY_SERVICE_BG_ACTIVITY_START_TIMEOUT);
        printWriter.print("=");
        printWriter.println(this.SERVICE_BG_ACTIVITY_START_TIMEOUT);
        printWriter.print("  ");
        printWriter.print(KEY_BOUND_SERVICE_CRASH_RESTART_DURATION);
        printWriter.print("=");
        printWriter.println(this.BOUND_SERVICE_CRASH_RESTART_DURATION);
        printWriter.print("  ");
        printWriter.print(KEY_BOUND_SERVICE_CRASH_MAX_RETRY);
        printWriter.print("=");
        printWriter.println(this.BOUND_SERVICE_MAX_CRASH_RETRY);
        printWriter.print("  ");
        printWriter.print(KEY_PROCESS_START_ASYNC);
        printWriter.print("=");
        printWriter.println(this.FLAG_PROCESS_START_ASYNC);
        printWriter.print("  ");
        printWriter.print(KEY_MEMORY_INFO_THROTTLE_TIME);
        printWriter.print("=");
        printWriter.println(this.MEMORY_INFO_THROTTLE_TIME);
        printWriter.print("  ");
        printWriter.print(KEY_TOP_TO_FGS_GRACE_DURATION);
        printWriter.print("=");
        printWriter.println(this.TOP_TO_FGS_GRACE_DURATION);
        printWriter.println();
        if (this.mOverrideMaxCachedProcesses >= 0) {
            printWriter.print("  mOverrideMaxCachedProcesses=");
            printWriter.println(this.mOverrideMaxCachedProcesses);
        }
        printWriter.print("  CUR_MAX_CACHED_PROCESSES=");
        printWriter.println(this.CUR_MAX_CACHED_PROCESSES);
        printWriter.print("  CUR_MAX_EMPTY_PROCESSES=");
        printWriter.println(this.CUR_MAX_EMPTY_PROCESSES);
        printWriter.print("  CUR_TRIM_EMPTY_PROCESSES=");
        printWriter.println(this.CUR_TRIM_EMPTY_PROCESSES);
        printWriter.print("  CUR_TRIM_CACHED_PROCESSES=");
        printWriter.println(this.CUR_TRIM_CACHED_PROCESSES);
    }
}
