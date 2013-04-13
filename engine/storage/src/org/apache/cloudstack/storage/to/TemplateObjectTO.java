// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package org.apache.cloudstack.storage.to;

import org.apache.cloudstack.engine.subsystem.api.storage.DataObjectType;
import org.apache.cloudstack.engine.subsystem.api.storage.DataTO;
import org.apache.cloudstack.engine.subsystem.api.storage.TemplateInfo;
import org.apache.cloudstack.engine.subsystem.api.storage.disktype.DiskFormat;
import org.apache.cloudstack.storage.image.datastore.ImageStoreInfo;

import com.cloud.agent.api.to.DataStoreTO;

public class TemplateObjectTO implements DataTO {
    private final String path;
    private final String uuid;
    private  DiskFormat diskType;
    private final ImageStoreTO imageDataStore;
    private final String name;

    public TemplateObjectTO(TemplateInfo template) {
        this.path = template.getUri();
        this.uuid = template.getUuid();
        //this.diskType = template.getDiskType();
        this.imageDataStore = new ImageStoreTO((ImageStoreInfo)template.getDataStore());
        this.name = template.getUniqueName();
    }
    
    @Override
    public String getPath() {
        return this.path;
    }
    
    public String getUuid() {
        return this.uuid;
    }
    
    public DiskFormat getDiskType() {
        return this.diskType;
    }
    
    public ImageStoreTO getImageDataStore() {
        return this.imageDataStore;
    }

    @Override
    public DataObjectType getObjectType() {
        return DataObjectType.TEMPLATE;
    }

    @Override
    public DataStoreTO getDataStore() {
        return (DataStoreTO)this.imageDataStore;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
