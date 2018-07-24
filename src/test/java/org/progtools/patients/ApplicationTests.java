/* ApplicationTests.java - Unit tests for the application.
 * Copyright (C) 2018 Paulo Pinto
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */
package org.progtools.patients;

import  org.progtools.patients.rules.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTests {
    private final RulesEngine engine;

    ApplicationTests() {
        // Create the default rule set for all unit tests
        engine = new RulesEngine();
        engine.addTreatmentRule(new AspirinRule());
        engine.addTreatmentRule(new AntibioticRule());
        engine.addTreatmentRule(new InsulinRule());
        engine.addTreatmentRule(new MissingInsulinRule());
        engine.addTreatmentRule(new ParacetamolRule());
    }


    @Test
    void testApplicationEmpty() {
        Application app = new Application("", "");
        app.processPatientTreatments(engine);
        assertEquals("F:0;H:0;D:0;T:0;X:0", app.generateResultData());
    }

    @Test
    void testFirstExample() {
        Application app = new Application("D,D", "");
        app.processPatientTreatments(engine);
        assertEquals("F:0;H:0;D:0;T:0;X:2", app.generateResultData());
    }

    @Test
    void testSecondExample() {
        Application app = new Application("F", "P");
        app.processPatientTreatments(engine);
        assertEquals("F:0;H:1;D:0;T:0;X:0", app.generateResultData());
    }

    @Test
    void testThirdExample() {
        Application app = new Application("D,D", "I");
        app.processPatientTreatments(engine);
        assertEquals("F:0;H:0;D:2;T:0;X:0", app.generateResultData());
    }

    @Test
    void testApplicationBadPatients() {
        assertThrows(IllegalArgumentException.class, () -> new Application("OS", ""));
    }

    @Test
    void testApplicationBadDrugs() {
        assertThrows(IllegalArgumentException.class, () -> new Application("D", "T"));
    }
}
