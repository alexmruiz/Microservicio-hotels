package com.hotelsbook.hotel.dto;

import java.util.List;

public class HotelServiceDto {

    private Long hotelId;
    
    private String hotelName;

    private List<ServiceDto> services;

    //Getter and Setter
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<ServiceDto> getServices() {
        return services;
    }

    public void setServices(List<ServiceDto> services) {
        this.services = services;
    }

    
}
