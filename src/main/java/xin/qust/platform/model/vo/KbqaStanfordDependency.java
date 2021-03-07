package xin.qust.platform.model.vo;

public class KbqaStanfordDependency {

    private String dep;
    private String longName;
    private String shortName;
    private String specific;
    private int governor;
    private String governorGloss;
    private int dependent;
    private String dependentGloss;

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public int getGovernor() {
        return governor;
    }

    public void setGovernor(int governor) {
        this.governor = governor;
    }

    public String getGovernorGloss() {
        return governorGloss;
    }

    public void setGovernorGloss(String governorGloss) {
        this.governorGloss = governorGloss;
    }

    public int getDependent() {
        return dependent;
    }

    public void setDependent(int dependent) {
        this.dependent = dependent;
    }

    public String getDependentGloss() {
        return dependentGloss;
    }

    public void setDependentGloss(String dependentGloss) {
        this.dependentGloss = dependentGloss;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }
}
