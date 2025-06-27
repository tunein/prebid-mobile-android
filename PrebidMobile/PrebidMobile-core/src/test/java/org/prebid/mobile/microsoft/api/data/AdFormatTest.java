package org.prebid.mobile.microsoft.api.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.prebid.mobile.microsoft.api.data.AdFormat;
import org.prebid.mobile.microsoft.api.data.AdUnitFormat;

import java.util.EnumSet;

public class AdFormatTest {

    @Test
    public void adFormatsFromSet_isNotInterstitial_banner() {
        EnumSet<AdUnitFormat> input = EnumSet.of(AdUnitFormat.BANNER);
        EnumSet<AdFormat> expected = EnumSet.of(AdFormat.BANNER);

        assertEquals(expected, AdFormat.fromSet(input, false));
    }

    @Test
    public void adFormatsFromSet_isInterstitial_banner() {
        EnumSet<AdUnitFormat> input = EnumSet.of(AdUnitFormat.BANNER);
        EnumSet<AdFormat> expected = EnumSet.of(AdFormat.INTERSTITIAL);

        assertEquals(expected, AdFormat.fromSet(input, true));
    }

    @Test
    public void adFormatsFromSet_isNotInterstitial_two() {
        EnumSet<AdUnitFormat> input = EnumSet.of(AdUnitFormat.VIDEO, AdUnitFormat.BANNER);
        EnumSet<AdFormat> expected = EnumSet.of(AdFormat.VAST, AdFormat.BANNER);

        assertEquals(expected, AdFormat.fromSet(input, false));
    }

    @Test
    public void adFormatsFromSet_isInterstitial_two() {
        EnumSet<AdUnitFormat> input = EnumSet.of(AdUnitFormat.VIDEO, AdUnitFormat.BANNER);
        EnumSet<AdFormat> expected = EnumSet.of(AdFormat.VAST, AdFormat.INTERSTITIAL);

        assertEquals(expected, AdFormat.fromSet(input, true));
    }

    @Test
    public void adFormatsFromSet_video() {
        EnumSet<AdUnitFormat> input = EnumSet.of(AdUnitFormat.VIDEO);
        EnumSet<AdFormat> expected = EnumSet.of(AdFormat.VAST);

        assertEquals(expected, AdFormat.fromSet(input, false));
    }

}
