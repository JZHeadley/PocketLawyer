package com.jzheadley.pocketlawyer.data.model;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.util.List;

/**
 * Created by pjhud on 2/11/2017.
 */

public class Report {

    public String interactionID;

    //public Float locationEast;
    //public Float locationNorth;
    public String location;

    public List<String> tags;

    public SpeechResults speechResults;

    public boolean userIsFemale;

    public String userEthnicity;
}
