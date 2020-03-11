package esi.siw.child_app.comparison_game;

/**
 * Created by dell on 15/08/2018.
 */

public class ModelCmp {

    private int first_number;
    private int second_number;
    private String response;

    public ModelCmp(int first_number, int second_number, String response) {
        this.first_number = first_number;
        this.second_number = second_number;
        this.response = response;
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

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
