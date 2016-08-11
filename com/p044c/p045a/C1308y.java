package com.p044c.p045a;

import java.io.PrintWriter;

/* renamed from: com.c.a.y */
public class C1308y {
    public final int f3987a;
    public final int f3988b;
    public final long f3989c;
    public final long f3990d;
    public final long f3991e;
    public final long f3992f;
    public final long f3993g;
    public final long f3994h;
    public final long f3995i;
    public final long f3996j;
    public final int f3997k;
    public final int f3998l;
    public final int f3999m;
    public final long f4000n;

    public C1308y(int maxSize, int size, long cacheHits, long cacheMisses, long totalDownloadSize, long totalOriginalBitmapSize, long totalTransformedBitmapSize, long averageDownloadSize, long averageOriginalBitmapSize, long averageTransformedBitmapSize, int downloadCount, int originalBitmapCount, int transformedBitmapCount, long timeStamp) {
        this.f3987a = maxSize;
        this.f3988b = size;
        this.f3989c = cacheHits;
        this.f3990d = cacheMisses;
        this.f3991e = totalDownloadSize;
        this.f3992f = totalOriginalBitmapSize;
        this.f3993g = totalTransformedBitmapSize;
        this.f3994h = averageDownloadSize;
        this.f3995i = averageOriginalBitmapSize;
        this.f3996j = averageTransformedBitmapSize;
        this.f3997k = downloadCount;
        this.f3998l = originalBitmapCount;
        this.f3999m = transformedBitmapCount;
        this.f4000n = timeStamp;
    }

    public void m5547a(PrintWriter writer) {
        writer.println("===============BEGIN PICASSO STATS ===============");
        writer.println("Memory Cache Stats");
        writer.print("  Max Cache Size: ");
        writer.println(this.f3987a);
        writer.print("  Cache Size: ");
        writer.println(this.f3988b);
        writer.print("  Cache % Full: ");
        writer.println((int) Math.ceil((double) ((((float) this.f3988b) / ((float) this.f3987a)) * 100.0f)));
        writer.print("  Cache Hits: ");
        writer.println(this.f3989c);
        writer.print("  Cache Misses: ");
        writer.println(this.f3990d);
        writer.println("Network Stats");
        writer.print("  Download Count: ");
        writer.println(this.f3997k);
        writer.print("  Total Download Size: ");
        writer.println(this.f3991e);
        writer.print("  Average Download Size: ");
        writer.println(this.f3994h);
        writer.println("Bitmap Stats");
        writer.print("  Total Bitmaps Decoded: ");
        writer.println(this.f3998l);
        writer.print("  Total Bitmap Size: ");
        writer.println(this.f3992f);
        writer.print("  Total Transformed Bitmaps: ");
        writer.println(this.f3999m);
        writer.print("  Total Transformed Bitmap Size: ");
        writer.println(this.f3993g);
        writer.print("  Average Bitmap Size: ");
        writer.println(this.f3995i);
        writer.print("  Average Transformed Bitmap Size: ");
        writer.println(this.f3996j);
        writer.println("===============END PICASSO STATS ===============");
        writer.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f3987a + ", size=" + this.f3988b + ", cacheHits=" + this.f3989c + ", cacheMisses=" + this.f3990d + ", downloadCount=" + this.f3997k + ", totalDownloadSize=" + this.f3991e + ", averageDownloadSize=" + this.f3994h + ", totalOriginalBitmapSize=" + this.f3992f + ", totalTransformedBitmapSize=" + this.f3993g + ", averageOriginalBitmapSize=" + this.f3995i + ", averageTransformedBitmapSize=" + this.f3996j + ", originalBitmapCount=" + this.f3998l + ", transformedBitmapCount=" + this.f3999m + ", timeStamp=" + this.f4000n + '}';
    }
}
