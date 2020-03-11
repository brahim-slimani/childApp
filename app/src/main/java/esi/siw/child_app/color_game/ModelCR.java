package esi.siw.child_app.color_game;

import java.io.Serializable;

/**
 * Created by dell on 20/08/2018.
 */

public class ModelCR implements Serializable {
    private String context;
    private String text;
    private String color;
    private String response;
    private String pr1;
    private String pr2;

    public ModelCR(String context, String text, String color, String response, String pr1, String pr2) {
        this.context = context;
        this.text = text;
        this.color = color;
        this.response = response;
        this.pr1 = pr1;
        this.pr2 = pr2;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
}
