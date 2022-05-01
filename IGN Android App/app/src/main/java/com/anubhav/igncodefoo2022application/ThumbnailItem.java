package com.anubhav.igncodefoo2022application;

public class ThumbnailItem{

    private String url, size;
    private int width, height;
    public ThumbnailItem(String url, String size, int width, int height){
        this.url = url;
        this.size = size;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
