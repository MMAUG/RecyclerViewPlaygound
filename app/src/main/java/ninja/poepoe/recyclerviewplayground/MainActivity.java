package ninja.poepoe.recyclerviewplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private RecyclerView rvListItems;
  private SimpleListAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    rvListItems = (RecyclerView) findViewById(R.id.rvListItems);

    //Vertical Orientation
    LinearLayoutManager verticalLayoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

    rvListItems.setLayoutManager(verticalLayoutManager);

    List<String> strings =  Arrays.asList("A", "B", "C", "D", "E", "F");
    adapter = new SimpleListAdapter(strings);

    rvListItems.setAdapter(adapter);
  }
}
