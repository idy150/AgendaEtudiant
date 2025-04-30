package com.example.agendaetudiant;


public class Event {
    private int id;
    private String title;
    private String date;
    private String type;

    public Event(int id, String title, String date, String type) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.type = type;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getType() { return type; }
}
