package com.sirin.pojos;

public class BookingResponsePojo {
    /*
    {
        "bookingid": 11,
            "booking": {
        "firstname": "Selim",
                "lastname": "Ak",
                "totalprice": 15000,
                "depositpaid": true,
                "bookingdates": {
            "checkin": "2020-09-09",
                    "checkout": "2020-09-21"
        }
    }
    }*/

    private int bookingid;
    private com.sirin.pojos.BookingPojo booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public com.sirin.pojos.BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(com.sirin.pojos.BookingPojo booking) {
        this.booking = booking;
    }

    public BookingResponsePojo() {
    }

    public BookingResponsePojo(int bookingid, com.sirin.pojos.BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
