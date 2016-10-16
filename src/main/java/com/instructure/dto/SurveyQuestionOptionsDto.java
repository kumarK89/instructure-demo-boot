package com.instructure.dto;

public class SurveyQuestionOptionsDto {

    private Integer srvyQtnOptId;
    private String optText;
    private boolean isOptionSelected;

    public Integer getSrvyQtnOptId() {
        return srvyQtnOptId;
    }

    public void setSrvyQtnOptId(Integer srvyQtnOptId) {
        this.srvyQtnOptId = srvyQtnOptId;
    }

    public String getOptText() {
        return optText;
    }

    public void setOptText(String optText) {
        this.optText = optText;
    }

    public boolean isOptionSelected() {
        return isOptionSelected;
    }

    public void setOptionSelected(boolean optionSelected) {
        isOptionSelected = optionSelected;
    }
}
