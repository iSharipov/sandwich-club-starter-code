package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        Sandwich sandwich = null;
        try {
            sandwich = new Sandwich();
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject("name");
            sandwich.setMainName(nameObject.optString("mainName"));
            JSONArray alsoKnownAs = nameObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsSandwich = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alsoKnownAsSandwich.add(alsoKnownAs.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAsSandwich);
            sandwich.setPlaceOfOrigin(jsonObject.optString("placeOfOrigin"));
            sandwich.setDescription(jsonObject.optString("description"));
            sandwich.setImage(jsonObject.optString("image"));
            JSONArray ingredients = jsonObject.getJSONArray("ingredients");
            List<String> ingredientsSandwich = new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsSandwich.add(ingredients.getString(i));
            }
            sandwich.setIngredients(ingredientsSandwich);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}