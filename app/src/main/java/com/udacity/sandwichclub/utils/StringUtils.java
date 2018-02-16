package com.udacity.sandwichclub.utils;

import java.util.List;

/**
 * Created by ilias on 16.02.2018.
 */

public class StringUtils {

    public static String getListAsString(List<String> list, String separator) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder csvBuilder = new StringBuilder();
        for (String item : list) {
            csvBuilder.append(item);
            csvBuilder.append(separator);
        }
        String csv = csvBuilder.toString();
        return csv.substring(0, csv.length() - separator.length());
    }
}