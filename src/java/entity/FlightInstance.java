/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author pagh
 */
@Entity
public class FlightInstance implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Flight flight;
    private String flightId;
    private String dato;
    private String tid;
    private short availableSeats;
    private float price;
    @OneToMany(mappedBy = "fi")
    private List<Reservation> reservations;

    public void addReservation(Reservation r)
    {
        reservations.add(r);
    }

    public void removeReservation(Reservation r)
    {
        reservations.remove(r);
    }

    public FlightInstance()
    {
    }

    public FlightInstance(Flight flight, String flightId, String dato, String tid, short availableSeats, float price, List<Reservation> reservations)
    {
        this.flight = flight;
        this.flightId = flightId;
        this.dato = dato;
        this.tid = tid;
        this.availableSeats = availableSeats;
        this.price = price;
        this.reservations = reservations;
    }

    public Flight getFlight()
    {
        return flight;
    }

    public void setFlight(Flight flight)
    {
        this.flight = flight;
    }

    public String getFlightId()
    {
        return flightId;
    }

    public void setFlightId(String flightId)
    {
        this.flightId = flightId;
    }

    public String getDato()
    {
        return dato;
    }

    public void setDato(String dato)
    {
        this.dato = dato;
    }

    public String getTid()
    {
        return tid;
    }

    public void setTid(String tid)
    {
        this.tid = tid;
    }

    public short getAvailableSeats()
    {
        return availableSeats;
    }

    public void setAvailableSeats(short availableSeats)
    {
        this.availableSeats = availableSeats;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public List<Reservation> getReservations()
    {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations)
    {
        this.reservations = reservations;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlightInstance))
        {
            return false;
        }
        FlightInstance other = (FlightInstance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.FlightInstance[ id=" + id + " ]";
    }

}