package com.mitchell.esparza.tablemaster.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//java util imports
import java.util.Date;
//spring security imports
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tables")
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Guest name is required!")
    @Size(min=2, max=30, message="Guest name must be at least 2 characters!")
    private String guestName;

    @Min(value=1, message="Number of guests must be at least 1!")
    @Max(value=10, message="Number of guests must be at most 10!")
    private Long numOfGuests;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    public UserTable() {
        //empty constructor
    }
    @PrePersist
    public void setCreationDate() { //this sets the creation date of the table
        this.createdAt = new Date();
    }

    //getters and setters
    public User getUser() { //this gets the user that created the table
        return this.user;
    }

    public void setUser(User user) { //this sets the user that created the table
        this.user = user;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return this.guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Long getNumOfGuests() {
        return this.numOfGuests;
    }

    public void setNumOfGuests(Long numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
