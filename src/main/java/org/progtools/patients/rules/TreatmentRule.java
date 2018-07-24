/* TreatmentRule.java - Defines the general concept of rules.
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

import java.util.Set;

/**
 * Represents a generic rule for treating patients.
 */
public interface TreatmentRule {
    /**
     * Applies a specific treatment to the patient.
     *
     * @param patient A patient to treat.
     * @param drugs Set of drugs to give to the patient.
     * @return The given patient parameter as convenience.
     */
    Patient applyTreatment(Patient patient, Set<Drugs> drugs);
}
