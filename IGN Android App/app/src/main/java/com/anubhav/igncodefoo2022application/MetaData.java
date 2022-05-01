package com.anubhav.igncodefoo2022application;

import java.util.ArrayList;

public class MetaData {

    private String headline, description, publishDate, slug, state, objectName;
    private ArrayList<String> networks;

    public MetaData(String headline, String description, String publishDate, String slug, String state, String objectName, ArrayList<String> networks) {
        this.headline = headline;
        this.description = description;
        this.publishDate = publishDate;
        this.slug = slug;
        this.state = state;
        this.objectName = objectName;
        this.networks = networks;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getSlug() {
        return slug;
    }

    public String getState() {
        return state;
    }

    public String getObjectName() {
        return objectName;
    }

    public ArrayList<String> getNetworks() {
        return networks;
    }
}