package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class Filters {
    public static Filter and(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.GZ, filter, additionalFilters);
    }

    public static Filter and(Iterable filters) {
        return new LogicalFilter(Operator.GZ, filters);
    }

    public static Filter contains(SearchableMetadataField field, String value) {
        return new ComparisonFilter(Operator.Hc, field, (Object) value);
    }

    public static Filter eq(SearchableMetadataField field, Object value) {
        return new ComparisonFilter(Operator.GU, field, value);
    }

    public static Filter greaterThan(SearchableOrderedMetadataField field, Comparable value) {
        return new ComparisonFilter(Operator.GX, (SearchableMetadataField) field, (Object) value);
    }

    public static Filter greaterThanEquals(SearchableOrderedMetadataField field, Comparable value) {
        return new ComparisonFilter(Operator.GY, (SearchableMetadataField) field, (Object) value);
    }

    public static Filter in(SearchableCollectionMetadataField field, Object value) {
        return new InFilter(field, value);
    }

    public static Filter lessThan(SearchableOrderedMetadataField field, Comparable value) {
        return new ComparisonFilter(Operator.GV, (SearchableMetadataField) field, (Object) value);
    }

    public static Filter lessThanEquals(SearchableOrderedMetadataField field, Comparable value) {
        return new ComparisonFilter(Operator.GW, (SearchableMetadataField) field, (Object) value);
    }

    public static Filter not(Filter toNegate) {
        return new NotFilter(toNegate);
    }

    public static Filter or(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.Ha, filter, additionalFilters);
    }

    public static Filter or(Iterable filters) {
        return new LogicalFilter(Operator.Ha, filters);
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.GE);
    }
}
