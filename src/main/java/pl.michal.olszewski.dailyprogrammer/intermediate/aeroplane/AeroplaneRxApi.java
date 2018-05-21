package pl.michal.olszewski.dailyprogrammer.intermediate.aeroplane;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AeroplaneRxApi {

  @GET("all")
  Observable<AeroplaneJson> getAllAeroplanes();

}