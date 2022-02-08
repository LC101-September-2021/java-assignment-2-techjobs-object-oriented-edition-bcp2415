package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String fail = "Data not available";
        String nameOut;
        String employerOut;
        String locationOut;
        String positionTypeOut;
        String coreCompetencyOut;

        if (Objects.isNull(getName()) && Objects.isNull(getEmployer()) && Objects.isNull(getLocation()) && Objects.isNull(getPositionType()) && Objects.isNull(getCoreCompetency())) {
            return "\nOOPS! This job does not seem to exist.\n";
        } else if (getName().isEmpty()) {
            nameOut = fail;
        } else nameOut = getName();

        if (getEmployer().getValue() == "" || employer == null) {
            employerOut = fail;
        } else employerOut = getEmployer().getValue();

        if (getLocation().getValue() == "" || location == null) {
            locationOut = fail;
        } else locationOut = getLocation().getValue();

        if (getPositionType().getValue() == "" || positionType == null) {
            positionTypeOut = fail;
        } else positionTypeOut = getPositionType().getValue();

        if (getCoreCompetency().getValue() == ""  || coreCompetency == null) {
            coreCompetencyOut = fail;
        } else coreCompetencyOut = getCoreCompetency().getValue();

        return "\n" +
                "ID: " + getId() + "\n" +
                "Name: " + nameOut + "\n" +
                "Employer: " + employerOut + "\n" +
                "Location: " + locationOut + "\n" +
                "Position Type: " + positionTypeOut + "\n" +
                "Core Competency: " + coreCompetencyOut +
                "\n";
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
