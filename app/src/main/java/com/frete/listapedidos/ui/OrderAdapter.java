package com.frete.listapedidos.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.frete.listapedidos.databinding.ListItemOrderBinding;
import com.frete.listapedidos.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<Order> orderList = new ArrayList<>();

    public OrderAdapter() {}

    OrderAdapter(List<Order> orderList) {
        this.orderList = orderList != null ? orderList : new ArrayList<>();
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemOrderBinding binding = ListItemOrderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new OrderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.bind(order);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public void updateOrders(List<Order> newOrders) {
        if (newOrders == null) {
            newOrders = new ArrayList<>();
        }
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new OrderDiffCallback(orderList, newOrders));
        orderList.clear();
        orderList.addAll(newOrders);
        diffResult.dispatchUpdatesTo(this);
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        private final ListItemOrderBinding binding;

        public OrderViewHolder(@NonNull ListItemOrderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Order order) {
            binding.fieldNameClient.setText(order.getName());
            binding.fieldProduct.setText(order.getProduct());
            binding.fieldQuantity.setText(String.format("Quantidade: %d", order.getQuantity()));
            binding.fieldTotal.setText(String.format("Total: R$ %.2f", order.getTotal()));
        }
    }

    static class OrderDiffCallback extends DiffUtil.Callback {
        private final List<Order> oldList;
        private final List<Order> newList;

        OrderDiffCallback(List<Order> oldList, List<Order> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            String oldId = oldList.get(oldItemPosition).getId();
            String newId = newList.get(newItemPosition).getId();
            return oldId != null && newId != null && oldId.equals(newId);
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
        }
    }
}
