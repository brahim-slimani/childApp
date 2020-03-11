package esi.siw.child_app.addition_game;

import java.io.Serializable;

/**
 * Created by dell on 12/08/2018.
 */

public class Model implements Serializable {

    private int first_number;
    private int second_number;
    private String operator;
    private int pr1;
    private int pr2;
    private int pr3;
    private int pr4;

    public Model(int first_number, int second_number, String operator, int pr1, int pr2, int pr3, int pr4) {
        this.first_number = first_number;
        this.second_number = second_number;
        this.operator = operator;
        this.pr1 = pr1;
        this.pr2 = pr2;
        this.pr3 = pr3;
        this.pr4 = pr4;
    }

    public int getFirst_number() {
        return first_number;
    }

    public void setFirst_number(int first_number) {
        this.first_number = first_number;
    }

    public int getSecond_number() {
        return second_number;
    }

    public void setSecond_number(int second_number) {
        this.second_number = second_number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getPr1() {
        return pr1;
    }

    public void setPr1(int pr1) {
        this.pr1 = pr1;
    }

    public int getPr2() {
        return pr2;
    }

    public void setPr2(int pr2) {
        this.pr2 = pr2;
    }

    public int getPr3() {
        return pr3;
    }

    public void setPr3(int pr3) {
        this.pr3 = pr3;
    }

    public int getPr4() {
        return pr4;
    }

    public void setPr4(int pr4) {
        this.pr4 = pr4;
    }
}
