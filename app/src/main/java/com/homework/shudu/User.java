package com.homework.shudu;

import java.util.Arrays;
import java.util.Objects;

public class User {
    private String  name;
    private String psw;
    public String puzzle;

    public User(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    public User(String name, String psw , String puzzle) {
        this.name = name;
        this.psw = psw;
        this.puzzle = puzzle;

    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPsw() {
        return psw;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }
    public String getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                ", puzzle=" + puzzle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(psw, user.psw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, psw);
    }
}
