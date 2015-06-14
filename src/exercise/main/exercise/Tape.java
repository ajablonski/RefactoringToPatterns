package exercise;

// The tape class represents a physical tape.

class Tape extends DomainObject {
    private String serialNumber;
    private Movie movie;

    public Tape(String serialNumber, Movie movie) {
        this.serialNumber = serialNumber;
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
