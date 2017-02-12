package com.jzheadley.pocketlawyer.data.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.util.List;

@DynamoDBTable(tableName = "PocketLawyerReports")
public class Report {
    private String interactionID;
    //public Float locationEast;
    //public Float locationNorth;
    private String location;
    private List<String> tags;
    private SpeechResults speechResults;
    private boolean userIsFemale;
    private String userEthnicity;

    @DynamoDBHashKey(attributeName = "interactionID")
    public String getInteractionID() {
        return interactionID;
    }

    public void setInteractionID(String interactionID) {
        this.interactionID = interactionID;
    }

    @DynamoDBAttribute(attributeName = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @DynamoDBAttribute(attributeName = "tags")
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @DynamoDBAttribute(attributeName = "speechResults")
    public SpeechResults getSpeechResults() {
        return speechResults;
    }

    public void setSpeechResults(SpeechResults speechResults) {
        this.speechResults = speechResults;
    }

    @DynamoDBAttribute(attributeName = "isUserFemale")
    public boolean isUserIsFemale() {
        return userIsFemale;
    }

    public void setUserIsFemale(boolean userIsFemale) {
        this.userIsFemale = userIsFemale;
    }

    @DynamoDBAttribute(attributeName = "ethnicity")
    public String getUserEthnicity() {
        return userEthnicity;
    }

    public void setUserEthnicity(String userEthnicity) {
        this.userEthnicity = userEthnicity;
    }
}
