package ninja.poepoe.recyclerviewplayground;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Poe Poe on 19/9/16.
 */

public class SimpleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private List<String> listItems;
  private CustomClickListener onClickListener;

  public SimpleListAdapter(List<String> listItems) {
    this.listItems = listItems;
  }

  public void setOnClickListener(CustomClickListener onClickListener) {
    this.onClickListener = onClickListener;
  }

  public void setListItems(List<String> listItems) {
    this.listItems = listItems;
    //notify the whole data range has changed
    notifyDataSetChanged();
  }

  public void addMoreListItems(List<String> newListItems) {
    this.listItems.addAll(newListItems);
    //notify there are newly added items
    notifyItemRangeChanged(listItems.size() - newListItems.size(), newListItems.size());
  }

  public void deleteItem(int position) {
    listItems.remove(position);
    notifyItemRemoved(position);
  }

  public void addItemAtLastPosition(String string) {
    listItems.add(string);
    //notify item is added at the last of row
    notifyItemInserted(listItems.size() - 1);
  }

  public void addItemAtFristPosition(String string) {
    listItems.add(0, string);
    //notify item is added at the first row
    notifyItemInserted(0);
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.row_simple_list, parent, false);
    return new SimpleViewHolder(view);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    String string = listItems.get(position);
    SimpleViewHolder simpleViewHolder = (SimpleViewHolder) holder;
    simpleViewHolder.textView.setText(string);
  }

  @Override public int getItemCount() {
    return listItems.size();
  }

  public class SimpleViewHolder extends RecyclerView.ViewHolder
      implements View.OnClickListener, View.OnLongClickListener {
    TextView textView;
    public SimpleViewHolder(View itemView) {
      super(itemView);

      textView = (TextView) itemView.findViewById(R.id.textView);

      //set normal on click listener
      itemView.setOnClickListener(this);

      //set normal on long click listener
      itemView.setOnLongClickListener(this);
    }

    @Override public void onClick(View view) {
      int position = getAdapterPosition();

      // getAdapterPosition() will be -1 if recyclerview is recalculating item ranged
      //if user click in that time it will return -1
      //then we will ignore the click event
      if (position == -1) return; //the rest line will not execute if position ==-1

      onClickListener.onItemClick(position);
    }

    @Override public boolean onLongClick(View view) {

      int position = getAdapterPosition();

      // getAdapterPosition() will be -1 if recyclerview is recalculating item ranged
      //if user click in that time it will return -1
      //then we will ignore the click event
      if (position == -1) return false; // nothing to do

      onClickListener.onItemLongClick(position);

      return true;
    }
  }
}
