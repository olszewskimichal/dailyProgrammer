package pl.michal.olszewski.dailyprogrammer.intermediate;

import io.reactivex.schedulers.Schedulers;
import java.util.Comparator;
import java.util.concurrent.Executors;
import pl.michal.olszewski.dailyprogrammer.intermediate.aeroplane.AeroplaneJson;
import pl.michal.olszewski.dailyprogrammer.intermediate.aeroplane.AeroplanePOJO;
import pl.michal.olszewski.dailyprogrammer.intermediate.aeroplane.AeroplaneRxApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindNearestAeroplane {

  private static double myLat = 53.153818;
  private static double myLong = 18.139250;


  public static void main(String[] args) throws InterruptedException {

    final Retrofit retrofit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://opensky-network.org/api/states/")
        .build();

    final AeroplaneRxApi service = retrofit.create(AeroplaneRxApi.class);
    service.getAllAeroplanes()
        .subscribeOn(Schedulers.from(Executors.newFixedThreadPool(4)))
        .flatMapIterable(AeroplaneJson::getStates)
        .filter(v -> v.get(5) != null && v.get(6) != null)
        .map(v -> new AeroplanePOJO(v.get(0), v.get(1), v.get(2), Double.valueOf(v.get(5)), Double.valueOf(v.get(6))))
        .sorted(Comparator.comparingDouble(v -> distance(v.getLongitude(), v.getLatitude())))
        .firstOrError()
        .subscribe(System.out::println);

    Thread.sleep(2000);
    System.exit(0);

  }

  private static double distance(double aeroLongitude, double aeroLatitude) {
    return Math.sqrt(Math.pow(myLong - aeroLongitude, 2) + Math.pow(myLat - aeroLatitude, 2));
  }
}
