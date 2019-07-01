package com.utec.yapenegocios;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class cardPaymentAdapter extends ArrayAdapter<Payments> {

    private static final String TAG = "cardPaymentAdapter";
    private List<Payments> cardList = new ArrayList<Payments>();


    static class CardViewHolder {
        TextView collaborador;
        TextView clase;
        TextView tipo;
        TextView precio;
    }

    public cardPaymentAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }


    @Override
    public void add(Payments object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Override
    public Payments getItem(int index) {
        return this.cardList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        cardPaymentAdapter.CardViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_payments, parent, false);
            viewHolder = new cardPaymentAdapter.CardViewHolder();
            viewHolder.collaborador = (TextView) ((View) row).findViewById(R.id.collaborador);
            viewHolder.clase = (TextView) ((View) row).findViewById(R.id.clase);
            viewHolder.tipo = (TextView) ((View) row).findViewById(R.id.tipo);
            viewHolder.precio = (TextView) ((View) row).findViewById(R.id.precio);
            row.setTag(viewHolder);
        } else {
            viewHolder = (cardPaymentAdapter.CardViewHolder)row.getTag();
        }
        Payments card = getItem(position);
        System.out.println("Objet  " + card.getDni());
        viewHolder.collaborador.setText(card.getDni());
        viewHolder.clase.setText(card.getTypeOfCollaborator());
        viewHolder.tipo.setText(card.getPayMethod());
        viewHolder.precio.setText(card.getAmount());

        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
