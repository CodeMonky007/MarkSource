package com.MarkSource.bean;

public class Source {
    private String source_id;
    private  String source_type;
    private  String source_des;
    private  String source_link;
    private String create_time;
    private String source_location;

    public String getSource_location() {
        return source_location;
    }

    public void setSource_location(String source_location) {
        this.source_location = source_location;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public String getSource_des() {
        return source_des;
    }

    public void setSource_des(String source_des) {
        this.source_des = source_des;
    }

    public String getSource_link() {
        return source_link;
    }

    public void setSource_link(String source_link) {
        this.source_link = source_link;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
