package com.jzheadley.pocketlawyer.data.model;

import android.location.Location;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.util.List;

@DynamoDBTable(tableName = "PocketLawyerReports")
public class Report {
    private String interactionID;
    private int resultIndex;

    private String location;
    private List<String> tags;
    private SpeechResults speechResults;
    private boolean userIsFemale;
    private String userEthnicity;

    private Location coordinates;


    @DynamoDBIndexHashKey(attributeName = "interactionID")
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

    public int getResultIndex() {
        return resultIndex;
    }

    public void setResultIndex(int resultIndex) {
        this.resultIndex = resultIndex;
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

    public Location getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Location coordinates) {
        this.coordinates = coordinates;
    }
}
