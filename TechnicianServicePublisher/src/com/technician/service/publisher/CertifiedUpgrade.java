package com.technician.service.publisher;

public class CertifiedUpgrade {

	private String name;
	private String duration;
	private String nextFix;
	
	public CertifiedUpgrade(String name, String duration, String dose) {
		super();
		this.name = name;
		this.duration = duration;
		this.nextFix = dose;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getNextFix() {
		return nextFix;
	}

	public void setNextFix(String dose) {
		this.nextFix = dose;
	}
	
	
	
}
