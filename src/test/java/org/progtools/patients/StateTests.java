/* StateTests.java - Unit tests for the State enumeration.
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StateTests {

    @Test
    void testFeverParsing() {
        assertEquals(States.Fever, States.parse("F"));
    }

    @Test
    void testHealthyParsing() {
        assertEquals(States.Healthy, States.parse("H"));
    }

    @Test
    void testDiabetsParsing() {
        assertEquals(States.Diabetes, States.parse("D"));
    }


    @Test
    void testTuberculosisParsing() {
        assertEquals(States.Tuberculosis, States.parse("T"));
    }

    @Test
    void testDeadParsing() {
        assertEquals(States.Dead, States.parse("X"));
    }

    @Test
    void testFeverToCode() {
        assertEquals("F", States.Fever.toCode());
    }

    @Test
    void testHealthyToCode() {
        assertEquals("H", States.Healthy.toCode());
    }

    @Test
    void testDiabetsToCode() {
        assertEquals("D", States.Diabetes.toCode());
    }

    @Test
    void testTuberculosisToCode() {
        assertEquals("T", States.Tuberculosis.toCode());
    }

    @Test
    void testDeadToCode() {
        assertEquals("X", States.Dead.toCode());
    }

    @Test
    void testNullParsing() {
        assertThrows(IllegalArgumentException.class, () ->
                States.parse(null));
    }

    @Test
    void testEmptyParsing() {
        assertThrows(IllegalArgumentException.class, () ->
                States.parse(""));
    }

}
