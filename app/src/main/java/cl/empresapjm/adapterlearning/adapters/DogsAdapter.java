package cl.empresapjm.adapterlearning.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.empresapjm.adapterlearning.Dog;
import cl.empresapjm.adapterlearning.R;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder>{

    public DogsAdapter(List<Dog> dogs) {
        this.dogs = dogs;
    }

    //private List<Dog> dogs = new ArrayList<>();
    private List<Dog> dogs;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_dog, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Dog dog = dogs.get(position);
        holder.name.setText(dog.getName());
        holder.breed.setText(dog.getBreed());
    }

    public void add(Dog dog){
        dogs.add(0, dog);
        //notifyDataSetChanged();
        notifyItemInserted(0);
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name, breed;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTv);
            breed = itemView.findViewById(R.id.breedTv);
        }
    }
}
