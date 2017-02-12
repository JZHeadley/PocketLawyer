package com.jzheadley.pocketlawyer.data.model;

import android.location.Location;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIgnore;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.JsonMarshaller;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeakerLabel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;

import java.util.List;
import java.util.Set;

@DynamoDBTable(tableName = "PocketLawyerReports")
public class Report {
    private String interactionID;
    private int resultIndex;

    private String location;
    private Set<String> _tags;
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

    @DynamoDBAttribute
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @DynamoDBIndexHashKey
    public int getResultIndex() {
        return resultIndex;
    }

    public void setResultIndex(int resultIndex) {
        this.resultIndex = resultIndex;
    }

    @DynamoDBAttribute
    @DynamoDBIgnore
    public Set<String> getTags() {
        return _tags;
    }

    public void setTags(Set<String> tags) {
        this._tags = tags;
    }

    // @DynamoDBAttribute
    // @DynamoDBMarshalling(marshallerClass = SpeechResultsMarshaller.class)
    @DynamoDBIgnore
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

    // public Location getCoordinates() {
    //     return coordinates;
    // }
    //
    // public void setCoordinates(Location coordinates) {
    //     this.coordinates = coordinates;
    // }
    @DynamoDBAttribute
    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public class MySpeechResults extends SpeechResults {

        public MySpeechResults() {
        }

        public MySpeechResults(SpeechResults speechResults) {
            setResults(speechResults.getResults());
        }

        @Override
        public void setResultIndex(int resultIndex) {
            super.setResultIndex(resultIndex);
        }

        @Override
        public void setResults(List<Transcript> results) {
            super.setResults(results);
        }

        @Override
        public void setSpeakerLabels(List<SpeakerLabel> speakerLabels) {
            super.setSpeakerLabels(speakerLabels);
        }
    }

    public class SpeechResultsMarshaller extends JsonMarshaller<MySpeechResults> {
    }
}
