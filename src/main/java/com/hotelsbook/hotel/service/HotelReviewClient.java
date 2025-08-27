package com.hotelsbook.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelsbook.hotel.dto.HotelReviewDto;

@Service
public class HotelReviewClient {

    @Value("${microservice.reviews.url}")
    private String reviewsUrl;

    private final RestTemplate restTemplate;

    public HotelReviewClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    /**
     * Llama al microservicio de reviews de hotel para obtener las reviews de los hoteles dados sus IDs.
     * @param hotelIds
     * @return
     */
    public List<HotelReviewDto> getHotelReviews(List<Long> hotelIds) {
        String hotelIdsParam = hotelIds.stream().map(String::valueOf).collect(Collectors.joining(","));
        String url = reviewsUrl + "/" + hotelIdsParam;

        ResponseEntity<List<HotelReviewDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<HotelReviewDto>>() {

                });

        return response.getBody();
    }

}
