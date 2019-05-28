package com.example.maaedupro.listeners;

import android.os.Bundle;

/**
 * Created by chandrapratapsingh on 2/19/18.
 */

public interface FragmentSelectionListener {

    void onFragmentSelected(int reqCode, Bundle data);

    void onFragmentSelected(int reqCode, Bundle data, boolean addTobackStack);
}
