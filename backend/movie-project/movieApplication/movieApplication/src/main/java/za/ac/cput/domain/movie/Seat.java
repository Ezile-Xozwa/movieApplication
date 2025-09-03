package za.ac.cput.domain.movie;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;



@Entity //needs jpa dependency
@Table(name = "seat")
public class Seat {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Use DB-generated ID
    @Id
    private String seatId;

    @Column(name = "seat_row")
    private char seatRow;

    private int seatNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{Available, Booked};

    protected Seat(){ //so the objects aren't created out of this package

    }

    private Seat(Builder builder){
        this.seatId = builder.seatId;
        this.seatRow = builder.seatRow;
        this.seatNumber = builder.seatNumber;
        this.status = builder.status;
    }

    public String getSeatId(){
        return seatId;
    }

    //@JsonProperty("seatRow")
    @Column(name = "seat_row")
    public char getSeatRow(){
        return seatRow;
    }

    public int getSeatNumber(){
        return seatNumber;
    }

    public Status getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return "Seat ID: " + seatId + "\n"
                + "Seat Row: " + seatRow + "\n"
                + "Seat Number: " + seatNumber + "\n"
                + "Status: " + status + "\n";
    }

    public static class Builder {
        private String seatId;
        private char seatRow;
        private int seatNumber;
        //private Status status = Status.Available;
        private Status status;

        public Builder setSeatId(String seatId) {
            this.seatId = seatId;
            return this;
        }

        public Builder setSeatRow(char seatRow) {
            this.seatRow = seatRow;
            return this;
        }

        public Builder setSeatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder copy(Seat seat) {
            this.seatId = seat.seatId;
            this.seatRow = seat.seatRow;
            this.seatNumber = seat.seatNumber;
            this.status = seat.status;
            return this;
        }

        public Seat build(){
            return new Seat(this);
        }
    }
}

