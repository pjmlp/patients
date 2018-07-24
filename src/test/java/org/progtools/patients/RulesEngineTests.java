/* RulesEngineTests.java - Unit tests for the rules engine.
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

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RulesEngineTests {
    @Test
    void testBothNullParams() {
        RulesEngine engine = new RulesEngine();
        List<Patient> result = engine.applyRules(null, null);

        assertNull(result);
    }

    @Test
    void testPantientNullParams() {
        RulesEngine engine = new RulesEngine();
        List<Patient> result = engine.applyRules(null, new HashSet<>());

        assertNull(result);
    }

    @Test
    void testDrugsNullParams() {
        List<Patient> patients = new ArrayList<>();
        RulesEngine engine = new RulesEngine();
        List<Patient> result = engine.applyRules(patients, null);

        assertNotNull(result);
        assertEquals(result, patients);
    }

    @Test
    void testAddTreatments() {
        Patient patient = new Patient(States.Fever);
        List<Patient> patients = List.of(patient);

        Set<Drugs> drugs = Set.of(Drugs.Aspirin, Drugs.Insulin);

        RulesEngine engine = new RulesEngine();
        engine.addTreatmentRule((patientsList, drugsSet) -> {
            patientsList.setState(States.Healthy);
            return  patientsList;
        });

        List<Patient> result = engine.applyRules(patients, drugs);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertSame(result.get(0), patient);
        assertEquals(States.Healthy, patient.getState());
    }
}
