/* Application.java - Application entry point
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

import org.progtools.patients.rules.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Application business logic and startup code for the command line variant.
 */
class Application {
    private final List<Patient> patients;
    private final Set<Drugs> drugs;

    /**
     * Initializes the application with two datasets describing
     * patient states and sets of drugs.
     *
     * @param patientsData Comma separated string with any of values F, H, D, T, X
     * @param drugsData Comma separated string with any of values As, An, I, P
     * @throws IllegalArgumentException if any of given data is invalid or null
     */
    public Application(String patientsData, String drugsData) {
        patients= PatientParser.parse(patientsData);
        drugs= DrugsParser.parse(drugsData);
    }

    /**
     * Applies the rules engine to the existing data, changing its state
     * according to the set of configured rules.
     *
     * @param engine The rules to be applied.
     */
    public void processPatientTreatments(RulesEngine engine) {
        engine.applyRules(patients, drugs);
    }

    /**
     * Generates the output in the desired format for the console users.
     * @return  The formatted string to be displayed to the user or further processing
     */
    public String generateResultData() {
        var buffer = new StringBuilder();

        Map<States, Long> statistics = patients.stream().collect(Collectors.groupingBy(
                Patient::getState,
                Collectors.counting()));

        States[] states = States.values();
        for (int i = 0; i < states.length; i++) {
            Long count = statistics.getOrDefault(states[i], 0L);
            buffer.append(String.format("%s:%d", states[i].toCode(), count));
            if (i + 1 < states.length) {
                buffer.append(';');
            }
        }
        return  buffer.toString();
    }

    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                // handle the command line arguments.
                String patients = args[0];
                String drugs;

                if (args.length > 1) {
                    drugs = args[1];
                } else {
                    drugs = "";
                }

                // now process the data and show it to the user
                var app = new Application(patients, drugs);

                // Create the default rule set
                var engine = new RulesEngine();
                engine.addTreatmentRule(new AspirinRule());
                engine.addTreatmentRule(new AntibioticRule());
                engine.addTreatmentRule(new InsulinRule());
                engine.addTreatmentRule(new MissingInsulinRule());
                engine.addTreatmentRule(new ParacetamolRule());

                app.processPatientTreatments(engine);


                System.out.println(app.generateResultData());
            }
        } catch (Exception ex) {
            System.err.printf("Something went wrong: %s\n", ex.getMessage());
        }
    }


}
