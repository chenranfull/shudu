package com.homework.shudu;

import java.util.Objects;

public class NowUser {
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NowUser(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NowUser{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NowUser nowUser = (NowUser) o;
        return Objects.equals(name, nowUser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
