package com.flow.platform.cc.test.service;

import com.flow.platform.cc.service.ZoneService;
import com.flow.platform.cc.test.TestBase;
import com.flow.platform.domain.Zone;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gy@fir.im on 06/06/2017.
 * Copyright fir.im
 */
public class ZoneServiceTest extends TestBase {

    @Autowired
    private ZoneService zoneService;

    @Test
    public void should_create_and_get_zones() {
        // when: create zone;
        String path1 = zoneService.createZone(new Zone("my-test-zone-1", "mock-provider-name"));
        Assert.assertNotNull(path1);
        Assert.assertNotNull("/flow-agents/my-test-zone-1", path1);

        String path2 = zoneService.createZone(new Zone("my-test-zone-2", "mock-provider-name"));
        Assert.assertNotNull(path2);
        Assert.assertNotNull("/flow-agents/my-test-zone-2", path2);

        // then:
        List<Zone> zones = zoneService.getZones();
        Assert.assertNotNull(zones);
        Assert.assertTrue(zones.size() >= 4); // 2 for default, 2 for created
    }
}