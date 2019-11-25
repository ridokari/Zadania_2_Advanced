package com.company;

import java.util.Objects;

public class Polimorf {
    Polimorf(String odmiana, String podst) {
        this.odmiana = odmiana;
        this.podst = podst;
    }

    public Polimorf(String odmiana) {
        this.odmiana = odmiana;
    }


    public void setOdmiana(String odmiana) {
        this.odmiana = odmiana;
    }

    public void setPodst(String podst) {
        this.podst = podst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polimorf polimorf = (Polimorf) o;
        return Double.compare(polimorf.id, id) == 0 &&
                Objects.equals(odmiana, polimorf.odmiana) &&
                Objects.equals(podst, polimorf.podst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, odmiana, podst);
    }

    private double id;

    @Override
    public String toString() {
        return "Polimorf{" +
                "id=" + id +
                ", odmiana='" + odmiana + '\'' +
                ", podst='" + podst + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public Polimorf(double id, String odmiana, String podst) {
        this.id = id;
        this.odmiana = odmiana;
        this.podst = podst;
    }

    public double getId() {
        return id;
    }

    private String odmiana;
    private String podst;

    String getOdmiana() {
        return odmiana;
    }

    String getPodst() {
        return podst;
    }
}
