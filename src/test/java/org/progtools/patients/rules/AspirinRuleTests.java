/* AspirinRuleTests.java - Unit tests for the aspirin rules.
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
package org.progtools.patients.rules;

import org.progtools.patients.Drugs;
import org.progtools.patients.Patient;
import org.progtools.patients.States;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AspirinRuleTests {
    @Test
    void testAspirinWithFever() {
        Patient patient = new Patient(States.Fever);
        Set<Drugs> drugs = Set.of(Drugs.Aspirin);
        AspirinRule rule = new AspirinRule();

        Patient result = rule.applyTreatment(patient, drugs);

        assertNotNull(result);
        assertEquals(result, patient);
        assertEquals(States.Healthy, result.getState());
    }

    @Test
    void testAspirinWithRemainingStates() {
        Set<Drugs> drugs = Set.of(Drugs.Aspirin);
        AspirinRule rule = new AspirinRule();

        for (States state:States.values()) {
            if (state != States.Fever) {
                Patient patient = new Patient(state);


                Patient result = rule.applyTreatment(patient, drugs);

                assertNotNull(result);
                assertEquals(result, patient);
                assertEquals(state, result.getState());
            }
        }
    }
}
