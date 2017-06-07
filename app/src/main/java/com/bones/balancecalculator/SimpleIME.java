package com.bones.balancecalculator;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

/**
 * Created by lenovo ip on 06/06/2017.
 */

    public class SimpleIME extends InputMethodService
            implements KeyboardView.OnKeyboardActionListener {

        private KeyboardView kv;
        private Keyboard keyboard;
        Activity target;

        public SimpleIME(Activity target){
            this.target = target;
        }




        private boolean caps = false;

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {

            long eventTime = System.currentTimeMillis();
            KeyEvent event = new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_DOWN, primaryCode, 0, 0, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE);
            target.dispatchKeyEvent(event);



        }


        @Override
        public void onPress(int primaryCode) {
        }

        @Override
        public void onRelease(int primaryCode) {
        }

        @Override
        public void onText(CharSequence text) {



        }

        @Override
        public void swipeDown() {
        }

        @Override
        public void swipeLeft() {
        }

        @Override
        public void swipeRight() {
        }

        @Override
        public void swipeUp() {
        }

    @Override
    public View onCreateInputView() {
        kv = (KeyboardView)getLayoutInflater().inflate(R.layout.activity_main, null);
        keyboard = new Keyboard(this, R.layout.keyboard);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }

    }


