/* DrugsTests.java - Unit tests for the drugs enumeration.
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

class DrugsTests {
    @Test
    void testAspirinParsing() {
        assertEquals(Drugs.Aspirin, Drugs.parse("As"));
    }

    @Test
    void testAntibioticParsing() {
        assertEquals(Drugs.Antibiotic, Drugs.parse("An"));
    }

    @Test
    void testInsulinParsing() {
        assertEquals(Drugs.Insulin, Drugs.parse("I"));
    }

    @Test
    void testParacetalmolParsing() {
        assertEquals(Drugs.Paracetamol, Drugs.parse("P"));
    }

    @Test
    void testNullParsing() {
        assertThrows(IllegalArgumentException.class, () ->
                Drugs.parse(null));
    }

    @Test
    void testEmptyParsing() {
        assertThrows(IllegalArgumentException.class, () ->
                Drugs.parse(""));
    }
}
