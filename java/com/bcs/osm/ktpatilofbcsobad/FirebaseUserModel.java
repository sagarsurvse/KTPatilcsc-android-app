package com.bcs.osm.ktpatilofbcsobad;

/**
 * Created by Mark on 21/11/2018.
 */

public class FirebaseUserModel {

    String deviceId = "";
    String deviceToken = "";
    String username = "";

    public FirebaseUserModel() {
      /*Blank default constructor essential for Firebase*/
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}