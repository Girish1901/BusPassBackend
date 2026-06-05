package com.busPassSys.busPassSys.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "routes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private String routeName;
    private String starPoint;
    private String endPoint;
    private Double fare;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
