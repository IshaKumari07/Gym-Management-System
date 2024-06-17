package com.example.demo.feignclient;

import org.springframework.data.annotation.Id;

public class EquipmentDTO {

	private int equipmentId;
	private String equipmentName;
	private String description;
	private String imageUrl;

	public int getEquipmentId() {
		return equipmentId;
	}
	public EquipmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public EquipmentDTO(int equipmentId, String equipmentName, String description,String imageUrl) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.description = description;
		this.imageUrl=imageUrl;
	}
	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", equipmentName=" + equipmentName + ", description="
				+ description +  "]";
	}
}
