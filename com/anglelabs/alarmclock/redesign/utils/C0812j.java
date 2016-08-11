package com.anglelabs.alarmclock.redesign.utils;

import java.util.HashSet;
import java.util.Random;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.j */
public final class C0812j {
    int f2134a;
    private HashSet f2135b;
    private final HashSet f2136c;

    public C0812j() {
        this.f2136c = new HashSet();
        this.f2134a = -1;
    }

    public int m3847a(int max) {
        Random randomNums = new Random(System.currentTimeMillis());
        int random = randomNums.nextInt(max);
        if (this.f2135b != null) {
            if (this.f2135b.size() <= max - 1) {
                while (true) {
                    if (!this.f2135b.contains(Integer.valueOf(random)) && !this.f2136c.contains(Integer.valueOf(random))) {
                        break;
                    }
                    random = randomNums.nextInt(max);
                }
            } else {
                this.f2135b.clear();
                if (random != -1 && this.f2134a == random) {
                    random = randomNums.nextInt(max);
                }
            }
        } else {
            this.f2135b = new HashSet();
        }
        this.f2135b.add(Integer.valueOf(random));
        this.f2134a = random;
        return random;
    }

    public void m3848b(int songlocation) {
        this.f2136c.add(Integer.valueOf(songlocation));
    }

    public int m3846a() {
        return this.f2136c.size();
    }
}
