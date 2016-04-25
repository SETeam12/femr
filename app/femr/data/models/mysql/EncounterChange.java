/*
     fEMR - fast Electronic Medical Records
     Copyright (C) 2014  Team fEMR

     fEMR is free software: you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.

     fEMR is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.

     You should have received a copy of the GNU General Public License
     along with fEMR.  If not, see <http://www.gnu.org/licenses/>. If
     you have any questions, contact <info@teamfemr.org>.
*/
package femr.data.models.mysql;

import femr.data.models.core.IEncounterChange;
import femr.data.models.core.IPatientEncounter;

import javax.persistence.*;
import org.joda.time.DateTime;
import java.util.*;


@Entity
@Table(name = "encounter_change_history")
public class EncounterChange implements IEncounterChange {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_encounters_id")  //TODO is this syntax correct?
 //   @Column(name = "encounter_id", nullable = false)
    private PatientEncounter patientEncounter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_encounters.user_id")
    @Column(name = "user_id", nullable = false)
    private int userID;

    @Column(name = "date_of_change", nullable = false)
    private DateTime dateOfChange;

    private String changes;
    @Column(name = "changes")



    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public Integer getUserID() {
        return userID;
    }

    @Override
    public void setUserID( Integer userID   ) {
        this.userID = userID;
    }

    @Override
    public IPatientEncounter getPatientEncounter() {
        return patientEncounter;
    }

    @Override
    public void setPatientEncounter(IPatientEncounter patientEncounter) {
        this.patientEncounter = (PatientEncounter) patientEncounter;
    }

    @Override
    public String getChanges()  {   return changes; }

    @Override
    public void setChanges(String changes) {   this.changes = changes; }

}



 //TODO remove comment block