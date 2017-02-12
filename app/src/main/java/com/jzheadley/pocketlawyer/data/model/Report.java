package com.jzheadley.pocketlawyer.data.model;

import android.location.Location;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.util.Set;

@DynamoDBTable(tableName = "PocketLawyerReports")
public class Report {
    private String interactionID;
    private int resultIndex;

    private String location;
    private Set<String> tags;
    private SpeechResults speechResults;

    private String transcript;
    private boolean userIsFemale;
    private String userEthnicity;

    private Location coordinates;

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
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
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

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }
}
