/* DrugsParser.java - Drugs string parser.
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

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Takes care of parsing the drugs input values
 */
class DrugsParser {
    /**
     * Parses the drugs definition.
     *
     * For valid representations see {@link Drugs#parse}.
     *
     *
     * @param data A string of the form letter1,letter2,....,letterN
     * @return The drugs represented in the given data or empty
     * @throws IllegalArgumentException If data contains invalid values
     */
    static Set<Drugs> parse(String data) {
        if (data != null && !data.isEmpty()) {
            return  Arrays.stream(data.split(",")).map(Drugs::parse).collect(Collectors.toSet());
        } else {
            return Set.of();
        }
    }
}
