package io.shelfy.db_creator_appl.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "calls", indexes = {@Index(columnList = "caller_id")})
public class Call {
    @Id
    @GeneratedValue
    long id;
    LocalDateTime timestamp;
    @Column(name = "duration_in_seconds")
    long durationInSeconds;
    @ManyToOne
    @JoinColumn(name = "caller_id")
    Caller caller;
    @ManyToOne
    @JoinColumn(name = "called_party_id")
    Caller calledParty;

    public Call() {
    }

    public Call(LocalDateTime timestamp, long durationInSeconds, Caller caller, Caller calledParty) {
        this.timestamp = timestamp;
        this.durationInSeconds = durationInSeconds;
        this.caller = caller;
        this.calledParty = calledParty;
    }
}