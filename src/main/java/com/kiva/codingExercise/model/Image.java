package com.kiva.codingExercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * image information
 * @author ningm
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

	private long id;
	
	@JsonProperty("template_id")
	private long templateId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", templateId=" + templateId + "]";
	}
}
