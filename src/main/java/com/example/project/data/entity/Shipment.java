package com.example.project.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="shipment")

public class Shipment extends BaseEntity {
    private long id;

    @OneToOne
    @JoinColumn(name="sender")
    private Clients sender;

    @OneToOne
    @JoinColumn(name="receiver")
    private Clients receiver;

    @OneToOne
    @JoinColumn(name="address_for_sending")
    private Address address;

    @JoinColumn(name="weight")
    private double weight;
}
