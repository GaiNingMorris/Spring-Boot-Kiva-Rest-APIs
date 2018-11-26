package com.kiva.codingExercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * lender information
 * @author ningm
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lender {

	private String name;
	
	private String uid;
	
	private Image image;
	
	@JsonProperty("lender_id")
	private String id;
	
	@JsonProperty("whereabouts")
	private String whereabouts;
	
	@JsonProperty("country_code")
	private String countryCode;
	
	public Lender() {
		
	}
	
	public Lender(String name, String countryCode) {
		this.name = name;
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWhereabouts() {
		return whereabouts;
	}

	public void setWhereabouts(String whereabouts) {
		this.whereabouts = whereabouts;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Lender [name=" + name + ", uid=" + uid + ", image=" + image + ", id=" + id + ", whereabouts="
				+ whereabouts + ", countryCode=" + countryCode + "]";
	}
}
