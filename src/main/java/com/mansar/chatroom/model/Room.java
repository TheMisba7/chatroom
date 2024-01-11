package com.mansar.chatroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "visible", nullable = false)
    private boolean isVisible;
    @Column(name = "maxUsers", nullable = false)
    private short maxUsers;
    @Column(name = "minUsers", nullable = false)
    private short minUsers = 2;
    @Column(name = "topic", nullable = false)
    private String topic;
    @Column(name = "langauge", nullable = false)
    private String language;
    @OneToOne
    private User owner;
    @OneToMany
    private List<User> participants;
}
