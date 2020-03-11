package esi.siw.child_app.culture_game;

import java.io.Serializable;

/**
 * Created by dell on 14/08/2018.
 */

public class ModelQS implements Serializable {

    private String question;
    private String response;
    private String pr1;
    private String pr2;
    private String pr3;
    private String pr4;

    public ModelQS(String question, String response, String pr1, String pr2, String pr3, String pr4) {
        this.question = question;
        this.response = response;
        this.pr1 = pr1;
        this.pr2 = pr2;
        this.pr3 = pr3;
        this.pr4 = pr4;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getPr1() {
        return pr1;
    }

    public void setPr1(String pr1) {
        this.pr1 = pr1;
    }

    public String getPr2() {
        return pr2;
    }

    public void setPr2(String pr2) {
        this.pr2 = pr2;
    }

    public String getPr3() {
        return pr3;
    }

    public void setPr3(String pr3) {
        this.pr3 = pr3;
    }

    public String getPr4() {
        return pr4;
    }

    public void setPr4(String pr4) {
        this.pr4 = pr4;
    }
}
