package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.PlacementType;

class MraidPlacementTypeProperty extends MraidProperty {
    private final PlacementType mPlacementType;

    MraidPlacementTypeProperty(PlacementType placementType) {
        this.mPlacementType = placementType;
    }

    public static MraidPlacementTypeProperty createWithType(PlacementType placementType) {
        return new MraidPlacementTypeProperty(placementType);
    }

    public String toJsonPair() {
        return "placementType: '" + this.mPlacementType.toString().toLowerCase() + "'";
    }
}
