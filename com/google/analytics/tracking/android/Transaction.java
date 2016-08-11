package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Transaction {
    private final String f4249a;
    private final String f4250b;
    private final long f4251c;
    private final long f4252d;
    private final long f4253e;
    private final String f4254f;
    private final Map f4255g;

    public static final class Builder {
        private final String f4233a;
        private String f4234b;
        private final long f4235c;
        private long f4236d;
        private long f4237e;
        private String f4238f;

        public Builder(String transactionId, long totalCostInMicros) {
            this.f4234b = null;
            this.f4236d = 0;
            this.f4237e = 0;
            this.f4238f = null;
            if (TextUtils.isEmpty(transactionId)) {
                throw new IllegalArgumentException("orderId must not be empty or null");
            }
            this.f4233a = transactionId;
            this.f4235c = totalCostInMicros;
        }

        public Builder m5817a(String affiliation) {
            this.f4234b = affiliation;
            return this;
        }

        public Builder m5816a(long totalTaxInMicros) {
            this.f4236d = totalTaxInMicros;
            return this;
        }

        public Builder m5819b(long shippingCostInMicros) {
            this.f4237e = shippingCostInMicros;
            return this;
        }

        public Builder m5820b(String currencyCode) {
            this.f4238f = currencyCode;
            return this;
        }

        public Transaction m5818a() {
            return new Transaction();
        }
    }

    public static final class Item {
        private final String f4244a;
        private final String f4245b;
        private final String f4246c;
        private final long f4247d;
        private final long f4248e;

        public static final class Builder {
            private final String f4239a;
            private final long f4240b;
            private final long f4241c;
            private final String f4242d;
            private String f4243e;

            public Builder(String SKU, String name, long priceInMicros, long quantity) {
                this.f4243e = null;
                if (TextUtils.isEmpty(SKU)) {
                    throw new IllegalArgumentException("SKU must not be empty or null");
                } else if (TextUtils.isEmpty(name)) {
                    throw new IllegalArgumentException("name must not be empty or null");
                } else {
                    this.f4239a = SKU;
                    this.f4242d = name;
                    this.f4240b = priceInMicros;
                    this.f4241c = quantity;
                }
            }

            public Builder m5826a(String productCategory) {
                this.f4243e = productCategory;
                return this;
            }

            public Item m5827a() {
                return new Item();
            }
        }

        private Item(Builder builder) {
            this.f4244a = builder.f4239a;
            this.f4247d = builder.f4240b;
            this.f4248e = builder.f4241c;
            this.f4245b = builder.f4242d;
            this.f4246c = builder.f4243e;
        }

        public String m5828a() {
            return this.f4244a;
        }

        public String m5829b() {
            return this.f4245b;
        }

        public String m5830c() {
            return this.f4246c;
        }

        public long m5831d() {
            return this.f4247d;
        }

        public long m5832e() {
            return this.f4248e;
        }
    }

    private Transaction(Builder builder) {
        this.f4249a = builder.f4233a;
        this.f4251c = builder.f4235c;
        this.f4250b = builder.f4234b;
        this.f4252d = builder.f4236d;
        this.f4253e = builder.f4237e;
        this.f4254f = builder.f4238f;
        this.f4255g = new HashMap();
    }

    public String m5833a() {
        return this.f4249a;
    }

    public String m5835b() {
        return this.f4250b;
    }

    public long m5836c() {
        return this.f4251c;
    }

    public long m5837d() {
        return this.f4252d;
    }

    public long m5838e() {
        return this.f4253e;
    }

    public String m5839f() {
        return this.f4254f;
    }

    public void m5834a(Item item) {
        this.f4255g.put(item.m5828a(), item);
    }

    public List m5840g() {
        return new ArrayList(this.f4255g.values());
    }
}
