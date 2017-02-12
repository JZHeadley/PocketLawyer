package com.jzheadley.pocketlawyer.data.model;

public class Intervention {
    private String triggerName;
    private String promptText;

    private boolean recordRawResponse;
    private String responseTag;

    private boolean yesNoQuestion;
    private String yesTrigger;
    private String noTrigger;

    public Intervention(String triggerName, String promptText, boolean recordRawResponse, String responseTag, boolean yesNoQuestion, String yesTrigger, String noTrigger) {
        this.triggerName = triggerName;
        this.promptText = promptText;
        this.recordRawResponse = recordRawResponse;
        this.responseTag = responseTag;
        this.yesNoQuestion = yesNoQuestion;
        this.yesTrigger = yesTrigger;
        this.noTrigger = noTrigger;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public boolean isRecordRawResponse() {
        return recordRawResponse;
    }

    public void setRecordRawResponse(boolean recordRawResponse) {
        this.recordRawResponse = recordRawResponse;
    }

    public String getResponseTag() {
        return responseTag;
    }

    public void setResponseTag(String responseTag) {
        this.responseTag = responseTag;
    }

    public boolean isYesNoQuestion() {
        return yesNoQuestion;
    }

    public void setYesNoQuestion(boolean yesNoQuestion) {
        this.yesNoQuestion = yesNoQuestion;
    }

    public String getYesTrigger() {
        return yesTrigger;
    }

    public void setYesTrigger(String yesTrigger) {
        this.yesTrigger = yesTrigger;
    }

    public String getNoTrigger() {
        return noTrigger;
    }

    public void setNoTrigger(String noTrigger) {
        this.noTrigger = noTrigger;
    }
}
