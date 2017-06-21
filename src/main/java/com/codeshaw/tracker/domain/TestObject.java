package com.codeshaw.tracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestObject {

    private String type;

    private TestObjectValue value;

    public TestObject() {
    }

    public TestObject(String type, TestObjectValue value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TestObjectValue getValue() {
        return value;
    }

    public void setValue(TestObjectValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("value", value)
                .toString();
    }
}
