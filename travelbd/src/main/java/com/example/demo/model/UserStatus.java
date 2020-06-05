package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Asus on 05-Jun-20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "status")
public class UserStatus {
    @Id
    @SequenceGenerator(name="pk",sequenceName="pk_status",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="pk")
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "locationId")
    private Long locationId;

    @Column(name = "privacyId")
    private Long privacyId;

//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
//
//    public void setLocationId(long locationId) {
//        this.locationId = locationId;
//    }
//
//    public void setPrivacyId(long privacyId) {
//        this.privacyId = privacyId;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }




//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
//    private Users users;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "locationId", referencedColumnName = "id", insertable = false, updatable = false)
//    private Location location;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "privacyId", referencedColumnName = "id", insertable = false, updatable = false)
//    private Privacy privacy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getPrivacyId() {
        return privacyId;
    }

    public void setPrivacyId(Long privacyId) {
        this.privacyId = privacyId;
    }
}
