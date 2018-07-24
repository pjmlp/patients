/* DrugsParserTests.java - Unit tests for the drugs parser.
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

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DrugsParserTests {
    @Test
    void testEmptyData() {
        assertEquals(Set.of(), DrugsParser.parse(""));
    }

    @Test
    void testNullData() {
        assertEquals(Set.of(), DrugsParser.parse(null));
    }

    @Test
    void testEmptyDataWithSingleComma() {
        assertEquals(Set.of(), DrugsParser.parse(","));
    }

    @Test
    void testEmptyDataWithComma() {
        assertEquals(Set.of(), DrugsParser.parse(",,"));
    }

    @Test
    void testSampleData() {
        Set<Drugs> drugs= DrugsParser.parse("P,An");
        assertNotNull(drugs);
        assertEquals(2, drugs.size());
        assertTrue(drugs.contains(Drugs.Paracetamol));
        assertTrue(drugs.contains(Drugs.Antibiotic));
    }

    @Test
    void testSampleDataCommaAtEnd() {
        Set<Drugs> drugs= DrugsParser.parse("P,An,");
        assertNotNull(drugs);
        assertEquals(2, drugs.size());
        assertTrue(drugs.contains(Drugs.Paracetamol));
        assertTrue(drugs.contains(Drugs.Antibiotic));
    }
}
