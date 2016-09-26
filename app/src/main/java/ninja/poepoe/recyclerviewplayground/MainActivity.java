package ninja.poepoe.recyclerviewplayground;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, CustomClickListener {
  private RecyclerView rvListItems;
  private SimpleListAdapter adapter;
  private FloatingActionButton fabAdd;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    rvListItems = (RecyclerView) findViewById(R.id.rvListItems);
    fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);

    //Vertical Orientation
    LinearLayoutManager verticalLayoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

    rvListItems.setLayoutManager(verticalLayoutManager);

    List<String> strings = RandomTextGenerator.randomList(10);
    adapter = new SimpleListAdapter(strings);
    //set click listener
    adapter.setOnClickListener(this);

    adapter.setOnClickListener(new CustomClickListener() {
      @Override public void onItemClick(int position) {

      }

      @Override public void onItemLongClick(int position) {

      }

      @Override public void onDeleteItemClick(int position) {

      }
    });
    //set adapter to recyclerview
    rvListItems.setAdapter(adapter);

    //  set OnClickListener to fab
    fabAdd.setOnClickListener(this);
  }

  @Override public void onClick(View view) {
    adapter.addItemAtFristPosition(RandomTextGenerator.randomString(5));
    Toast.makeText(this, String.format(Locale.ENGLISH, "Add Item at first position"),
        Toast.LENGTH_SHORT).show();
  }

  @Override public void onItemClick(int position) {
    Toast.makeText(this, String.format(Locale.ENGLISH, "Normal Click at position %d", position),
        Toast.LENGTH_SHORT).show();
  }

  @Override public void onItemLongClick(int position) {
    Toast.makeText(this, String.format(Locale.ENGLISH, "Long Click at position %d", position),
        Toast.LENGTH_SHORT).show();
  }

  @Override public void onDeleteItemClick(int position) {
    Toast.makeText(this, String.format(Locale.ENGLISH, "Delete Item at position %d", position),
        Toast.LENGTH_SHORT).show();
    adapter.deleteItem(position);
  }
}
