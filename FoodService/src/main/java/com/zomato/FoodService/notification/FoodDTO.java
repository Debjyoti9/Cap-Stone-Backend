package com.zomato.FoodService.notification;

import org.json.simple.JSONObject;

public class FoodDTO {
    private JSONObject jsonObject;

    public FoodDTO() {
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
