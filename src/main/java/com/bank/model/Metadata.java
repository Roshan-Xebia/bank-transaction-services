package com.bank.model;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
	private String narrative = null;
	private ArrayList<Object> comments = null;
	private ArrayList<Object> tags = null;
	private ArrayList<Object> images = null;
	private String where = null;

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public ArrayList<Object> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Object> comments) {
		this.comments = comments;
	}

	public ArrayList<Object> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Object> tags) {
		this.tags = tags;
	}

	public ArrayList<Object> getImages() {
		return images;
	}

	public void setImages(ArrayList<Object> images) {
		this.images = images;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

}