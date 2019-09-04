package com.cxk.po;

import java.util.Date;

public class TComp {
    private Integer id;

    private String compName;

    private String organizer;

    private String level;

    private Date signUpStart;

    private Date signUpEnd;

    private Date compStart;

    private Date compEnd;

    private String eduLimit;

    private String introducation;

    private Integer maxPeople;

    private String compAttribute;

    private String compPic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer == null ? null : organizer.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Date getSignUpStart() {
        return signUpStart;
    }

    public void setSignUpStart(Date signUpStart) {
        this.signUpStart = signUpStart;
    }

    public Date getSignUpEnd() {
        return signUpEnd;
    }

    public void setSignUpEnd(Date signUpEnd) {
        this.signUpEnd = signUpEnd;
    }

    public Date getCompStart() {
        return compStart;
    }

    public void setCompStart(Date compStart) {
        this.compStart = compStart;
    }

    public Date getCompEnd() {
        return compEnd;
    }

    public void setCompEnd(Date compEnd) {
        this.compEnd = compEnd;
    }

    public String getEduLimit() {
        return eduLimit;
    }

    public void setEduLimit(String eduLimit) {
        this.eduLimit = eduLimit == null ? null : eduLimit.trim();
    }

    public String getIntroducation() {
        return introducation;
    }

    public void setIntroducation(String introducation) {
        this.introducation = introducation == null ? null : introducation.trim();
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getCompAttribute() {
        return compAttribute;
    }

    public void setCompAttribute(String compAttribute) {
        this.compAttribute = compAttribute == null ? null : compAttribute.trim();
    }

    public String getCompPic() {
        return compPic;
    }

    public void setCompPic(String compPic) {
        this.compPic = compPic == null ? null : compPic.trim();
    }
}