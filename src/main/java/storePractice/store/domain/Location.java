package storePractice.store.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
    private String LATITUDE;
    private String LONGITUDE;
}
