package com.rajasharan.naughtystringskeyboard;

import android.inputmethodservice.InputMethodService;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rajasharan on 8/15/15.
 */
public class NaughtyStringsIME extends InputMethodService implements View.OnClickListener {
    private static final String TAG = "NaughtyStringsIME";

    @Override
    public View onCreateInputView() {
        ViewGroup keyboardLayout = new KeyboardLayout(this, getBaseContext());
        return keyboardLayout;
    }

    @Override
    public void onClick(View v) {
        String string = ((TextView)v).getText().toString();
        Log.d(TAG, string);
        getCurrentInputConnection().commitText(string, 1);
    }

    public void clearText() {
        getCurrentInputConnection().deleteSurroundingText(1000,0);
    }
}
