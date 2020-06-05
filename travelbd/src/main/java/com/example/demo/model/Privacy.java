package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by Asus on 05-Jun-20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "privacy")
public class Privacy {
    @Id
    @SequenceGenerator(name="pk",sequenceName="pk_privacy",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="pk")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
