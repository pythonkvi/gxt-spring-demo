package com.example.gxtspringdemo.client;

import com.sencha.gxt.widget.core.client.box.AlertMessageBox;

public class AlertUtils {
    private AlertUtils() {
    }

    public static void showError(String msg) {
        AlertMessageBox alertMessageBox = new AlertMessageBox("Error", msg);
        alertMessageBox.show();
    }
}
