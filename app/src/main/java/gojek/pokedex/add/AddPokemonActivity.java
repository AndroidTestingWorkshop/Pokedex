package gojek.pokedex.add;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import gojek.pokedex.R;

public class AddPokemonActivity extends AppCompatActivity implements AddPokemonView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokemon);
    }

    @Override
    public void showPopupError(String errorMessage) {
        new AlertDialog.Builder(this)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setMessage(errorMessage)
                .setTitle("Alert")
                .show();
    }

    @Override
    public void showSuccessNotification() {
        Toast.makeText(this, "Pokemon has been successfully added", Toast.LENGTH_LONG).show();
    }
}
