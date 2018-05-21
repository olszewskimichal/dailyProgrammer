package pl.michal.olszewski.dailyprogrammer.intermediate.aeroplane;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class AeroplaneJson {

  @SerializedName("time")
  @Expose
  public Long time;

  @SerializedName("states")
  @Expose
  public List<List<String>> states = null;


}