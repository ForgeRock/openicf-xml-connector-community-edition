/*
 *
 * Copyright (c) 2010 ForgeRock Inc. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://www.opensource.org/licenses/cddl1.php or
 * OpenIDM/legal/CDDLv1.0.txt
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at OpenIDM/legal/CDDLv1.0.txt.
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted 2010 [name of copyright owner]"
 *
 * $Id$
 */

package com.forgerock.openicf.xml.tests;

import com.forgerock.openicf.xml.XMLConfiguration;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class XMLConfigurationTests {

    private XMLConfiguration config;

    @Before
    public void init() {
       config = new XMLConfiguration();
    }

    @Test
    public void shouldGetXmlFilepathFromConfiguration() {
        final String filePath = "users.xml";

        config.setXmlFilePath(filePath);
        assertEquals(filePath, config.getXmlFilePath());
    }

    @Test
    public void shouldGetICFXsdFilepathFromConfiguration() {
        final String xsdPath = "xsdRi.xsd";

        config.setXsdIcfFilePath(xsdPath);
        assertEquals(xsdPath, config.getXsdIcfFilePath());
    }

    @Test
    public void shouldGetXsdFilepathFromConfiguration() {
        final String xsdPath = "xsdTest.xsd";

        config.setXsdFilePath(xsdPath);
        assertEquals(xsdPath, config.getXsdFilePath());
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenValidatingWithNullFilepath() {
        config.setXmlFilePath(null);
        config.validate();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenValidatingWithBlankFilepath() {
        config.setXmlFilePath("");
        config.validate();
    }
}