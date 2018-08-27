package com.ms.controller.viewmodel;

import org.springframework.web.multipart.MultipartFile;
import java.io.Serializable;
import java.util.List;

public class Product{
    private long id;
    private String name;
    private String description;
    private String price;
    private List<MultipartFile> images;
    

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price){
		this.price = price;
	}




}