package com.example.JPAApplication.Entity;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

                @Embeddable
                public class Address {
                @GeneratedValue(strategy = GenerationType.AUTO)
                private int add_id;
                private  int streetnumber;
                private String location;
                private String state;

                public int getStreetnumber() {
                    return streetnumber;
                }

                public void setStreetnumber(int streetnumber) {
                    this.streetnumber = streetnumber;
                }

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }
            }
