package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fb1")
public class Feedback {
	
	@Id
	private String name; 
	@Column(name="pq")
	private int productQuality;
	@Column(name="pe")
	private int productEfficiency;
	private String feedback;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProductQuality() {
		return productQuality;
	}
	public void setProductQuality(int productQuality) {
		this.productQuality = productQuality;
	}
	public int getProductEfficiency() {
		return productEfficiency;
	}
	public void setProductEfficiency(int productEfficiency) {
		this.productEfficiency = productEfficiency;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [name=" + name + ", productQuality=" + productQuality + ", productEfficiency="
				+ productEfficiency + ", feedback=" + feedback + "]";
	}	
}
