/* RulesEngine.java - A rules engine for the medications.
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

import org.progtools.patients.rules.TreatmentRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A simple rules engine to apply the sequence of drugs to a patient.
 */
class RulesEngine {
    private final List<TreatmentRule> treatments;

    public RulesEngine() {
        treatments = new ArrayList<>();
    }

    /**
     * Adds a new rule into the sequence of treatments.
     */
    public void addTreatmentRule(TreatmentRule rule) {
        treatments.add(rule);
    }

    /**
     * Goes through a list of patients applying the set of treatments to each
     * of them, with the given drugs.
     *
     * @param patients A list of patients to treat.
     * @param drugs The drugs to give to them.
     * @return The same parameter as patients as convenience.
     */
    public List<Patient> applyRules(List<Patient> patients, Set<Drugs> drugs) {
        if (patients != null && drugs != null) {
            for (Patient patient : patients) {
                for (TreatmentRule rule : treatments) {
                    rule.applyTreatment(patient, drugs);
                }
            }
        }

        return  patients;
    }

}
