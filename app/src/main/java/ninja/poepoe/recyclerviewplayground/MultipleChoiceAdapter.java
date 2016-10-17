package ninja.poepoe.recyclerviewplayground;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Poe Poe on 17/10/16.
 */

public class MultipleChoiceAdapter
    extends RecyclerView.Adapter<MultipleChoiceAdapter.MultipleChoiceHolder> {

  private ArrayList<String> dataList = new ArrayList<>();
  private HashSet<String> chosenList;

  public MultipleChoiceAdapter(HashSet<String> chosenList) {
    this.chosenList = chosenList;
  }

  public void setDataList(ArrayList<String> dataList) {
    this.dataList = dataList;
    notifyDataSetChanged();
  }

  public void removeItem(String item) {
    chosenList.remove(item);
    notifyDataSetChanged();
  }

  public HashSet<String> getChosenList() {
    return chosenList;
  }

  @Override public MultipleChoiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.row_multiple_choice, parent, false);
    MultipleChoiceHolder holder = new MultipleChoiceHolder(view);
    holder.bindListeners(new ClickHandler(holder));
    return holder;
  }

  @Override public void onBindViewHolder(MultipleChoiceHolder holder, int position) {
    String item = dataList.get(position);
    holder.bindItem(item, chosenList.contains(item));
  }

  @Override public int getItemCount() {
    return dataList.size();
  }

  static class MultipleChoiceHolder extends RecyclerView.ViewHolder {

    private TextView tvCheckboxLabel;
    private CheckBox checkbox;

    public MultipleChoiceHolder(View itemView) {
      super(itemView);
      tvCheckboxLabel = (TextView) itemView.findViewById(R.id.tvCheckboxLabel);
      checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
    }

    void bindListeners(ClickHandler handler) {
      itemView.setOnClickListener(handler);
      checkbox.setOnClickListener(handler);
    }

    void bindItem(String item, boolean checked) {
      tvCheckboxLabel.setText(item);
      checkbox.setChecked(checked);
    }
  }

  private class ClickHandler implements View.OnClickListener {
    MultipleChoiceHolder vh;

    ClickHandler(MultipleChoiceHolder vh) {
      this.vh = vh;
    }

    @Override public void onClick(View v) {
      String item = dataList.get(vh.getAdapterPosition());
      if (chosenList.contains(item)) {
        chosenList.remove(item);
        vh.checkbox.setChecked(false);
      } else {
        chosenList.add(item);
        vh.checkbox.setChecked(true);
      }
    }
  }
}
