package ninja.poepoe.recyclerviewplayground;

/**
 * Created by Poe Poe on 24/9/16.
 */

public interface CustomClickListener {
  void onItemClick(int position);

  void onItemLongClick(int position);

  void onDeleteItemClick(int position);
}

