/* PatientParser.java - A patient string parser.
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

import java.util.ArrayList;
import java.util.List;

/**
 * Takes care of parsing the patient input values
 */
class PatientParser {
    static List<Patient> parse(String data) {
        var result = new ArrayList<Patient>();

        if (data != null && !data.isEmpty()) {
            for (String code : data.split(",")) {
                States state = States.parse(code);

                result.add(new Patient(state));
            }
        }

        return result;
    }
}
