/*
 * Copyright 2017 flow.ci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flow.platform.cc.service;

import com.flow.platform.util.zk.ZKServer;
import com.flow.platform.util.Logger;
import com.flow.platform.util.zk.ZKClient;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yang
 */
@Service
public class ZooKeeperServiceImpl implements ZooKeeperService {

    private final static Logger LOGGER = new Logger(ZooKeeperService.class);

    @Autowired
    private ZKClient client;

    @Autowired
    private ZKServer zkServer;

    @Override
    public void start() {
        // not start since ZKClient been started in zookeeper config
    }

    @Override
    public void stop() {
        try {
            client.close();
            if (zkServer != null) {
                zkServer.stop();
            }
        } catch (IOException e) {
            LOGGER.warn("Fail to close zk client connection: %s", e.getMessage());
        }
    }
}
