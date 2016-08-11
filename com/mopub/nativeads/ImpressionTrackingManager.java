package com.mopub.nativeads;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class ImpressionTrackingManager {
    private static final int PERIOD = 250;
    private static AtomicBoolean mIsStarted;
    private static WeakHashMap sKeptViews;
    private static final ScheduledExecutorService sScheduledExecutorService;
    private static final VisibilityCheck sVisibilityCheck;

    static class NativeResponseWrapper {
        long mFirstVisibleTimestamp;
        final NativeResponse mNativeResponse;

        NativeResponseWrapper(NativeResponse nativeResponse) {
            this.mNativeResponse = nativeResponse;
            this.mFirstVisibleTimestamp = 0;
        }
    }

    static class VisibilityCheck implements Runnable {
        VisibilityCheck() {
        }

        public void run() {
            Iterator entryIterator = ImpressionTrackingManager.sKeptViews.entrySet().iterator();
            while (entryIterator.hasNext()) {
                Entry entry = (Entry) entryIterator.next();
                View view = (View) entry.getKey();
                NativeResponseWrapper nativeResponseWrapper = (NativeResponseWrapper) entry.getValue();
                if (nativeResponseWrapper == null || nativeResponseWrapper.mNativeResponse == null) {
                    try {
                        entryIterator.remove();
                    } catch (ConcurrentModificationException e) {
                    }
                } else if (nativeResponseWrapper.mNativeResponse.isDestroyed()) {
                    try {
                        entryIterator.remove();
                    } catch (ConcurrentModificationException e2) {
                    }
                } else if (nativeResponseWrapper.mNativeResponse.getRecordedImpression()) {
                    try {
                        entryIterator.remove();
                    } catch (ConcurrentModificationException e3) {
                    }
                } else if (!isVisible(view, nativeResponseWrapper)) {
                    nativeResponseWrapper.mFirstVisibleTimestamp = 0;
                } else if (nativeResponseWrapper.mFirstVisibleTimestamp == 0) {
                    nativeResponseWrapper.mFirstVisibleTimestamp = SystemClock.uptimeMillis();
                } else if (SystemClock.uptimeMillis() - nativeResponseWrapper.mFirstVisibleTimestamp >= ((long) nativeResponseWrapper.mNativeResponse.getImpressionMinTimeViewed())) {
                    nativeResponseWrapper.mNativeResponse.recordImpression(view);
                    try {
                        entryIterator.remove();
                    } catch (ConcurrentModificationException e4) {
                    }
                }
            }
        }

        static boolean isVisible(View view, NativeResponseWrapper nativeResponseWrapper) {
            if (view == null || nativeResponseWrapper == null || view.getVisibility() != 0) {
                return false;
            }
            Rect visibleRect = new Rect();
            view.getGlobalVisibleRect(visibleRect);
            int visibleViewArea = visibleRect.width() * visibleRect.height();
            int totalViewArea = view.getWidth() * view.getHeight();
            if (totalViewArea <= 0 || ((double) ((visibleViewArea * 100) / totalViewArea)) < ((double) nativeResponseWrapper.mNativeResponse.getImpressionMinPercentageViewed())) {
                return false;
            }
            return true;
        }
    }

    ImpressionTrackingManager() {
    }

    static {
        sKeptViews = new WeakHashMap(10);
        sScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        sVisibilityCheck = new VisibilityCheck();
        mIsStarted = new AtomicBoolean(false);
    }

    static void start() {
        if (mIsStarted.compareAndSet(false, true)) {
            sScheduledExecutorService.scheduleWithFixedDelay(sVisibilityCheck, 0, 250, TimeUnit.MILLISECONDS);
        }
    }

    static void stop() {
        if (mIsStarted.compareAndSet(true, false)) {
            sScheduledExecutorService.shutdownNow();
        }
    }

    static void addView(View view, NativeResponse nativeResponse) {
        if (view != null && nativeResponse != null) {
            sKeptViews.put(view, new NativeResponseWrapper(nativeResponse));
        }
    }

    static void removeView(View view) {
        sKeptViews.remove(view);
    }

    @Deprecated
    static void purgeViews() {
        sKeptViews.clear();
    }

    @Deprecated
    static Map getKeptViews() {
        return sKeptViews;
    }
}
