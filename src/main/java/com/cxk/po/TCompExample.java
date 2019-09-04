package com.cxk.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCompExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCompExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCompNameIsNull() {
            addCriterion("comp_name is null");
            return (Criteria) this;
        }

        public Criteria andCompNameIsNotNull() {
            addCriterion("comp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompNameEqualTo(String value) {
            addCriterion("comp_name =", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotEqualTo(String value) {
            addCriterion("comp_name <>", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThan(String value) {
            addCriterion("comp_name >", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThanOrEqualTo(String value) {
            addCriterion("comp_name >=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThan(String value) {
            addCriterion("comp_name <", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThanOrEqualTo(String value) {
            addCriterion("comp_name <=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLike(String value) {
            addCriterion("comp_name like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotLike(String value) {
            addCriterion("comp_name not like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameIn(List<String> values) {
            addCriterion("comp_name in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotIn(List<String> values) {
            addCriterion("comp_name not in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameBetween(String value1, String value2) {
            addCriterion("comp_name between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotBetween(String value1, String value2) {
            addCriterion("comp_name not between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNull() {
            addCriterion("organizer is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNotNull() {
            addCriterion("organizer is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerEqualTo(String value) {
            addCriterion("organizer =", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotEqualTo(String value) {
            addCriterion("organizer <>", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThan(String value) {
            addCriterion("organizer >", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThanOrEqualTo(String value) {
            addCriterion("organizer >=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThan(String value) {
            addCriterion("organizer <", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThanOrEqualTo(String value) {
            addCriterion("organizer <=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLike(String value) {
            addCriterion("organizer like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotLike(String value) {
            addCriterion("organizer not like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerIn(List<String> values) {
            addCriterion("organizer in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotIn(List<String> values) {
            addCriterion("organizer not in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerBetween(String value1, String value2) {
            addCriterion("organizer between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotBetween(String value1, String value2) {
            addCriterion("organizer not between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andSignUpStartIsNull() {
            addCriterion("sign_up_start is null");
            return (Criteria) this;
        }

        public Criteria andSignUpStartIsNotNull() {
            addCriterion("sign_up_start is not null");
            return (Criteria) this;
        }

        public Criteria andSignUpStartEqualTo(Date value) {
            addCriterion("sign_up_start =", value, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpStartNotEqualTo(Date value) {
            addCriterion("sign_up_start <>", value, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpStartGreaterThan(Date value) {
            addCriterion("sign_up_start >", value, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpStartGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_up_start >=", value, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpStartLessThan(Date value) {
            addCriterion("sign_up_start <", value, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpStartLessThanOrEqualTo(Date value) {
            addCriterion("sign_up_start <=", value, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpStartIn(List<Date> values) {
            addCriterion("sign_up_start in", values, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpStartNotIn(List<Date> values) {
            addCriterion("sign_up_start not in", values, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpStartBetween(Date value1, Date value2) {
            addCriterion("sign_up_start between", value1, value2, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpStartNotBetween(Date value1, Date value2) {
            addCriterion("sign_up_start not between", value1, value2, "signUpStart");
            return (Criteria) this;
        }

        public Criteria andSignUpEndIsNull() {
            addCriterion("sign_up_end is null");
            return (Criteria) this;
        }

        public Criteria andSignUpEndIsNotNull() {
            addCriterion("sign_up_end is not null");
            return (Criteria) this;
        }

        public Criteria andSignUpEndEqualTo(Date value) {
            addCriterion("sign_up_end =", value, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andSignUpEndNotEqualTo(Date value) {
            addCriterion("sign_up_end <>", value, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andSignUpEndGreaterThan(Date value) {
            addCriterion("sign_up_end >", value, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andSignUpEndGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_up_end >=", value, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andSignUpEndLessThan(Date value) {
            addCriterion("sign_up_end <", value, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andSignUpEndLessThanOrEqualTo(Date value) {
            addCriterion("sign_up_end <=", value, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andSignUpEndIn(List<Date> values) {
            addCriterion("sign_up_end in", values, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andSignUpEndNotIn(List<Date> values) {
            addCriterion("sign_up_end not in", values, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andSignUpEndBetween(Date value1, Date value2) {
            addCriterion("sign_up_end between", value1, value2, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andSignUpEndNotBetween(Date value1, Date value2) {
            addCriterion("sign_up_end not between", value1, value2, "signUpEnd");
            return (Criteria) this;
        }

        public Criteria andCompStartIsNull() {
            addCriterion("comp_start is null");
            return (Criteria) this;
        }

        public Criteria andCompStartIsNotNull() {
            addCriterion("comp_start is not null");
            return (Criteria) this;
        }

        public Criteria andCompStartEqualTo(Date value) {
            addCriterion("comp_start =", value, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompStartNotEqualTo(Date value) {
            addCriterion("comp_start <>", value, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompStartGreaterThan(Date value) {
            addCriterion("comp_start >", value, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompStartGreaterThanOrEqualTo(Date value) {
            addCriterion("comp_start >=", value, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompStartLessThan(Date value) {
            addCriterion("comp_start <", value, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompStartLessThanOrEqualTo(Date value) {
            addCriterion("comp_start <=", value, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompStartIn(List<Date> values) {
            addCriterion("comp_start in", values, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompStartNotIn(List<Date> values) {
            addCriterion("comp_start not in", values, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompStartBetween(Date value1, Date value2) {
            addCriterion("comp_start between", value1, value2, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompStartNotBetween(Date value1, Date value2) {
            addCriterion("comp_start not between", value1, value2, "compStart");
            return (Criteria) this;
        }

        public Criteria andCompEndIsNull() {
            addCriterion("comp_end is null");
            return (Criteria) this;
        }

        public Criteria andCompEndIsNotNull() {
            addCriterion("comp_end is not null");
            return (Criteria) this;
        }

        public Criteria andCompEndEqualTo(Date value) {
            addCriterion("comp_end =", value, "compEnd");
            return (Criteria) this;
        }

        public Criteria andCompEndNotEqualTo(Date value) {
            addCriterion("comp_end <>", value, "compEnd");
            return (Criteria) this;
        }

        public Criteria andCompEndGreaterThan(Date value) {
            addCriterion("comp_end >", value, "compEnd");
            return (Criteria) this;
        }

        public Criteria andCompEndGreaterThanOrEqualTo(Date value) {
            addCriterion("comp_end >=", value, "compEnd");
            return (Criteria) this;
        }

        public Criteria andCompEndLessThan(Date value) {
            addCriterion("comp_end <", value, "compEnd");
            return (Criteria) this;
        }

        public Criteria andCompEndLessThanOrEqualTo(Date value) {
            addCriterion("comp_end <=", value, "compEnd");
            return (Criteria) this;
        }

        public Criteria andCompEndIn(List<Date> values) {
            addCriterion("comp_end in", values, "compEnd");
            return (Criteria) this;
        }

        public Criteria andCompEndNotIn(List<Date> values) {
            addCriterion("comp_end not in", values, "compEnd");
            return (Criteria) this;
        }

        public Criteria andCompEndBetween(Date value1, Date value2) {
            addCriterion("comp_end between", value1, value2, "compEnd");
            return (Criteria) this;
        }

        public Criteria andCompEndNotBetween(Date value1, Date value2) {
            addCriterion("comp_end not between", value1, value2, "compEnd");
            return (Criteria) this;
        }

        public Criteria andEduLimitIsNull() {
            addCriterion("edu_limit is null");
            return (Criteria) this;
        }

        public Criteria andEduLimitIsNotNull() {
            addCriterion("edu_limit is not null");
            return (Criteria) this;
        }

        public Criteria andEduLimitEqualTo(String value) {
            addCriterion("edu_limit =", value, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitNotEqualTo(String value) {
            addCriterion("edu_limit <>", value, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitGreaterThan(String value) {
            addCriterion("edu_limit >", value, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitGreaterThanOrEqualTo(String value) {
            addCriterion("edu_limit >=", value, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitLessThan(String value) {
            addCriterion("edu_limit <", value, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitLessThanOrEqualTo(String value) {
            addCriterion("edu_limit <=", value, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitLike(String value) {
            addCriterion("edu_limit like", value, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitNotLike(String value) {
            addCriterion("edu_limit not like", value, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitIn(List<String> values) {
            addCriterion("edu_limit in", values, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitNotIn(List<String> values) {
            addCriterion("edu_limit not in", values, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitBetween(String value1, String value2) {
            addCriterion("edu_limit between", value1, value2, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andEduLimitNotBetween(String value1, String value2) {
            addCriterion("edu_limit not between", value1, value2, "eduLimit");
            return (Criteria) this;
        }

        public Criteria andIntroducationIsNull() {
            addCriterion("introducation is null");
            return (Criteria) this;
        }

        public Criteria andIntroducationIsNotNull() {
            addCriterion("introducation is not null");
            return (Criteria) this;
        }

        public Criteria andIntroducationEqualTo(String value) {
            addCriterion("introducation =", value, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationNotEqualTo(String value) {
            addCriterion("introducation <>", value, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationGreaterThan(String value) {
            addCriterion("introducation >", value, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationGreaterThanOrEqualTo(String value) {
            addCriterion("introducation >=", value, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationLessThan(String value) {
            addCriterion("introducation <", value, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationLessThanOrEqualTo(String value) {
            addCriterion("introducation <=", value, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationLike(String value) {
            addCriterion("introducation like", value, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationNotLike(String value) {
            addCriterion("introducation not like", value, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationIn(List<String> values) {
            addCriterion("introducation in", values, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationNotIn(List<String> values) {
            addCriterion("introducation not in", values, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationBetween(String value1, String value2) {
            addCriterion("introducation between", value1, value2, "introducation");
            return (Criteria) this;
        }

        public Criteria andIntroducationNotBetween(String value1, String value2) {
            addCriterion("introducation not between", value1, value2, "introducation");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleIsNull() {
            addCriterion("max_people is null");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleIsNotNull() {
            addCriterion("max_people is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleEqualTo(Integer value) {
            addCriterion("max_people =", value, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleNotEqualTo(Integer value) {
            addCriterion("max_people <>", value, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleGreaterThan(Integer value) {
            addCriterion("max_people >", value, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_people >=", value, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleLessThan(Integer value) {
            addCriterion("max_people <", value, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleLessThanOrEqualTo(Integer value) {
            addCriterion("max_people <=", value, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleIn(List<Integer> values) {
            addCriterion("max_people in", values, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleNotIn(List<Integer> values) {
            addCriterion("max_people not in", values, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleBetween(Integer value1, Integer value2) {
            addCriterion("max_people between", value1, value2, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andMaxPeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("max_people not between", value1, value2, "maxPeople");
            return (Criteria) this;
        }

        public Criteria andCompAttributeIsNull() {
            addCriterion("comp_attribute is null");
            return (Criteria) this;
        }

        public Criteria andCompAttributeIsNotNull() {
            addCriterion("comp_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andCompAttributeEqualTo(String value) {
            addCriterion("comp_attribute =", value, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeNotEqualTo(String value) {
            addCriterion("comp_attribute <>", value, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeGreaterThan(String value) {
            addCriterion("comp_attribute >", value, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("comp_attribute >=", value, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeLessThan(String value) {
            addCriterion("comp_attribute <", value, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeLessThanOrEqualTo(String value) {
            addCriterion("comp_attribute <=", value, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeLike(String value) {
            addCriterion("comp_attribute like", value, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeNotLike(String value) {
            addCriterion("comp_attribute not like", value, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeIn(List<String> values) {
            addCriterion("comp_attribute in", values, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeNotIn(List<String> values) {
            addCriterion("comp_attribute not in", values, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeBetween(String value1, String value2) {
            addCriterion("comp_attribute between", value1, value2, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompAttributeNotBetween(String value1, String value2) {
            addCriterion("comp_attribute not between", value1, value2, "compAttribute");
            return (Criteria) this;
        }

        public Criteria andCompPicIsNull() {
            addCriterion("comp_pic is null");
            return (Criteria) this;
        }

        public Criteria andCompPicIsNotNull() {
            addCriterion("comp_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCompPicEqualTo(String value) {
            addCriterion("comp_pic =", value, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicNotEqualTo(String value) {
            addCriterion("comp_pic <>", value, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicGreaterThan(String value) {
            addCriterion("comp_pic >", value, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicGreaterThanOrEqualTo(String value) {
            addCriterion("comp_pic >=", value, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicLessThan(String value) {
            addCriterion("comp_pic <", value, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicLessThanOrEqualTo(String value) {
            addCriterion("comp_pic <=", value, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicLike(String value) {
            addCriterion("comp_pic like", value, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicNotLike(String value) {
            addCriterion("comp_pic not like", value, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicIn(List<String> values) {
            addCriterion("comp_pic in", values, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicNotIn(List<String> values) {
            addCriterion("comp_pic not in", values, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicBetween(String value1, String value2) {
            addCriterion("comp_pic between", value1, value2, "compPic");
            return (Criteria) this;
        }

        public Criteria andCompPicNotBetween(String value1, String value2) {
            addCriterion("comp_pic not between", value1, value2, "compPic");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}