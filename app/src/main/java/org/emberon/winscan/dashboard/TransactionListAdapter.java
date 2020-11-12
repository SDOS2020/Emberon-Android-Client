package org.emberon.winscan.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.emberon.winscan.R;
import org.emberon.winscan.domain.entity.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    List<Transaction> transactionList = new ArrayList<Transaction>();
    public TransactionListAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.framelayout_transactions;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        holder.getTransactionID().setText(transactionList.get(position).getId());
        holder.getDateOfTransaction().setText(dateFormat.format(transactionList.get(position).getTransactionDate()));
        holder.getPayeeName().setText(transactionList.get(position).getPayeeName());
        holder.getAmountPaid().setText(String.valueOf(transactionList.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }
}