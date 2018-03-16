package com.haerul.crudretrofitpost;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haerul on 15/03/18.
 */

public class Contacts {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("value")
    private String value;
    @SerializedName("message")
    private String massage;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getValue() {
        return value;
    }

    public String getMassage() {
        return massage;
    }
}
