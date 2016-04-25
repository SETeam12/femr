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

package femr.common.models;

import org.joda.time.DateTime;


public class EncounterChangeItem {

    private int id;             //id for the ChangeItem
    private DateTime dateOfEdit;  //Date that the patient encounter was edited (the creation of a ChangeItem)
    private Integer userID;      //ID of the fEMR user that made changes to the patient encounter
    private Integer encounterID; //ID of the encounter that was changed
    private String changes;     //The changes that were made to the encounter

    public EncounterChangeItem(){    }

    public int getID()  {
        return id;
    }
    public DateTime getDateOfEdit()   {
        return dateOfEdit;
    }
    public Integer getUserID() {
        return userID;
    }
    public Integer getEncounterID() {
        return encounterID;
    }
    public String getChanges(){
        return changes;
    }
    public void setID(int newID)    {
        id = newID;
    }
    public void setDateOfEdit(DateTime dateOfEdit) {
        this.dateOfEdit = dateOfEdit;
    }
    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    public void setEncounterID(Integer encounterID) {
        this.encounterID = encounterID;
    }
    public void setChanges(String changes) {
        this.changes = changes;
    }
}
