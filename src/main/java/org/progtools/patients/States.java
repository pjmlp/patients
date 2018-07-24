/* States.java - Patient states.
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

/**
 * Represents the set of patient states
 */
public enum States {
    Fever, Healthy, Diabetes, Tuberculosis, Dead;

    /**
     * Converts the character code into the proper enumeration.
     * @param str A valid state code (F, H, D, T, X)
     * @return The corresponding enumeration
     * @throws IllegalArgumentException if the given code is invalid or null
     */
    static States parse(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Parameter cannot be null!");
        }

        switch (str) {
            case "F":
                return Fever;

            case "H":
                return Healthy;

            case "D":
                return Diabetes;

            case "T":
                return Tuberculosis;

            case "X":
                return Dead;

            default:
                throw new IllegalArgumentException("Unknown value " + str);
        }
    }

    /**
     * @return The single letter representation of the enumeration value
     */
    String toCode() {
        switch (this) {
            case Fever:
                return "F";

            case Healthy:
                return "H";

            case Diabetes:
                return "D";

            case Tuberculosis:
                return "T";

            case Dead:
                return "X";

            default:
                throw new IllegalArgumentException("Missing enumeration " + this);

        }
    }
}
