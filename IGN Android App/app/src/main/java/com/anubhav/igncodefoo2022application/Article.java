package com.anubhav.igncodefoo2022application;

import java.util.ArrayList;

public class Article {

    private MetaData metaData;
    private ArrayList<ThumbnailItem> thumbnails;
    private ArrayList<String> tags;
    private ArrayList<Author> authors;

    private String contentId, contentType;

    public Article(String contentId, String contentType, ArrayList<ThumbnailItem> thumbnails, MetaData metaData, ArrayList<String> tags, ArrayList<Author> authors) {
        this.contentId = contentId;
        this.contentType = contentType;
        this.thumbnails = thumbnails;
        this.metaData = metaData;
        this.tags = tags;
        this.authors = authors;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public ArrayList<ThumbnailItem> getThumbnails() {
        return thumbnails;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public String getContentId() {
        return contentId;
    }

    public String getContentType() {
        return contentType;
    }
}