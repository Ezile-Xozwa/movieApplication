package za.ac.cput.domain;

/* Seat.java

     Seat POJO class

     Author: E Xozwa (221321101)

     Date: 11 May 2025 */

public class Seat {

    private String seatId;
    private char row;
    private int seatNumber;
    private Status status;
    public enum Status{Available, Booked};

    private Seat(){

    }

    private Seat(Builder builder){
        this.seatId = builder.seatId;
        this.row = builder.row;
        this.seatNumber = builder.seatNumber;
        this.status = builder.status;
    }

    public String getSeatId(){
        return seatId;
    }

    public char getRow(){
        return row;
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
                + "Row: " + row + "\n"
                + "Seat Number: " + seatNumber + "\n"
                + "Status: " + status + "\n";
    }

    public static class Builder {
        private String seatId;
        private char row;
        private int seatNumber;
        private Status status = Status.Available;

        public Builder setSeatId(String seatId) {
            this.seatId = seatId;
            return this;
        }

        public Builder setRow(char row) {
            this.row = row;
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
            this.row = seat.row;
            this.seatNumber = seat.seatNumber;
            this.status = seat.status;
            return this;
        }

        public Seat build(){
            return new Seat(this);
        }
    }
}

