package models;


import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocationDetails extends Model {

    @Id@GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String userName;
    public String latitude;
    public String longitude;
    public String timestamp;


}
