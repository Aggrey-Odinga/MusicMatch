package com.moringaschool.musicmatch.util;

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
