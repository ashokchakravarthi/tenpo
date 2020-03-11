package com.tenpo.sum.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "operation", schema="db_schema_1")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "value1", updatable = false, nullable = false)
    private int value1;

    @Column(name = "value2", updatable = false, nullable = false)
    private int value2;

    @Column(name = "answer", updatable = false, nullable = false)
    private int answer;

    @Column(name = "user_id", updatable = false, nullable = false)
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
