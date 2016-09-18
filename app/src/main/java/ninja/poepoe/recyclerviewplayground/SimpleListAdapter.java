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

  public SimpleListAdapter(List<String> listItems) {
    this.listItems = listItems;
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

  public class SimpleViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public SimpleViewHolder(View itemView) {
      super(itemView);
      textView = (TextView) itemView.findViewById(R.id.textView);
    }
  }
}
