package bs.gsau.ssm.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BSellExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BSellExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMedidIsNull() {
            addCriterion("MEDID is null");
            return (Criteria) this;
        }

        public Criteria andMedidIsNotNull() {
            addCriterion("MEDID is not null");
            return (Criteria) this;
        }

        public Criteria andMedidEqualTo(Integer value) {
            addCriterion("MEDID =", value, "medid");
            return (Criteria) this;
        }

        public Criteria andMedidNotEqualTo(Integer value) {
            addCriterion("MEDID <>", value, "medid");
            return (Criteria) this;
        }

        public Criteria andMedidGreaterThan(Integer value) {
            addCriterion("MEDID >", value, "medid");
            return (Criteria) this;
        }

        public Criteria andMedidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MEDID >=", value, "medid");
            return (Criteria) this;
        }

        public Criteria andMedidLessThan(Integer value) {
            addCriterion("MEDID <", value, "medid");
            return (Criteria) this;
        }

        public Criteria andMedidLessThanOrEqualTo(Integer value) {
            addCriterion("MEDID <=", value, "medid");
            return (Criteria) this;
        }

        public Criteria andMedidIn(List<Integer> values) {
            addCriterion("MEDID in", values, "medid");
            return (Criteria) this;
        }

        public Criteria andMedidNotIn(List<Integer> values) {
            addCriterion("MEDID not in", values, "medid");
            return (Criteria) this;
        }

        public Criteria andMedidBetween(Integer value1, Integer value2) {
            addCriterion("MEDID between", value1, value2, "medid");
            return (Criteria) this;
        }

        public Criteria andMedidNotBetween(Integer value1, Integer value2) {
            addCriterion("MEDID not between", value1, value2, "medid");
            return (Criteria) this;
        }

        public Criteria andSellcountIsNull() {
            addCriterion("SELLCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andSellcountIsNotNull() {
            addCriterion("SELLCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSellcountEqualTo(Integer value) {
            addCriterion("SELLCOUNT =", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountNotEqualTo(Integer value) {
            addCriterion("SELLCOUNT <>", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountGreaterThan(Integer value) {
            addCriterion("SELLCOUNT >", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("SELLCOUNT >=", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountLessThan(Integer value) {
            addCriterion("SELLCOUNT <", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountLessThanOrEqualTo(Integer value) {
            addCriterion("SELLCOUNT <=", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountIn(List<Integer> values) {
            addCriterion("SELLCOUNT in", values, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountNotIn(List<Integer> values) {
            addCriterion("SELLCOUNT not in", values, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountBetween(Integer value1, Integer value2) {
            addCriterion("SELLCOUNT between", value1, value2, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountNotBetween(Integer value1, Integer value2) {
            addCriterion("SELLCOUNT not between", value1, value2, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellpriceIsNull() {
            addCriterion("SELLPRICE is null");
            return (Criteria) this;
        }

        public Criteria andSellpriceIsNotNull() {
            addCriterion("SELLPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSellpriceEqualTo(BigDecimal value) {
            addCriterion("SELLPRICE =", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceNotEqualTo(BigDecimal value) {
            addCriterion("SELLPRICE <>", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceGreaterThan(BigDecimal value) {
            addCriterion("SELLPRICE >", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SELLPRICE >=", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceLessThan(BigDecimal value) {
            addCriterion("SELLPRICE <", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SELLPRICE <=", value, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceIn(List<BigDecimal> values) {
            addCriterion("SELLPRICE in", values, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceNotIn(List<BigDecimal> values) {
            addCriterion("SELLPRICE not in", values, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELLPRICE between", value1, value2, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELLPRICE not between", value1, value2, "sellprice");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyIsNull() {
            addCriterion("SELLALLMONEY is null");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyIsNotNull() {
            addCriterion("SELLALLMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyEqualTo(BigDecimal value) {
            addCriterion("SELLALLMONEY =", value, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyNotEqualTo(BigDecimal value) {
            addCriterion("SELLALLMONEY <>", value, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyGreaterThan(BigDecimal value) {
            addCriterion("SELLALLMONEY >", value, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SELLALLMONEY >=", value, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyLessThan(BigDecimal value) {
            addCriterion("SELLALLMONEY <", value, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SELLALLMONEY <=", value, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyIn(List<BigDecimal> values) {
            addCriterion("SELLALLMONEY in", values, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyNotIn(List<BigDecimal> values) {
            addCriterion("SELLALLMONEY not in", values, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELLALLMONEY between", value1, value2, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSellallmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELLALLMONEY not between", value1, value2, "sellallmoney");
            return (Criteria) this;
        }

        public Criteria andSelltimeIsNull() {
            addCriterion("SELLTIME is null");
            return (Criteria) this;
        }

        public Criteria andSelltimeIsNotNull() {
            addCriterion("SELLTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSelltimeEqualTo(Date value) {
            addCriterionForJDBCDate("SELLTIME =", value, "selltime");
            return (Criteria) this;
        }

        public Criteria andSelltimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("SELLTIME <>", value, "selltime");
            return (Criteria) this;
        }

        public Criteria andSelltimeGreaterThan(Date value) {
            addCriterionForJDBCDate("SELLTIME >", value, "selltime");
            return (Criteria) this;
        }

        public Criteria andSelltimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SELLTIME >=", value, "selltime");
            return (Criteria) this;
        }

        public Criteria andSelltimeLessThan(Date value) {
            addCriterionForJDBCDate("SELLTIME <", value, "selltime");
            return (Criteria) this;
        }

        public Criteria andSelltimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SELLTIME <=", value, "selltime");
            return (Criteria) this;
        }

        public Criteria andSelltimeIn(List<Date> values) {
            addCriterionForJDBCDate("SELLTIME in", values, "selltime");
            return (Criteria) this;
        }

        public Criteria andSelltimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("SELLTIME not in", values, "selltime");
            return (Criteria) this;
        }

        public Criteria andSelltimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SELLTIME between", value1, value2, "selltime");
            return (Criteria) this;
        }

        public Criteria andSelltimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SELLTIME not between", value1, value2, "selltime");
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