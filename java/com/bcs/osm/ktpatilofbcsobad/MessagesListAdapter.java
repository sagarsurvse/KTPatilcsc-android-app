package com.bcs.osm.ktpatilofbcsobad;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Mark on 21/11/2018.
 */

public class MessagesListAdapter extends ArrayAdapter<MessageCell> {
    MessageCell[] cellItem = null;
    Context context;
    public MessagesListAdapter(Context context, MessageCell[] resource) {
        super(context, R.layout.message_cell, resource);

        this.context = context;
        this.cellItem = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        if (cellItem[position].getSender()) {
            convertView = inflater.inflate(R.layout.sender_message_cell, parent, false);
        } else {
            convertView = inflater.inflate(R.layout.message_cell, parent, false);
        }

        TextView sender = (TextView) convertView.findViewById(R.id.photoName);
        sender.setText(cellItem[position].getMessageSender());

        TextView wish = (TextView) convertView.findViewById(R.id.wishMessage);
        wish.setText(cellItem[position].getMessageText());

        TextView dateTime = (TextView) convertView.findViewById(R.id.dateTime);
        dateTime.setText(cellItem[position].getMessageDateTime());

        return convertView;
    }
}
