package pl.michal.olszewski.dailyprogrammer.intermediate.aeroplane;

import lombok.Getter;

@Getter
public class AeroplanePOJO {

  private final String icao24;
  private final String callSign;
  private final String country;
  private final Double longitude;
  private final Double latitude;

  public AeroplanePOJO(String icao24, String callSign, String country, Double longitude, Double latitude) {
    this.icao24 = icao24;
    this.callSign = callSign;
    this.country = country;
    this.longitude = longitude;
    this.latitude = latitude;
  }

  @Override
  public String toString() {
    return "AeroplanePOJO{" +
        "icao24='" + icao24 + '\'' +
        ", callSign='" + callSign + '\'' +
        ", country='" + country + '\'' +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        '}';
  }
}
