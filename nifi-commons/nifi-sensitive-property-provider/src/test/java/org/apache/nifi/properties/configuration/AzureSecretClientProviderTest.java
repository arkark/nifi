/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.properties.configuration;

import com.azure.security.keyvault.secrets.SecretClient;
import org.apache.nifi.util.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AzureSecretClientProviderTest {

    @Test
    public void testClientPropertiesNull() {
        final AzureSecretClientProvider provider = new AzureSecretClientProvider();
        final Optional<SecretClient> optionalClient = provider.getClient(null);
        assertFalse(optionalClient.isPresent());
    }

    @Test
    public void testClientPropertiesUriBlank() {
        final AzureSecretClientProvider provider = new AzureSecretClientProvider();
        final Properties clientProperties = new Properties();
        clientProperties.setProperty(AzureSecretClientProvider.URI_PROPERTY, StringUtils.EMPTY);
        final Optional<SecretClient> optionalClient = provider.getClient(clientProperties);
        assertFalse(optionalClient.isPresent());
    }
}
