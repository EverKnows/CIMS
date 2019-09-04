package com.cxk.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTopicExample() {
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

        public Criteria andBoardIdIsNull() {
            addCriterion("board_id is null");
            return (Criteria) this;
        }

        public Criteria andBoardIdIsNotNull() {
            addCriterion("board_id is not null");
            return (Criteria) this;
        }

        public Criteria andBoardIdEqualTo(Integer value) {
            addCriterion("board_id =", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdNotEqualTo(Integer value) {
            addCriterion("board_id <>", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdGreaterThan(Integer value) {
            addCriterion("board_id >", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("board_id >=", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdLessThan(Integer value) {
            addCriterion("board_id <", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdLessThanOrEqualTo(Integer value) {
            addCriterion("board_id <=", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdIn(List<Integer> values) {
            addCriterion("board_id in", values, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdNotIn(List<Integer> values) {
            addCriterion("board_id not in", values, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdBetween(Integer value1, Integer value2) {
            addCriterion("board_id between", value1, value2, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("board_id not between", value1, value2, "boardId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTopicTitleIsNull() {
            addCriterion("topic_title is null");
            return (Criteria) this;
        }

        public Criteria andTopicTitleIsNotNull() {
            addCriterion("topic_title is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTitleEqualTo(String value) {
            addCriterion("topic_title =", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleNotEqualTo(String value) {
            addCriterion("topic_title <>", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleGreaterThan(String value) {
            addCriterion("topic_title >", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleGreaterThanOrEqualTo(String value) {
            addCriterion("topic_title >=", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleLessThan(String value) {
            addCriterion("topic_title <", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleLessThanOrEqualTo(String value) {
            addCriterion("topic_title <=", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleLike(String value) {
            addCriterion("topic_title like", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleNotLike(String value) {
            addCriterion("topic_title not like", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleIn(List<String> values) {
            addCriterion("topic_title in", values, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleNotIn(List<String> values) {
            addCriterion("topic_title not in", values, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleBetween(String value1, String value2) {
            addCriterion("topic_title between", value1, value2, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleNotBetween(String value1, String value2) {
            addCriterion("topic_title not between", value1, value2, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTextIsNull() {
            addCriterion("topic_text is null");
            return (Criteria) this;
        }

        public Criteria andTopicTextIsNotNull() {
            addCriterion("topic_text is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTextEqualTo(String value) {
            addCriterion("topic_text =", value, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextNotEqualTo(String value) {
            addCriterion("topic_text <>", value, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextGreaterThan(String value) {
            addCriterion("topic_text >", value, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextGreaterThanOrEqualTo(String value) {
            addCriterion("topic_text >=", value, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextLessThan(String value) {
            addCriterion("topic_text <", value, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextLessThanOrEqualTo(String value) {
            addCriterion("topic_text <=", value, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextLike(String value) {
            addCriterion("topic_text like", value, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextNotLike(String value) {
            addCriterion("topic_text not like", value, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextIn(List<String> values) {
            addCriterion("topic_text in", values, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextNotIn(List<String> values) {
            addCriterion("topic_text not in", values, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextBetween(String value1, String value2) {
            addCriterion("topic_text between", value1, value2, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicTextNotBetween(String value1, String value2) {
            addCriterion("topic_text not between", value1, value2, "topicText");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesIsNull() {
            addCriterion("topic_replies is null");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesIsNotNull() {
            addCriterion("topic_replies is not null");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesEqualTo(Integer value) {
            addCriterion("topic_replies =", value, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesNotEqualTo(Integer value) {
            addCriterion("topic_replies <>", value, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesGreaterThan(Integer value) {
            addCriterion("topic_replies >", value, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_replies >=", value, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesLessThan(Integer value) {
            addCriterion("topic_replies <", value, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesLessThanOrEqualTo(Integer value) {
            addCriterion("topic_replies <=", value, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesIn(List<Integer> values) {
            addCriterion("topic_replies in", values, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesNotIn(List<Integer> values) {
            addCriterion("topic_replies not in", values, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesBetween(Integer value1, Integer value2) {
            addCriterion("topic_replies between", value1, value2, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andTopicRepliesNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_replies not between", value1, value2, "topicReplies");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastPostIsNull() {
            addCriterion("last_post is null");
            return (Criteria) this;
        }

        public Criteria andLastPostIsNotNull() {
            addCriterion("last_post is not null");
            return (Criteria) this;
        }

        public Criteria andLastPostEqualTo(Date value) {
            addCriterion("last_post =", value, "lastPost");
            return (Criteria) this;
        }

        public Criteria andLastPostNotEqualTo(Date value) {
            addCriterion("last_post <>", value, "lastPost");
            return (Criteria) this;
        }

        public Criteria andLastPostGreaterThan(Date value) {
            addCriterion("last_post >", value, "lastPost");
            return (Criteria) this;
        }

        public Criteria andLastPostGreaterThanOrEqualTo(Date value) {
            addCriterion("last_post >=", value, "lastPost");
            return (Criteria) this;
        }

        public Criteria andLastPostLessThan(Date value) {
            addCriterion("last_post <", value, "lastPost");
            return (Criteria) this;
        }

        public Criteria andLastPostLessThanOrEqualTo(Date value) {
            addCriterion("last_post <=", value, "lastPost");
            return (Criteria) this;
        }

        public Criteria andLastPostIn(List<Date> values) {
            addCriterion("last_post in", values, "lastPost");
            return (Criteria) this;
        }

        public Criteria andLastPostNotIn(List<Date> values) {
            addCriterion("last_post not in", values, "lastPost");
            return (Criteria) this;
        }

        public Criteria andLastPostBetween(Date value1, Date value2) {
            addCriterion("last_post between", value1, value2, "lastPost");
            return (Criteria) this;
        }

        public Criteria andLastPostNotBetween(Date value1, Date value2) {
            addCriterion("last_post not between", value1, value2, "lastPost");
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