package com.example.UberReviewService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends Base{
    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings;
}
